package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;

import io.javalin.http.Context;

public interface EmployeeDao {
	
	boolean submitMyRequest (Reimbursements re);
	ArrayList<Reimbursements> viewMyPending(User u);
	ArrayList<Reimbursements> viewMyResolved(User u);
	

}
