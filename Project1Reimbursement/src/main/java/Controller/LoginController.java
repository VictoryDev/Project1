package Controller;

import javax.servlet.http.HttpServletRequest;
import DAOIMPL.EmployeeDAOImpl;
import expense.Employee;

public class LoginController {

	public static String Login(HttpServletRequest request) {

		Employee empl = (Employee) request.getSession().getAttribute("Employee");

		if (empl != null) {
			return "/html/empDashboard.html";
		}
		if (request.getMethod().equals("GET")) {
			return "/html/Index.html";
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		empl = null;
		empl = edi.getEmployeeByUsername(username);
		if (validCredentials(empl, username, password)) {
			if (username.equals(empl.getUsername())) {
				request.getSession().setAttribute("Employee", empl);
				return "/html/empDashboard.html";
			}
		}
		return "/html/index.html";
	}

	public static boolean validCredentials(Employee emp, String username, String password) {
		if (username == null || password == null || emp == null) {
			return false;
		}

		if (username == "" || password == "") {
			return false;
		}
		return true;
	}
}
