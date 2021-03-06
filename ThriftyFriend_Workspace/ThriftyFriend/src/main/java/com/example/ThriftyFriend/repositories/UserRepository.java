package com.example.ThriftyFriend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ThriftyFriend.models.ListingSummary;
import com.example.ThriftyFriend.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	List<User> findAll();
	boolean existsByEmail(String email);
	User findByEmail(String email);
	//added to display the user watchlist
	List<ListingSummary> findByListingsContaining(ListingSummary listingsummary);
}
