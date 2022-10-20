package com.lti.wishlistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lti.wishlistservice.model.Wishlist;

@SpringBootApplication
public class WishlistServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishlistServiceApplication.class, args);
		System.out.println("Welcome to the wishlist service...!!!");
	}

}
