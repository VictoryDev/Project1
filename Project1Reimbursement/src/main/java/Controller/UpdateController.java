package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import DAOIMPL.ReimbursementDAOImpl;
import expense.Employee;
import expense.Reimbursement;

public class UpdateController {
	
	public static String Update(HttpServletRequest request) {
		System.out.println("entered the updatecontroller");
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		System.out.println("geetting empolyee session");
		Employee e = (Employee)request.getSession().getAttribute("username");
		System.out.println("getting status int");
		System.out.println(request.getParameter("approveDenyBtn"));
		int status = Integer.parseInt(request.getParameter("approveDenyBtn"));
		System.out.println("getting the victory aramater");
		int id = Integer.valueOf(request.getParameter("victorys"));
		System.out.println("getting the employee id for resolver");
		int resolver_id = e.getEmployee_id_pk();		
		System.out.println("before entering the dao");
		rdi.updateReimbursement(id, status,resolver_id);
		
		
		System.out.println("Reimb_id_pk : "+id);
		System.out.println("Resolver ID" + e.getEmployee_id_pk());
		System.out.println("This is the status" + status);

		
		return "/html/fManDashboard.html";
	}


}