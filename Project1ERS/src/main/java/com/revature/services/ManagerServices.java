package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.repositories.ManagerDao;
import com.revature.repositories.ManagerPostgres;

public class ManagerServices {
	
	ManagerDao md = new ManagerPostgres();
	

	public ArrayList<Reimbursements> viewAllPending(){
		return md.viewAllPending();

	}
	
	public boolean updateRequest(Reimbursements re) {
		if(md.updateRequest(re)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Reimbursements> viewAllResolved(){
		return md.viewAllResolved();
	}
	
	public Reimbursements getRequestById(int reId) {
		return md.getRequestById(reId);
		
	}
	public ArrayList<User> viewAllEmployees(){
		ArrayList<User> empList = md.viewAllEmployees();
		return empList;
	} 
	
	ArrayList<Reimbursements> viewAll(){
		return md.viewAllReimbursements();
	}
	

}
