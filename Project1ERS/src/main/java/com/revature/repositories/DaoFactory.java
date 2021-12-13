package com.revature.repositories;

public class DaoFactory {
	
	private static DaoFactory df;
	private UsersDao ud;
	
	private DaoFactory() {
	}
	
	public static synchronized DaoFactory getDaoFactory() {
		if(df == null) {
			df = new DaoFactory();
		}
		
		return df;
	}
	
	public UsersDao getUsersDao() {
		if(ud == null) {
			ud = new UsersPostgres();
		}
		return ud;
	}
	
	

}
