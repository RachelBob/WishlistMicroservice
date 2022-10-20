package com.lti.wishlistservice.service.Impl;

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
	public Optional<WishlistProduct> getWishlistProductByUuid(String wishlist_uuid) {
		return Optional.empty();
	}

	@Override
	public List<Wishlist> getAllWishlistProduct() {
		return null;
	}

	@Override
	public Wishlist updateWishlistProduct(WishlistProduct wishlist, String uuid) {
		return null;
	}

	@Override
	public void deleteWishlistProduct(String uuid) {

	}


}
