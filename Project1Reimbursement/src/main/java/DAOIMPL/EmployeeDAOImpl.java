package DAOIMPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.EmployeeDAO;
import expense.Employee;
import expense.Reimbursement;

public class EmployeeDAOImpl implements EmployeeDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String urL = "jdbc:oracle:thin:@sqlassignment.czmpw5zhoaqq.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Victory";
	private static String password = "p4ssw0rd";

	@Override
	public int insertEmployee(Employee e) {
		int insertedEmp = 0;
		System.out.println("in dao before try");
		try (Connection conn = DriverManager.getConnection(urL, username, password)) {
			System.out.println("Inside DAO");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO Employee (firstname, lastname, email, username, passwords, employee_role_fk) VALUES(?,?,?,?,?,?)");
			ps.setString(1, e.getFirstname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getUsername());
			ps.setString(5, e.getPasswords());
			if (e.getEmployee_role() == "Employee") {
				ps.setInt(6, 1);

			} else {
				ps.setInt(6, 2);

			}

			ps.executeUpdate();
			System.out.println(insertedEmp);
		} catch (SQLException f) {
			f.printStackTrace();
		}
		return insertedEmp;
	}

	// @Override
	// public Employee getEmployeeByID(int id) {
	// return null;
	// }
	//
	@Override
	public Employee getEmployeeByUsername(String poo, String passwords) {
		Employee ticket = null;
		try (Connection conn = DriverManager.getConnection(urL, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE username=? AND passwords=?");
			System.out.println("INSIDE EMPLOYEE LOGIN");
			ps.setString(1, poo);
			ps.setString(2, passwords);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ticket = new Employee(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			}
			System.out.println(ticket.getEmployee_role());
			System.out.println(ticket);
			System.out.println("Selected by Employee ID complete");
			return ticket;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//
	// @Override
	// public boolean updateEmployee(Employee empl) {
	// return false;
	// }
	//
	// @Override
	// public boolean updateEmployeePassword(int id, String newPassword) {
	// return false;
	// }

}
