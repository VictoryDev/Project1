package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expense.Reimbursement;


public class RequestHelper {
	// the idea behind this class is to route request base on the uri that comes
	// along with the request

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("-----------------------------------------------------");
		System.out.println("this is" + request.getRequestURI());
		System.out.println("-----------------------------------------------------");
		switch (request.getRequestURI()) {

		case "/Project1Reimbursement/html/login.do":
			return LoginController.Login(request);

		case "/Project1Reimbursement/html/register.do":
			return RegisterController.Register(request);
			
		case "/Project1Reimbursement/html/empDashboard.do":
			return EmpDashboard.EmpDash(request);
			
		case "/Project1Reimbursement/html/fManDashboard.do":
			return fManDashboard.fManDash(request);
			
		case "/Project1Reimbursement/html/session.do":
			return SessionController.Home(request,response);
			
		case "/Project1Reimbursement/html/pastReimbursement.do":
			return PastReimbursementController.selectAllReimbursement(request);
			
		case "/Project1Reimbursement/html/getPastReimbursement.do":
			return PastReimbursementController.getSelectAllReimbursement(request,response);

		case "/Project1Reimbursement/html/pendingReimbursement.do":
			return PendingReimbursementController.selectAllReimbursementByStatus(request);
			
		case "/Project1Reimbursement/html/getPendingReimbursement.do":
			return PendingReimbursementController.getSelectAllReimbursementByStatus(request,response);
			
		case "/Project1Reimbursement/html/allReimbursement.do":	
			return fManViewAll.selectAllReimbursementByStatus(request);
			
		case "/Project1Reimbursement/html/getAllReimbursement.do":
			return fManViewAll.getSelectAllReimbursementByStatus(request, response);
			
		case "/Project1Reimbursement/html/pastEmployeeReimbursement.do":	
			return fManViewPast.selectAllReimbursement(request);
			
		case "/Project1Reimbursement/html/getPastEmployeeReimbursement.do":
			return fManViewPast.getSelectAllReimbursement(request, response);
			
		case "/Project1Reimbursement/html/fManApproveDeny.do":	
			return fManPendingController.selectAllReimbursementByStatus(request);
			
		case "/Project1Reimbursement/html/getfManApproveDeny.do":
			return fManPendingController.getSelectAllReimbursementByStatus(request, response);
			
		case "/Project1Reimbursement/html/updateTicket.do":
			return UpdateController.Update(request);
			
		default:
			return "/html/index.html";
		}

	}
}
