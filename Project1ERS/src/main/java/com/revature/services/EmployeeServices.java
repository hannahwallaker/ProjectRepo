package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;

public class EmployeeServices {
	
	private EmployeeDao ed;
	
	  public EmployeeServices(){
		super();
		ed = new EmployeePostgres();
	}
	
	
	public boolean submitMyRequest(Reimbursements re) {
		if(ed.submitMyRequest(re)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Reimbursements> viewMyPending(User u) {
		ArrayList<Reimbursements> reList = ed.viewMyPending(u);
		return reList;
	}
	
	public ArrayList<Reimbursements> viewMyResolved(User u) {
		ArrayList<Reimbursements> reList = ed.viewMyResolved(u);
		return reList;
	}
	

}
