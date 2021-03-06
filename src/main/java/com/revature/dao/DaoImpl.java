package com.revature.dao;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Employee;
import com.revature.domain.PendingHistory;
import com.revature.domain.PendingRequest;
import com.revature.domain.Reimbursement;
import com.revature.domain.ResolvedHistory;
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
				user = new User(rs.getInt("ERS_ID"), rs.getString("ERS_FN"), rs.getString("ERS_LN"),
						rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"), rs.getString("ERS_EMAIL"),
						rs.getInt("ERS_RT_ID"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// new
	public void submitReimbursement(User user, Reimbursement reim) {
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

	// for employee
	public List<PendingHistory> viewPendingHistory(int ersid) {

		List<PendingHistory> reims = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection();) {
			// TYPE AMOUNT STATUS TIME
			String sql = "select (select rbt_name from reimbursement_type where reimbursement.rbt_id = reimbursement_type.rbt_id), r_amount, R_DESCRIPTION,(select st_name from status_type where reimbursement.st_id = status_type.st_id), r_timestamp from REIMBURSEMENT where ST_ID=1 and ERS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ersid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reims.add(new PendingHistory(rs.getString(1), rs.getDouble(2),rs.getString(3), rs.getString(4), rs.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reims;

	}

	// for employee
	@Override
	public List<ResolvedHistory> viewResolvedHistory(int ersid) {
		List<ResolvedHistory> rh = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection();) {
			// TYPE AMOUNT STATUS TIME
			String sql = "select (select ers_fn from ERS_USER where ers_user.ers_id = reimbursement.ers_id ),(select ers_ln from ERS_USER where ers_user.ers_id = reimbursement.ers_id ),(select rbt_name from reimbursement_type where reimbursement.rbt_id = reimbursement_type.rbt_id), r_amount, r_description, (select st_name from status_type where reimbursement.st_id = status_type.st_id),(select ers_fn from ers_user where ers_user.ers_id = reimbursement.manager_id),(select ers_ln from ers_user where ers_user.ers_id = reimbursement.manager_id),r_timestamp from REIMBURSEMENT where ST_ID != 1 and ERS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ersid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rh.add(new ResolvedHistory(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rh;
	}

	public List<Employee> viewEmployeeList() {
		List<Employee> empls = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection();) {
			// TYPE AMOUNT STATUS TIME
			String sql = "select ers_id, ers_fn, ers_ln, ers_username, ers_email from ers_user where ers_rt_id = 1";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				empls.add(
						new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empls;
	}

	// for manager
	public List<ResolvedHistory> viewAllResolvedHistory() {
		List<ResolvedHistory> mrh = new ArrayList<>(); // manager resolved history

		try (Connection conn = ConnectionUtil.getConnection();) {
			// TYPE AMOUNT STATUS TIME
			String sql = "select (select ers_fn from ERS_USER where ers_user.ers_id = reimbursement.ers_id ),(select ers_ln from ERS_USER where ers_user.ers_id = reimbursement.ers_id ),(select rbt_name from reimbursement_type where reimbursement.rbt_id = reimbursement_type.rbt_id), r_amount, r_description, (select st_name from status_type where reimbursement.st_id = status_type.st_id), r_timestamp ,(select ers_fn from ers_user where ers_user.ers_id = reimbursement.manager_id and ers_rt_id = 2),(select ers_ln from ers_user where ers_user.ers_id = reimbursement.manager_id and ers_rt_id = 2) from reimbursement where st_id != 1";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mrh.add(new ResolvedHistory(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mrh;

	}

	// for manager
	public List<PendingRequest> viewPendingRequest() {

		List<PendingRequest> pr = new ArrayList<>();
		// ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection();) {
			// TYPE AMOUNT STATUS TIME
			String sql = "select r_id, ers_id, (select ers_fn from ERS_USER where ers_user.ers_id = reimbursement.ers_id ),(select ers_ln from ERS_USER where ers_user.ers_id = reimbursement.ers_id ),(select rbt_name from reimbursement_type where reimbursement.rbt_id = reimbursement_type.rbt_id), r_amount, r_description, (select st_name from status_type where reimbursement.st_id = status_type.st_id), r_timestamp from reimbursement where st_id = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setInt(1, ersid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pr.add(new PendingRequest(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pr;
	}

	public void updateFirstNamePasswordEmail(String fn, String pw, String em, int rtid) {
	
		try (Connection conn = ConnectionUtil.getConnection();) {
			System.out.println("+++updateFirstNamePasswordEmail++++++");
			System.out.println(fn +" "+ pw + " " + em + " " + rtid);
			String sql = "update ers_user set ers_fn= ?, ers_password = ?, ers_email= ? where ers_id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, pw);
			ps.setString(3, em);
			ps.setInt(4, rtid);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//manager view single employee
	public List<PendingRequest> viewSingleEmployeePendingRequest(int ersid) {

		List<PendingRequest> pr = new ArrayList<>();
		// ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection();) {
			// TYPE AMOUNT STATUS TIME
			String sql = "select r_id, ers_id, (select ers_fn from ERS_USER where ers_user.ers_id = reimbursement.ers_id ),(select ers_ln from ERS_USER where ers_user.ers_id = reimbursement.ers_id ),(select rbt_name from reimbursement_type where reimbursement.rbt_id = reimbursement_type.rbt_id), r_amount, r_description, (select st_name from status_type where reimbursement.st_id = status_type.st_id), r_timestamp from reimbursement where st_id = 1 and ers_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setInt(1, ersid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pr.add(new PendingRequest(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pr;
	}
	
	//approve request
	public void approveRequestByRid(int mngId, int rid) {
		
		try (Connection conn = ConnectionUtil.getConnection();) {
			String sql = "update REIMBURSEMENT set st_id = '2', manager_id = ? where r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mngId);
			ps.setInt(2, rid);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//deny request
	public void denyRequestByRid(int mngId, int rid) {
		
		try (Connection conn = ConnectionUtil.getConnection();) {
			String sql = "update REIMBURSEMENT set st_id = '3', manager_id = ? where r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mngId);
			ps.setInt(2, rid);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}







