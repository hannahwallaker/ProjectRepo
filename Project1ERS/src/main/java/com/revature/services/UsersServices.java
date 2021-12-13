package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.repositories.UsersDao;
import com.revature.repositories.UsersPostgres;

public class UsersServices {
	
	UsersPostgres up = new UsersPostgres();
	private UsersDao ud;
	

	User getUserByUsername(String username) throws SQLException, IOException {
		User u = null;
		u = ud.getUserByUsername(username);
		return u;
		
	}
	
	public User getUserById(int userId) throws SQLException, IOException {
		User u = null;
		ud = new UsersPostgres();
		u = ud.getUserById(userId);
		return u;
	}
	public ArrayList<User> viewMyInfo(User u) throws SQLException, IOException {
		ArrayList<User> userAccount = ud.viewMyInfo(u);
		return userAccount;
	}
	
	public boolean updateMyInfo(User u) {
		if(ud.updateMyInfo(u)) {
			return true;
		}
		return false;
	}

}
