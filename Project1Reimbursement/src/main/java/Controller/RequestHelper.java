package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {
	// the idea behind this class is to route request base on the uri that comes
	// along with the request

	public static String process(HttpServletRequest request, HttpServletResponse response) {

		switch (request.getRequestURI()) {

		case "/Project1Reimbursement/html/login.do":
			return LoginController.Login(request);

		case "/Project1Reimbursement/html/register.do":
			return RegisterController.Register(request);
		case "/Project1Reimbursement/html/empDashboard.do":
			return EmpDashboard.EmpDash(request);
//		case "/Project1Reimbursement/html/fManDashboard.do":
//			return fManDashboard.fManDash(request);
		default:
			return "/html/index.html";
		}

	}
}
