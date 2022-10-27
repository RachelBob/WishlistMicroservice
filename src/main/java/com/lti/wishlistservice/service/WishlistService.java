package com.lti.wishlistservice.service;

import java.util.List;
import java.util.Optional;

import com.lti.wishlistservice.model.Wishlist;

public interface WishlistService {
	
	public Optional<Wishlist> getWishlistByUuid(String wishlist_uuid);
	 
	List<Wishlist> getAllWishlist();
	
	Wishlist saveWishlist(Wishlist wishlist);
	
	Wishlist updateWishlist(Wishlist wishlist);
	
	public void deleteWishlist(String uuid);
	
	List<Wishlist> getAllWishlistByCustomerUuid(String customerUUID);
	

}
