package com.lti.wishlistservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.wishlistservice.model.Wishlist;



@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long>{

	Optional<Wishlist> findByUuid(String wishlist_uuid);
	
	@Query("from Wishlist w where w.customer_id = ?1")
	List<Wishlist> findByCustomer_id(Long customer_id);
	
}
