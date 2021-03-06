package com.example.ThriftyFriend.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ThriftyFriend.models.ListingSummary;
import com.example.ThriftyFriend.models.User;
import com.example.ThriftyFriend.repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository uRepo;
	
	public User findById(Long id)
	{
		return this.uRepo.findById(id).orElse(null);
	}
	
	public User findByEmail(String email)
	{
		return this.uRepo.findByEmail(email);
	}
	
	public User registerUser(User u)
	{
		String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashed);
		return this.uRepo.save(u);
	}
	
	public boolean existsByEmail(String email)
	{
		return this.uRepo.existsByEmail(email);
	}
	//get the list of watched listing summaries
	public List<ListingSummary> watchedItems(ListingSummary listing){
		return this.uRepo.findByListingsContaining(listing);
	}
	// add a summary to the user watch list
	public void addSummaryToWatchList(User user, ListingSummary listing) {
		//get the list from the user object
		List <ListingSummary> listings = user.getListings();
		listings.add(listing);
		//update
		this.uRepo.save(user);
	}
	
	public void removeSummaryFromWatchList(User user, ListingSummary listing) {
		List<ListingSummary> listings = user.getListings();
		listings.remove(listing);
		this.uRepo.save(user);
	}
			
}
