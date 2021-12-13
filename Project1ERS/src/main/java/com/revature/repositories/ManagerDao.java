package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface ManagerDao {
	
	ArrayList<Reimbursements> viewAllPending();
	ArrayList<Reimbursements> viewAllResolved();
	ArrayList<User> viewAllEmployees();
	public Reimbursements getRequestById(int reId);
	boolean updateRequest(Reimbursements re);
	public ArrayList<Reimbursements> viewAllReimbursements();
	

}
