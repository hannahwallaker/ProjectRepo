package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.ConnectionUtil;

public class UsersPostgres implements UsersDao {

	@Override
	public User getUserByUsername(String username) {
		User u = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "select * from users u join userrole r on u.uname = r.uname where u.uname = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				UserRole ur = new UserRole(rs.getInt("roleid"));
				u = new User(rs.getInt("userId"), rs.getString("uname"), rs.getString("pword"),
						rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), ur);
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return u;

	}

//LOOK INTO!

	@Override
	public ArrayList<User> viewMyInfo(User u) {
		String sql = "select * from users where uname = ?;";
		ArrayList<User> userAccount = new ArrayList<User>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User user = new User(rs.getInt("userId"), 
						rs.getString("uname"), 
						rs.getString("pword"),
						rs.getString("firstname"), 
						rs.getString("lastname"), 
						rs.getString("email"), 
						null);
				userAccount.add(user);
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return userAccount;
	}

	@Override
	public boolean updateMyInfo(User u) {
		String sql = "update users set uname = ?, pword = ?, "
				+ "firstname = ?, lastname = ?, email = ? where userid = ?;";

		int rowsChanged = -1;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getUserId());

			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getUserById(int userId) {
		User u = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "select * from users where userId = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				u = new User(rs.getInt("userId"), rs.getString("uname"), rs.getString("pword"),
						rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), null);
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

}
