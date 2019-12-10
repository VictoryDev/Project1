
package Controller;

import javax.servlet.http.HttpServletRequest;
import DAOIMPL.EmployeeDAOImpl;
import DAOIMPL.ReimbursementDAOImpl;
import expense.Employee;
import expense.Reimbursement;

public class fManDashboard {
	public static String fManDash(HttpServletRequest request) {
		Employee emp = (Employee)request.getSession().getAttribute("username");
		
		int reimb_id = Integer.parseInt(request.getParameter("reimb_id"));
		double amount = Double.valueOf(request.getParameter("amount"));
		String dates = request.getParameter("dates");
		String reimb_desc = request.getParameter("reimb_desc");
		String reimb_submit = request.getParameter("reimb_submit");
		String reimb_resolve = request.getParameter("reimb_resolve");
		int reimb_author = Integer.parseInt(request.getParameter("reimb_author"));
		int reimb_resolver = Integer.parseInt(request.getParameter("reimb_resolver"));
		int reimb_status = Integer.parseInt(request.getParameter("reimb_status"));
		int reimb_type = Integer.parseInt(request.getParameter("reimb_type"));
		Reimbursement reimb = new Reimbursement();
		reimb.setReimb_id_pk(reimb_id);
		reimb.setAmount(amount);
		reimb.setDates(dates);
		reimb.setReimb_description(reimb_desc);
		reimb.setReimb_submit(reimb_submit);
		reimb.setReimb_resolve(reimb_resolve);
		reimb.setAuthor_id(emp.getEmployee_id_pk());
		reimb.setResolver_id(emp.getEmployee_id_pk());
		reimb.setReimb_status(reimb_status);
		reimb.setReimb_type(reimb_type);
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		rdi.insertReimbursement(reimb);
		System.out.println(reimb);
		System.out.println("Done with Ticket Submission!");
		return "/html/fManDashboard.html";
	}

// String username = request.getParameter("username");
//
// Employee empl = new Employee();
// empl.setUsername(username);
//
// EmployeeDAOImpl edi = new EmployeeDAOImpl();
// edi.insertEmployee(empl);
//
// return "/html/fManDashboard.html";
}