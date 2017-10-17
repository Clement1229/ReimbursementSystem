package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Reimbursement;
import com.revature.domain.ReimbursementType;
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

}
