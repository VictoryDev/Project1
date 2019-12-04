package Controller;

import javax.servlet.http.HttpServletRequest;

import DAOIMPL.EmployeeDAOImpl;
import expense.Employee;

public class EmpDashboard {
	
		public static String EmpDash(HttpServletRequest request) {
			String username = request.getParameter("username");
			String passwords = request.getParameter("passwords");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			
			
			Employee empl = new Employee();
			empl.setUsername(username);
			empl.setPasswords(passwords);
			empl.setFirstname(firstname);
			empl.setLastname(lastname);
			empl.setEmail(email);
			
			EmployeeDAOImpl edi = new EmployeeDAOImpl();
			edi.insertEmployee(empl);
			
			return "/html/empDashboard.html";
	}
}
