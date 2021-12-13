package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.ConnectionUtil;

public class ManagerPostgres implements ManagerDao{

	@Override
	public ArrayList<Reimbursements> viewAllPending() {
		String sql = "select * from reimbursements where restatus = 0;";
	ArrayList<Reimbursements> pendingList = new ArrayList<Reimbursements>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while ( rs.next() ) {		
				Reimbursements re = new Reimbursements(rs.getInt("reId"), rs.getString("reCreator"), 
						rs.getDouble("reAmount"), rs.getString("reDescription"), 
						rs.getInt("restatus"), rs.getInt("retype"));
				pendingList.add(re);
			}
			
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
			return pendingList;

	}


	@Override
	public boolean updateRequest(Reimbursements re) {
		
		String sql = "update reimbursements set restatus = ? where reid = ?;";
		int rowsChanged = -1;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, re.getReStatusId());
			ps.setInt(2, re.getReId());
			rowsChanged = ps.executeUpdate();
		
		}catch (SQLException | IOException e) {			
			e.printStackTrace();
		}
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
		
	}


	@Override
	public ArrayList<Reimbursements> viewAllResolved() {
		String sql = "select * from reimbursements where restatus = 1;";
		ArrayList<Reimbursements> resolvedList = new ArrayList<Reimbursements>();
			
			try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while ( rs.next() ) {		
					Reimbursements re = new Reimbursements(rs.getInt("reId"), rs.getString("reCreator"), 
							rs.getDouble("reAmount"), rs.getString("reDescription"), 
							rs.getInt("restatus"), rs.getInt("retype"));
					resolvedList.add(re);
				}
				
				}
				catch (SQLException | IOException e) {			
					e.printStackTrace();			
				}
				return resolvedList;
	}

	@Override
	public Reimbursements getRequestById(int reId) {
		Reimbursements r = null;
		
		String sql = "select * from reimbursements where reid = ?;";
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				r = new Reimbursements(rs.getInt("reid"),
						rs.getString("recreator"),
						rs.getDouble("reamount"),
						rs.getString("redescription"),
						rs.getInt("restatus"),
						rs.getInt("retype")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return r;
	}

	@Override
	public ArrayList<User> viewAllEmployees(){
		String sql = "select * from users u join userrole s on u.uname = s.uname;";
		ArrayList<User> emps = new ArrayList<User>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				UserRole ur = new UserRole(rs.getInt("roleid"));
				User e = new User(rs.getInt("userid"), rs.getString("uname"),
						rs.getString("pword"), 
						rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("email"), 
						ur);
				emps.add(e);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emps;
	}
	
	@Override
	public ArrayList<Reimbursements> viewAllReimbursements(){
		String sql = "select * from reimbursements;";
		ArrayList<Reimbursements> re = new ArrayList<Reimbursements>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Reimbursements Re = new Reimbursements(
						rs.getInt("reid"),
						rs.getString("recreator"), 
						rs.getDouble("reamount"), 
						rs.getString("redescription"), 
						rs.getInt("restatus"),
						rs.getInt("retype"));
				re.add(Re);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return re;
	}
	
	
}
