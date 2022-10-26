package com.lti.wishlistservice.service;

import java.util.List;
import java.util.Optional;

import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.model.WishlistProduct;

public interface WishlistProductService {
	
	public Optional<Wishlist> getWishlistProductByUuid(String wishlist_uuid);
	 
	List<Wishlist> getAllWishlistProduct();
	
	Wishlist saveWishlistProduct(Wishlist wishlistProduct);
	
	WishlistProduct updateWishlistProduct(WishlistProduct wishlist);
	
	public void deleteWishlistProduct(String uuid);

}
