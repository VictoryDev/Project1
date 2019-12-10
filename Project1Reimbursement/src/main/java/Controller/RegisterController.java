package Controller;

import javax.servlet.http.HttpServletRequest;

import DAOIMPL.EmployeeDAOImpl;
import expense.Employee;

public class RegisterController {
	public static String Register(HttpServletRequest request) {
		String username = request.getParameter("username");
		String passwords = request.getParameter("passwords");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String employee_role = request.getParameter("role");
		
		int id = 1;
		Employee empl = new Employee(id, firstname, lastname, email, username, passwords, employee_role);

		
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		edi.insertEmployee(empl);
		System.out.println("done with dao");
		return "/html/index.html";
}
}
