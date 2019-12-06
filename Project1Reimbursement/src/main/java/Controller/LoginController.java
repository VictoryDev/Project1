package Controller;

import javax.servlet.http.HttpServletRequest;
import DAOIMPL.EmployeeDAOImpl;
import expense.Employee;

public class LoginController {

	public static String Login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("passwords");
		
		
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		Employee e = new Employee();
		e = edi.getEmployeeByUsername(username, password);
		System.out.println(e.getEmployee_role());
		if(e.getEmployee_role().equals("1")) {
			request.getSession().setAttribute("username", e);
			return "/html/empDashboard.html";
		} else if(e.getEmployee_role().equals("2")) {
			request.getSession().setAttribute("username", e);
			return "/html/fManDashboard.html";
		}
		else {
		
			return "/html/index.html";
		}
		
	}
//		System.out.println("Inside Login Controller");
//		Employee empl = (Employee) request.getSession().getAttribute("Employee");
//		
//		if (empl != null) {
//			return "/html/empDashboard.html";
//		}
//		if (request.getMethod().equals("GET")) {
//			return "/html/index.html";
//		}
//
//		String username = request.getParameter("username");
//		String password = request.getParameter("passwords");
//		System.out.println("This is Login username " + username);
//		System.out.println("This is password " + password);
//		EmployeeDAOImpl edi = new EmployeeDAOImpl();
//		empl = null;
//		empl = edi.getEmployeeByUsername(username,password);
//		if (validCredentials(empl, username, password)) {
//			if (username.equals(empl.getUsername())) {
//				request.getSession().setAttribute("Employee", empl);
//				return "/html/empDashboard.html";
//			}
//		}
//		return "/html/index.html";
//	}
//
//	public static boolean validCredentials(Employee emp, String username, String password) {
//		if (username == null || password == null || emp == null) {
//			return false;
//		}
//
//		if (username == "" || password == "") {
//			return false;
//		}
//		return true;
//	}
}
