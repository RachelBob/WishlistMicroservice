package com.lti.wishlistservice.service;

import java.util.List;

import com.lti.wishlistservice.model.Wishlist;

public interface WishlistService {
	
	public Wishlist getWishlistById(Long wishlist_id);
	 
	List<Wishlist> getAllWishlist();
	
	Wishlist saveWishlist(Wishlist wishlist);
	
	Wishlist updateWishlist(Wishlist wishlist, Long id);
	
	public void deleteWishlistById(Long wishlist_id);
	

}
