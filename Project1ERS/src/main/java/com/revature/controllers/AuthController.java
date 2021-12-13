package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.services.AuthServices;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class AuthController {

	public static void loginSystem(Context ctx) throws SQLException, IOException {
		AuthServices as = new AuthServices();
		User u = ctx.bodyAsClass(User.class);
		//System.out.println(u);
		String entry = as.loginByUsername(u);
		//System.out.println(entry);
		if (entry.equals("loggedin")) {
//			ctx.header("Access-Control-Expose-Headers", "authToken");
			String token = createToken(u);
			//System.out.println(token);
			ctx.header("Authorization", token);
//			ctx.result(String.valueOf(u.getRole().getRoleId()));
			ctx.status(HttpCode.OK);
		} else {
			ctx.result(entry);
			ctx.status(HttpCode.UNAUTHORIZED);
		}
	}

	public static String createToken(User u) {
		AuthServices as = new AuthServices();
		User info = as.getUserByUsername(u.getUsername());
		if (info != null) {
			String token = info.getUserId() + ":" + info.getRole().getRoleId();
			System.out.println(token);
			return token;
		
		}
		return null;
	}

	public static boolean checkToken(Context ctx) {
		String token = ctx.header("Authorization");
		String[] tok = token.split(":");
		User u = new User();
		u.setUsername(tok[0]);
		u.setPassword(tok[1]);
		AuthServices as = new AuthServices();
		String auth = as.loginSystem(u.getUsername(), u.getPassword());
		if (auth.equals("loggedin")) {
			return true;
		} else {
			return false;
		}

	}
}
