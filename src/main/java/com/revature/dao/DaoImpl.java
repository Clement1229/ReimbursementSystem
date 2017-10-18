package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.PendingHistory;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class DaoImpl implements Dao {

	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRtidByUsernamePassword(String username, String password) {
		int rtid = 0;
		try (Connection conn = ConnectionUtil.getConnection();) {
			// String sql = "SELECT U_ID, U_FN, U_LN FROM BANK_USER WHERE U_USERNAME = ? AND
			// U_PASSWORD = ?";

			String sql = "SELECT ERS_RT_ID FROM ERS_USER WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rtid = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rtid;
	}

	
	

	@Override
	public User getUserByUsernamePassword(String username, String password) {
		User user = null;
		int rtid = 0;
		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "SELECT * FROM ERS_USER WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("ERS_ID"), rs.getString("ERS_FN"), rs.getString("ERS_LN"), rs.getString("ERS_USERNAME"),
						rs.getString("ERS_PASSWORD"), rs.getString("ERS_EMAIL"), rs.getInt("ERS_RT_ID"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//new
	public void submitReimbursement(User user,Reimbursement reim) {
		try (Connection conn = ConnectionUtil.getConnection();) {

			CallableStatement cs = conn.prepareCall("{call submit_reimbursement(?,?,?,?)}");
			cs.setInt(1, user.getErsId());
			cs.setDouble(2, reim.getAmount());
			cs.setString(3, reim.getDescription());
			cs.setInt(4, reim.getRbt_id());
			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public List<PendingHistory> viewTransactionHistory(Reimbursement reim) {
		
		List<PendingHistory> reims = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection();) {
			//TYPE AMOUNT STATUS TIME
			String sql = "select (select rbt_name from reimbursement_type where reimbursement.rbt_id = reimbursement_type.rbt_id), r_amount, (select st_name from status_type where reimbursement.st_id = status_type.st_id), r_timestamp from REIMBURSEMENT where ERS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reim.getErsID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reims.add(new PendingHistory(rs.getString(1), rs.getDouble(2), rs.getString(3),rs.getString(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reims;
		
	}

}
