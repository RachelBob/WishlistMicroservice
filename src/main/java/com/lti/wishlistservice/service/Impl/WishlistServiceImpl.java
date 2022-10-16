package com.lti.wishlistservice.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.wishlistservice.exception.ResourceNotFoundException;
import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.repository.WishlistProductRepository;
import com.lti.wishlistservice.repository.WishlistRepository;
import com.lti.wishlistservice.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;

	@Autowired
	private WishlistProductRepository productRepository;
	
	@Override
	public Wishlist getWishlistById(Long wishlist_id) {
		return wishlistRepository.findById(wishlist_id).orElseThrow(()-> 
		new ResourceNotFoundException("Wishlist", "wishlist_id", wishlist_id));
 	}

	@Override
	public List<Wishlist> getAllWishlist() {
		return wishlistRepository.findAll();
	}

	@Override
	public Wishlist saveWishlist(Wishlist wishlist) {
		return wishlistRepository.save(wishlist);
	}

	@Override
	public Wishlist updateWishlist(Wishlist wishlist, Long id) {
		Wishlist existWishlist = wishlistRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Wishlist", "id", id));
		//existWishlist.setName(wishlist.getName());
		//existWishlist.setWishlist_product(wishlist.getWishlist_product());
		return wishlistRepository.save(existWishlist);
	}

	@Override
	public void deleteWishlistById(Long wishlist_id) {
		wishlistRepository.findById(wishlist_id).orElseThrow(()-> 
		new ResourceNotFoundException("Wishlist", "wishlist_id", wishlist_id));
		wishlistRepository.deleteById(wishlist_id);
	}

}
