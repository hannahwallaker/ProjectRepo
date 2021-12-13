package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.services.ManagerServices;
import com.revature.services.UsersServices;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ManagerController {
	
	private static ManagerServices ms = new ManagerServices();
	private static UsersServices us = new UsersServices();
	 
	public static void viewAllPending(Context ctx) {    
		ManagerServices ms = new ManagerServices();
    	System.out.println("in all pending");
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
		ArrayList<Reimbursements> ar = ms.viewAllPending();
		System.out.println(ar);
		ctx.json(ar);
		ctx.status(HttpCode.CREATED);	
    }
	    
	
	
	    public static void viewAllResolved(Context ctx) {    
	    	ManagerServices ms = new ManagerServices();
	    	System.out.println("in all resolved");
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
			ArrayList<Reimbursements> ar = ms.viewAllResolved();
			System.out.println(ar);
			ctx.json(ar);
			ctx.status(HttpCode.CREATED);	
	    }
	    
	    
	    public static void viewAllEmployees(Context ctx) {    
	    	ManagerServices ms = new ManagerServices();
	    	System.out.println("in all emps");
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
			ArrayList<User> au = ms.viewAllEmployees();
			System.out.println(au);
			ctx.json(au);
			ctx.status(HttpCode.CREATED);	
	    }
	    
	    
	    public static void viewReByUserId(Context ctx) {    
	    	int reid = Integer.parseInt(ctx.pathParam("id"));
			Reimbursements r = null;
			if (r != null) {
				ctx.json(r);
				ctx.status(HttpCode.OK);
			} else {
				ctx.status(HttpCode.NOT_FOUND);
			}
		}

	  
	    public static void updateReStatus(Context ctx) {    
	    	ManagerServices ms = new ManagerServices();
	    	Reimbursements r = null;
	    	int statusId = Integer.parseInt(ctx.body());
	    	
	    	int reId = Integer.parseInt(ctx.pathParam("id"));
	    	r = ms.getRequestById(reId);
	    	
	    	r.setReStatusId(statusId);
	    	
	    	ms.updateRequest(r);
	    	
	    }
	    
	    public static void viewAll(Context ctx) {
	    	ctx.result("list");
	    }

		public static String[] SplitTok(Context ctx) {
			String token = ctx.header("Authorization");
			String[] tok = token.split(":");
			return tok;
		}
}
