package com.lti.wishlistservice.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.lti.wishlistservice.consumer.CustomerDetailsConsumer;
import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.repository.WishlistRepository;
import com.lti.wishlistservice.service.WishlistService;


@Service
public class WishlistServiceImpl implements WishlistService {

	private static final Logger logger = LoggerFactory.getLogger("WishlistServiceImpl.class");

	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Autowired
	private CustomerDetailsConsumer customerConsumer;

	@Override
	public Optional<Wishlist> getWishlistByUuid(String wishlist_uuid) {
		return wishlistRepository.findByUuid(wishlist_uuid);
	}
	
	@Override
	public List<Wishlist> getAllWishlist() {
		return wishlistRepository.findAll();
	}

	@Override
	public Wishlist saveWishlist(Wishlist wishlist) {
		String custStrObj = customerConsumer.getCustomerByUUID(wishlist.getCustomer_uuid());
		try {
			JSONObject custJsonObj = new JSONObject(custStrObj);
			UUID uuid = Generators.timeBasedGenerator().generate();
			wishlist.setUuid(uuid.toString());
			wishlist.setCustomer_id(Long.parseLong(custJsonObj.get("customerId").toString()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wishlistRepository.save(wishlist);
	}

	@Override
	public Wishlist updateWishlist(Wishlist wishlist) {
		Wishlist wishlistObj = wishlistRepository.findByUuid(wishlist.getUuid()).get();
		wishlistObj.setName(wishlist.getName());
		return wishlistRepository.save(wishlistObj);
	}
	
	@Override
	public void deleteWishlist(String uuid) {
		Wishlist uuId = wishlistRepository.findByUuid(uuid).get();
		Long wishlistid = uuId.getWishlist_id();
		wishlistRepository.deleteById(wishlistid);
	}
	
	@Override
	public List<Wishlist> getAllWishlistByCustomerUuid(String customeruuid) {
		String custStrObj = customerConsumer.getCustomerByUUID(customeruuid);
		JSONObject custJsonObj;
		List<Wishlist> wishlistResp = null;
		try {
			custJsonObj = new JSONObject(custStrObj);
			wishlistResp = wishlistRepository.findByCustomer_id(Long.parseLong(custJsonObj.get("customerId").toString()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wishlistResp;
	}
	

}
