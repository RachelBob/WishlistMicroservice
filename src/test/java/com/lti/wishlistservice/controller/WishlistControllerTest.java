package com.lti.wishlistservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.service.WishlistService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class WishlistControllerTest {

	@InjectMocks
	private WishlistController wishlistController;

	@Mock
	private WishlistService service;

	@Test
	public void getWishlist() throws Exception {
		Optional<Wishlist> wishlist = getWichlistByUuidStub();

		when(service.getWishlistByUuid("b198b8ec-59b2-11ed-a283-932966faf3ea")).thenReturn(wishlist);
		ResponseEntity<Optional<Wishlist>> response = wishlistController
				.getWishlist("b198b8ec-59b2-11ed-a283-932966faf3ea");
		assertEquals(response.getBody().isPresent(), true);
	}

	@Test
	public void getWishlistTest() throws Exception {
		List<Wishlist> wishlist = getAllWichlistStub();
		when(service.getAllWishlist()).thenReturn((List<Wishlist>) wishlist);
		assertEquals(service.getAllWishlist(), wishlist);
		assertEquals(3, wishlist.size());

	}

	private List<Wishlist> getAllWichlistStub() {
		List<Wishlist> wishlist = Arrays.asList(
				new Wishlist(1L, "Laptop", 1L, "b198b8ec-59b2-11ed-a283-932966faf3ea",
						"7bf9b850-59b1-11ed-b95b-2b179fdcc476", null),
				new Wishlist(2L, "Mobiles", 1L, "b198b8ec-59b2-11ed-a283-932966faf3ea",
						"7bf9b850-59b1-11ed-b95b-2b179fdcc476", null),
				new Wishlist(3L, "Accessories", 1L, "b198b8ec-59b2-11ed-a283-932966faf3ea",
						"7bf9b850-59b1-11ed-b95b-2b179fdcc476", null));
		return wishlist;
	}

	private Optional<Wishlist> getWichlistByUuidStub() {
		Wishlist wishlist = new Wishlist(1L, "Laptop", 1L, "b198b8ec-59b2-11ed-a283-932966faf3ea",
				"7bf9b850-59b1-11ed-b95b-2b179fdcc476", null);
		return Optional.ofNullable(wishlist);
	}

	@Test
	public void addWishlistTest() {
		Wishlist wishlist = createWishlistStub();
		when(service.saveWishlist(wishlist)).thenReturn(wishlist);
		assertEquals(wishlist, service.saveWishlist(wishlist));
	}

	private Wishlist createWishlistStub() {
		Wishlist wishlist = new Wishlist(3L, "Accessories", 1L, "b198b8ec-59b2-11ed-a283-932966faf3ea",
				"7bf9b850-59b1-11ed-b95b-2b179fdcc476", null);
		return wishlist;
	}

	@Test
	public void updateWishlistTest() throws Exception {
		Wishlist wishlist = wishlistStub();
		when(service.updateWishlist(wishlist)).thenReturn(wishlist);
		assertEquals(wishlist, service.updateWishlist(wishlist));
	}

	@Test
	public void deleteWishlistByIdTest() {
		Optional<Wishlist> wishlist = Optional.ofNullable(wishlistStub());
		//when(service.getWishlistByUuid("b198b8ec-59b2-11ed-a283-932966faf3ea")).thenReturn(wishlist);
		service.deleteWishlist(wishlist.get().getUuid());
		verify(service).deleteWishlist(wishlist.get().getUuid());
	}

	private Wishlist wishlistStub() {
		Wishlist wishlist = new Wishlist(1L, "Laptop", 1L, "b198b8ec-59b2-11ed-a283-932966faf3ea",
				"7bf9b850-59b1-11ed-b95b-2b179fdcc476", null);
		return wishlist;
	}

}
