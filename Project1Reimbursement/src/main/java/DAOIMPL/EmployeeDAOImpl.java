package DAOIMPL;

import DAO.EmployeeDAO;
import expense.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean insertEmployee(Employee empl) {
		return false;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		return null;
	}

	@Override
	public boolean updateEmployee(Employee empl) {
		return false;
	}

	@Override
	public boolean updateEmployeePassword(int id, String newPassword) {
		return false;
	}

}
