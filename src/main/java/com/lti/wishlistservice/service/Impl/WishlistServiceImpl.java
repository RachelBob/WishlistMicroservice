package com.lti.wishlistservice.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.repository.WishlistRepository;
import com.lti.wishlistservice.service.WishlistService;


@Service
public class WishlistServiceImpl implements WishlistService {

	private static final Logger logger = LoggerFactory.getLogger("WishlistServiceImpl.class");

	@Autowired
	private WishlistRepository wishlistRepository;

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
		UUID uuid = Generators.timeBasedGenerator().generate();
		wishlist.setUuid(uuid.toString());
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
	

}
