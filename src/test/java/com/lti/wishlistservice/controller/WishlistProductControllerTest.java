package com.lti.wishlistservice.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.wishlistservice.service.WishlistProductService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class WishlistProductControllerTest {
	
	@InjectMocks
	private WishlistProductController wishlistProductController;

	@Mock
	private WishlistProductService service;

	@Test
	public void addWishlistProduct() {
		
	}
	
}
