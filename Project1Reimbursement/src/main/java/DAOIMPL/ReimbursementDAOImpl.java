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
						"INSERT INTO Reimbursement(amount, dates, reimb_desc, reimb_submit, reimb_resolve, reimb_author, reimb_resolver, reimb_status_fk, reimb_type_fk) VALUES(?,?,?,?,?,?,?,?,?)");
				ps.setDouble(1, r.getAmount());
				ps.setString(2, r.getDates());
				ps.setString(3, r.getReimb_description());
				ps.setString(4, r.getReimb_submit());
				ps.setString(5, r.getReimb_resolve());
				ps.setInt(6, r.getAuthor_id());
				ps.setInt(7, r.getResolver_id());
				ps.setInt(8, r.getReimb_status());	
				System.out.println(r.getReimb_type());
				if (r.getReimb_type() == 1) {
					ps.setInt(9, r.getReimb_type());
					System.out.println("inside FOOOD");
				} else if (r.getReimb_type() == 2){
					ps.setInt(9, r.getReimb_type());
					System.out.println("inside Lodging");
				}else if (r.getReimb_type() == 3){
					System.out.println("top inside Other");
					ps.setInt(9, r.getReimb_type());
					System.out.println("inside Other");
				}else {
					ps.setInt(9, r.getReimb_type());
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		@Override
		public List<Reimbursement> selectAllReimbursementByStatus() {
			List<Reimbursement> array = new ArrayList<Reimbursement>();
			System.out.println("Select all Reimbursement by Status array: "+array);
			try (Connection conn = DriverManager.getConnection(urL, username, password)) {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement WHERE reimb_status_fk=1");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("inside the selectpending");
					array.add(new Reimbursement(rs.getInt("reimb_id_pk"), rs.getDouble("amount"), rs.getString("dates"),
							rs.getString("reimb_desc"), rs.getString("reimb_submit"), rs.getString("reimb_resolve"), rs.getInt("reimb_author"),
							rs.getInt("reimb_resolver"), rs.getInt("reimb_status_fk"), rs.getInt("reimb_type_fk")));
				}
				System.out.println(array);
				System.out.println("Select All Reimbursement by Status complete");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return array;
		}
		
		@Override
		public List<Reimbursement> selectAllReimbursement() {
			List<Reimbursement> array = new ArrayList<Reimbursement>();
			System.out.println(array);
			try (Connection conn = DriverManager.getConnection(urL, username, password)) {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					array.add(new Reimbursement(rs.getInt("reimb_id_pk"), rs.getDouble("amount"), rs.getString("dates"),
							rs.getString("reimb_desc"), rs.getString("reimb_submit"), rs.getString("reimb_resolve"), rs.getInt("reimb_author"),
							rs.getInt("reimb_resolver"), rs.getInt("reimb_status_fk"), rs.getInt("reimb_type_fk")));
				}
				System.out.println(array);
				System.out.println("Select All Reimbursement complete");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return array;
		}

	
		@Override
		public int updateReimbursement(int id, int status, int resolver_id) {
			try (Connection conn = DriverManager.getConnection(urL, username, password)) {
				PreparedStatement ps = conn.prepareStatement("UPDATE Reimbursement SET reimb_status_fk= ? , reimb_resolver= ? WHERE reimb_id_pk=?");
				System.out.println("IM IN THE UPDATE DAO");
				ps.setInt(1, status);
				ps.setInt(2, resolver_id);
				ps.setInt(3, id); 
				System.out.println("Status "+status);
				System.out.println("Resolver Id "+resolver_id);
				System.out.println("reimb ID "+id);
				ps.executeUpdate();
				System.out.println("Update was successful");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}

	
	}
