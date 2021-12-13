package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.services.AuthServices;
import com.revature.services.EmployeeServices;
import com.revature.services.UsersServices;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UsersController {

	public static void updateMyInfo(Context ctx) {
		UsersServices us = new UsersServices();
		int userId = Integer.parseInt(ctx.pathParam("id"));
		System.out.println(userId);
		User u = null;
		try {
			u = us.getUserById(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User temp = ctx.bodyAsClass(User.class);
		temp.setUserId(userId);
		temp.setUsername(u.getUsername());
		temp.setEmail(u.getEmail());
		temp.setRole(u.getRole());

		us.updateMyInfo(temp);
	}

	public static void viewMyInfo(Context ctx) throws SQLException, IOException {
		UsersServices us = new UsersServices();
		User u = null;
		try {
			int id = Integer.parseInt(SplitTok(ctx)[0]);
			System.out.println(id);
			u = us.getUserById(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u);
		ArrayList<User> au = us.viewMyInfo(u);
		System.out.println(au);
		ctx.json(au);
		ctx.status(HttpCode.CREATED);
	}

	public static String[] SplitTok(Context ctx) {
		String token = ctx.header("Authorization");    	
    	String[] tok = token.split(":");
    	return tok;
	}
}
