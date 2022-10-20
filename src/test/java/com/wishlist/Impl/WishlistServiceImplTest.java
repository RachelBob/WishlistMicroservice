package com.wishlist.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.repository.WishlistRepository;
import com.lti.wishlistservice.service.Impl.WishlistServiceImpl;

@SpringBootTest
public class WishlistServiceImplTest {
	
	@InjectMocks
	WishlistServiceImpl wishlistServiceImpl;
	
	@Mock
	private WishlistRepository wishRepo;
	
	/*
	 * @Test public void getWishlistByIdTest(){
	 * 
	 * when(wishRepo.findById(1L)).thenReturn(createWishlistStub());
	 * 
	 * Wishlist wishlist = wishlistServiceImpl.getWishlistById(1L);
	 * assertEquals(wishlist.getName(), "Samsung"); }
	 * 
	 * private Optional<Wishlist> createWishlistStub(){ Wishlist wishlist =
	 * Wishlist.builder().wishlist_id(1L).name("Test").build(); return
	 * Optional.of(wishlist);
	 * 
	 * }
	 */
	
}
