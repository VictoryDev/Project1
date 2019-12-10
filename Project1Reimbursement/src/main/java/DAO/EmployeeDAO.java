package DAO;

import expense.Employee;

public interface EmployeeDAO {

	// CRUD methods:
	// Create
	public int insertEmployee(Employee e);
	
//	// Read
//	public Employee getEmployeeByID(int id);
	public Employee getEmployeeByUsername(String poo, String passwords); 
//	
//	// Update
//	public boolean updateEmployee(Employee empl);
//	public boolean updateEmployeePassword(int id, String newPassword);
//	
//	// Delete
	
}
