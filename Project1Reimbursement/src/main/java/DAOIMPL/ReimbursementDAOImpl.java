package DAOIMPL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DAO.ReimbursementDAO;
import expense.Reimbursement;

public class ReimbursementDAOImpl implements ReimbursementDAO {
		private static String urL = "jdbc:oracle:thin:@sqlassignment.czmpw5zhoaqq.us-east-1.rds.amazonaws.com:1521:orcl";
		private static String username = "Victory";
		private static String password = "p4ssw0rd";
		
		@Override
		public int insertReimbursement(Reimbursement r) {
			try (Connection conn = DriverManager.getConnection(urL, username, password)) {
				
				PreparedStatement ps = conn.prepareStatement(
						"INSERT INTO Reimbursement(amount, dates, reimb_desc, reimb_submit, reimb_resolve, reimb_author, reimb_resolver, reimb_status, reimb_type) VALUES(?,?,?,?,?,?,?,1,?)");
				ps.setDouble(1, r.getAmount());
				ps.setString(2, r.getDates());
				ps.setString(3, r.getReimb_description());
				ps.setString(4, r.getReimb_submit());
				ps.setString(5, r.getReimb_resolve());
				ps.setInt(6, r.getAuthor_id());
				ps.setInt(7, r.getResolver_id());
				ps.setInt(8, r.getReimb_status());				
				if (r.getReimb_type() == 1) {
					ps.setInt(9, 1);
					System.out.println("inside FOOOD");
				} else if (r.getReimb_type() == 2){
					ps.setInt(9, 2);
					System.out.println("inside Lodging");
				}else if (r.getReimb_type() == 3){
					ps.setInt(9, 3);
					System.out.println("inside Other");
				}else {
					ps.setInt(9, 4);
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
//		public Reimbursement selectReimbursementByID(int id) {
//			Reimbursement ticket = null;
//			try (Connection conn = DriverManager.getConnection(urL, username, password)) {
//				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement WHERE reimb_id=?");
//				ps.setInt(1, id);
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					ticket = new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("amount"), rs.getTimestamp("dates"),
//							rs.getTimestamp("reimb_submit"), rs.getTimestamp("reimb_resolve"), rs.getString("reimb_status"),
//							rs.getString("reimb_type"));
//				}
//				System.out.println(ticket);
//				System.out.println("Selected by Reimbursement id complete");
//				return ticket;
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return null;
//		}
		
		@Override
		public List<Reimbursement> selectAllReimbursement() {
			List<Reimbursement> array = new ArrayList<Reimbursement>();
			try (Connection conn = DriverManager.getConnection(urL, username, password)) {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					array.add(new Reimbursement(rs.getInt("reimb_id_pk"), rs.getInt("reimb_id"), rs.getInt("reimb_type"), rs.getDouble("amount"),
							rs.getInt("reimb_status"), rs.getString("dates"), rs.getString("reimb_submit"), rs.getString("reimb_resolve"),
							rs.getString("reimb_description"), rs.getInt("author_id"), rs.getInt("resolver_id")));
				}
				System.out.println(array);
				System.out.println("Select All Reimbursement complete");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return array;
		}
		
		public int updateReimbursement(Reimbursement r) {
			try (Connection conn = DriverManager.getConnection(urL, username, password)) {
				PreparedStatement ps = conn.prepareStatement("UPDATE Reimbursement SET reimb_status= (?) WHERE reimb_id=?");
				ps.setInt(1, r.getReimb_status());
				ps.setInt(4, r.getReimb_id());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}

		@Override
		public Reimbursement selectReimbursementID(int id) {
			// TODO Auto-generated method stub
			return null;
		}
	}
