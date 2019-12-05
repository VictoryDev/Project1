package Controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import DAOIMPL.EmployeeDAOImpl;
import DAOIMPL.ReimbursementDAOImpl;
import expense.Employee;
import expense.Reimbursement;

public class EmpDashboard {
	
		public static String EmpDash(HttpServletRequest request) {
			String firstname = request.getParameter("firstName");
			String lastname = request.getParameter("lastName");
			String reimb_type = request.getParameter("reimb_type");
			String dates = request.getParameter("dates");
			String email = request.getParameter("email");			
			
			Employee empl = new Employee();
			Reimbursement reimb = new Reimbursement();
			empl.setFirstname(firstname);
			empl.setLastname(lastname);
			empl.setEmail(email);
			reimb.setDates(dates);
			reimb.setReimb_type(reimb_type);
			
			EmployeeDAOImpl edi = new EmployeeDAOImpl();
			ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
			edi.insertEmployee(empl);
			
			return "/html/empDashboard.html";
	}
}
