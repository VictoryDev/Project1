package Controller;

import javax.servlet.http.HttpServletRequest;
import DAOIMPL.EmployeeDAOImpl;
import expense.Employee;

public class fManDashboard {
	public static String fManDash(HttpServletRequest request) {
		String username = request.getParameter("username");

		Employee empl = new Employee();
		empl.setUsername(username);

		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		edi.insertEmployee(empl);

		return "/html/fManDashboard.html";
	}
}