package Controller;

import java.sql.Timestamp;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import DAOIMPL.EmployeeDAOImpl;
import DAOIMPL.ReimbursementDAOImpl;
import expense.Employee;
import expense.Reimbursement;

public class EmpDashboard {
	
		public static String EmpDash(HttpServletRequest request) {
			Employee emp = (Employee)request.getSession().getAttribute("username");

			int reimb_type = Integer.parseInt(request.getParameter("reimb_type"));
			String dates = request.getParameter("dates");
			String reimb_desc = request.getParameter("reimb_desc");
			double amount = Double.valueOf(request.getParameter("amount"));
			int reimb_status = Integer.parseInt(request.getParameter("reimb_status"));
			
			
			Reimbursement reimb = new Reimbursement();
			reimb.setReimb_type(reimb_type);
			reimb.setDates(dates);
			reimb.setReimb_description(reimb_desc);
			reimb.setAmount(amount);
			reimb.setReimb_status(reimb_status);
			reimb.setAuthor_id(emp.getEmployee_id_pk());
			
			ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
			rdi.insertReimbursement(reimb);
			System.out.println(reimb);
			
			System.out.println("Done with Ticket Submission!");
			return "/html/empDashboard.html";
	}
}
