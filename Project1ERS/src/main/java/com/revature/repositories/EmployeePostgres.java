package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao{
	

	@Override
	public boolean submitMyRequest(Reimbursements re) {
		String sql = "insert into Reimbursements (reCreator, reAmount, reDescription, reStatus, reType)"
					+ "values (?, ?, ?, ?, ?)";
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, re.getReCreator().getUsername());
			ps.setDouble(2, re.getReAmount());
			ps.setString(3, re.getReDescription());
			ps.setInt(4, re.getReStatus().getStatusId());
			ps.setInt(5, re.getReType().getTypeId());
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}

	@Override
	public ArrayList<Reimbursements> viewMyPending(User u) {
		String sql = "select * from reimbursements where recreator = ? and reStatus = 0;";
		ArrayList<Reimbursements> pendingList = new ArrayList<Reimbursements>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {		
				Reimbursements re = new Reimbursements
						(rs.getInt("reid"), 
						rs.getString("recreator"), 
						rs.getDouble("reamount"), 
						rs.getString("redescription"), 
						rs.getInt("restatus"), 
						rs.getInt("retype"));
				pendingList.add(re);
			}
			
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
			return pendingList;

	}

	@Override
	public ArrayList<Reimbursements> viewMyResolved(User u) {
		String sql = "select * from reimbursements where recreator = ? and reStatus = 1;";
		ArrayList<Reimbursements> resolvedList = new ArrayList<Reimbursements>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ResultSet rs = ps.executeQuery();

			while ( rs.next() ) {		
				Reimbursements re = new Reimbursements
						(rs.getInt("reid"), 
						rs.getString("recreator"), 
						rs.getDouble("reamount"), 
						rs.getString("redescription"), 
						rs.getInt("restatus"), 
						rs.getInt("retype"));
				resolvedList.add(re);
			}
			
			
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
		
		return resolvedList;
	}


}
