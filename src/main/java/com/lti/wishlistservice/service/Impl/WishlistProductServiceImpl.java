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
	public Wishlist saveWishlistProduct(Wishlist wishlistProductReq) {
		UUID uuid = Generators.timeBasedGenerator().generate();

		for (WishlistProduct wishlistProd : wishlistProductReq.getWishlistProduct()) {
			wishlistProd.setUuid(uuid.toString());
		}
		Optional<Wishlist> WishlistData = wishlistRepository.findByUuid(wishlistProductReq.getUuid());
		WishlistData.get().setWishlistProduct(wishlistProductReq.getWishlistProduct());
		return wishlistRepository.save(WishlistData.get());
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
