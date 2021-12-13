package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.repositories.UsersDao;
import com.revature.repositories.UsersPostgres;

public class AuthServices {

	private UsersDao ud = new UsersPostgres();

	public String loginSystem(String username, String password) {
		User loggedin = null;
		loggedin = ud.getUserByUsername(username);

		if (loggedin != null) {
			if (loggedin.getPassword().equals(password)) {
				return "loggedin";
			} else {
				return "Invalid Password.";
			}
		} else {
			return "Username does not exist.";
		}
	}

	public String loginByUsername(User u) {
		User loggedin = null;
		loggedin = ud.getUserByUsername(u.getUsername());
		if (loggedin != null) {
			if (loggedin.getPassword().equals(u.getPassword())) {
				UserRole ur = loggedin.getRole();
				u.setRole(ur);
				return "loggedin";
			} else {
				return "Invalid login";
			}
		} else {
			return "Invalid Login";
		}
	}

	public User getUserByUsername(String username) {
		return ud.getUserByUsername(username);
	}

}
