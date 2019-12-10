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
//		
}
