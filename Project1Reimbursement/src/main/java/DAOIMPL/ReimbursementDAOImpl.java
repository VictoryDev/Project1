package DAOIMPL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.folder.bank.Accounts;
import com.folder.bank.Customers;

public class ReimbursementDAOImpl {
	private static String urL
	= "jdbc:oracle:thin:@bankapp.c8fjsw7dnsyi.us-west-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Victoryy";
	private static String password = "p4ssw0rd";
	public int insertCustomer(Customers c) {
		try (Connection conn = DriverManager.getConnection(urL,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Customers(customerID, accountType, username, passwords, totalBalance, pendingApproved) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, c.getCustomerId());
			ps.setString(2, c.getAccountType());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getPassword());
			ps.setInt(5, c.getTotalBalance());
			ps.setInt(6, c.getPendingApproved());
			ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	public Customers selectCustomerByID(int id) {
		Customers customer = null;
		try (Connection conn = DriverManager.getConnection(urL,username,password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE customerID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer = new Customers(rs.getInt("customer_pk"), rs.getInt("customerID"), rs.getInt("totalBalance"), rs.getString("accountType"), rs.getString("username"), rs.getString("passwords"), rs.getInt("pendingApproved"));
			}
			System.out.println(customer);
			System.out.println("Selected by Customers username complete");
			return customer;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void selectAllCustomers(){
		try(Connection conn = DriverManager.getConnection(urL,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("pendingApproved")== 0) {
					Accounts.accountsPending.add(new Customers(rs.getInt("customer_pk"), rs.getInt("customerID"), rs.getInt("totalBalance"), rs.getString("accountType"), rs.getString("username"), rs.getString("passwords"), rs.getInt("pendingApproved")));
				} else {
					Accounts.accountsApproved.add(new Customers(rs.getInt("customer_pk"), rs.getInt("customerID"), rs.getInt("totalBalance"), rs.getString("accountType"), rs.getString("username"), rs.getString("passwords"), rs.getInt("pendingApproved")));
				}
			}	
			System.out.println("_________________________________________________________________________________________________________________________________");
			System.out.println("\n");
			System.out.println("\t\t Accounts Approved from Database:");
			System.out.println("_________________________________________________________________________________________________________________________________");
			for(Customers b : Accounts.accountsApproved) {
				System.out.println("\n");
				System.out.println("\t *****Active User Account Info*****");
				System.out.println("\t Active Customer Primary Key..." + b.getCustomer_pk());
				System.out.println("\t Active Customer ID............" + b.getCustomerId());
				System.out.println("\t Active Customer Type..........." + b.getAccountType());
				System.out.println("\t Active Username............... " + b.getUsername());
				System.out.println("\t Active Password............... " + b.getPassword());
				System.out.println("\t Customer Total Balance............... " + b.getTotalBalance());
				System.out.println("\t Pending(0) or Aproved(1)..... " + b.getPendingApproved());			
			}
			System.out.println("_________________________________________________________________________________________________________________________________");
			System.out.println("\n");
			System.out.println("\t\t Accounts Pending from Database:");
			System.out.println("_________________________________________________________________________________________________________________________________");
			for(Customers a : Accounts.accountsPending) {
				System.out.println("\n");
				System.out.println("\t *****Pending User Account Info*****");
				System.out.println("\t Pending Customer Primary Key..." + a.getCustomer_pk());
				System.out.println("\t Pending Customer ID............" + a.getCustomerId());
				System.out.println("\t Pending Customer Type..........." + a.getAccountType());
				System.out.println("\t Pending Username............... " + a.getUsername());
				System.out.println("\t Pending Password............... " + a.getPassword());
				System.out.println("\t Customer Total Balance............... " + a.getTotalBalance());
				System.out.println("\t Pending(0) or Aproved(1)..... " + a.getPendingApproved());			
			}
			System.out.println("_________________________________________________________________________________________________________________________________");
			System.out.println("Select All Customers complete");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	public int updateCustomer(Customers c) {
		try (Connection conn = DriverManager.getConnection(urL,username,password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Customers SET totalBalance= (?), pendingApproved= (?) WHERE customerID=?");
			ps.setInt(3, c.getCustomerId());
//			ps.setString(2, c.getAccountType());
//			ps.setString(3, c.getUsername());
//			ps.setString(4, c.getPassword());
			ps.setInt(1, c.getTotalBalance());
			ps.setInt(2, c.getPendingApproved());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteCustomer(Customers c) {
		try(Connection conn = DriverManager.getConnection(urL,username,password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Customers WHERE customerID=?");
			ps.setInt(1, c.getCustomerId());
			ps.executeUpdate();
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Delete complete");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}