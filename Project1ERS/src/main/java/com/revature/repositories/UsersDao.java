package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.User;

public interface UsersDao {
	


	User getUserByUsername(String username);
	User getUserById(int userId);
	boolean updateMyInfo(User u);
	ArrayList<User> viewMyInfo(User u);

	
	

	
	
}
