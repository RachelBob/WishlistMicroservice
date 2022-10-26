package com.lti.wishlistservice.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.model.WishlistProduct;
import com.lti.wishlistservice.repository.WishlistProductRepository;
import com.lti.wishlistservice.repository.WishlistRepository;
import com.lti.wishlistservice.service.WishlistProductService;

@Service
public class WishlistProductServiceImpl implements WishlistProductService {

	@Autowired
	private WishlistProductRepository wishlistProductRepository;

	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Override
	public Wishlist saveWishlistProduct(Wishlist wishlistReq) {
		UUID uuid = Generators.timeBasedGenerator().generate();
		Optional<Wishlist> WishlistData = wishlistRepository.findByUuid(wishlistReq.getUuid());
		for (WishlistProduct wishlistProd : wishlistReq.getWishlistProduct()) {
			wishlistProd.setUuid(uuid.toString());
			wishlistProd.setWishlist(WishlistData.get());
			wishlistProductRepository.save(wishlistProd);
		}
		return wishlistReq;
	}

	@Override
	public Optional<Wishlist> getWishlistProductByUuid(String wishlist_uuid) {
		return wishlistRepository.findByUuid(wishlist_uuid);
	}

	@Override
	public List<Wishlist> getAllWishlistProduct() {
		return wishlistRepository.findAll();
	}
	
	@Override
	public void deleteWishlistProduct(String uuid) {
		WishlistProduct uuId = wishlistProductRepository.findByUuid(uuid).get();
		Long wishlistid = uuId.getWishlistproduct_id();
		wishlistProductRepository.deleteById(wishlistid);
	}

	@Override
	public WishlistProduct updateWishlistProduct(WishlistProduct wishlistReq, String uuid) {
		
		WishlistProduct prodListById = wishlistProductRepository.findByUuid(uuid).get();
		
		if(wishlistReq.getDescription() !=null) {
			prodListById.setDescription(wishlistReq.getDescription());
		}
		
		if(wishlistReq.getPrice() !=null) {
			prodListById.setPrice(wishlistReq.getPrice());
		}
		
		if(wishlistReq.getProductname() !=null) {
			prodListById.setProductname(wishlistReq.getProductname());
		}
		
		return wishlistProductRepository.save(prodListById);
	}


}
