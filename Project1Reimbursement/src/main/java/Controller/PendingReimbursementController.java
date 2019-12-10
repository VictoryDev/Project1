package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAOIMPL.ReimbursementDAOImpl;
import expense.Employee;
import expense.Reimbursement;

public class PendingReimbursementController {
		static ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		static List<Reimbursement> reimb = new ArrayList<Reimbursement>();

		public static String selectAllReimbursementByStatus(HttpServletRequest request ) {
			Employee emp = (Employee)request.getSession().getAttribute("username");
			reimb= rdi.selectAllReimbursementByStatus();
			Iterator it = reimb.listIterator(); 
			System.out.println("This is the emp "+emp);
			if(emp.getEmployee_role().equals("1")) {
				System.out.println("Im in the iterator");
				while(it.hasNext()) {
					Reimbursement temp = (Reimbursement) it.next();
					System.out.println("employee id "+emp.getEmployee_id_pk());
					System.out.println("temp "+temp.getAuthor_id());
					if(temp.getAuthor_id() != emp.getEmployee_id_pk()) {
						it.remove();
					}
				}
			}
					request.getSession().setAttribute("reimb_pending_array", reimb);
			System.out.println("SelectAllReimbursementByStatus ArrayList " + reimb);
			System.out.println("select all reimbursement by status complete");

			return "/html/empDashboard.html";
		}
		
		public static String getSelectAllReimbursementByStatus(HttpServletRequest request, HttpServletResponse response) {
			
			//retrieving the reimb object from our session
					ArrayList<Reimbursement> reimb = (ArrayList<Reimbursement>)request.getSession().getAttribute("reimb_pending_array");
					
					//Marshalling Tool
					//converting an object into a data format
					//in our case we are converting pet to JSON (Jackson)
					try {
						response.getWriter().write(new ObjectMapper().writeValueAsString(reimb));
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					System.out.println("PENDING getSelectAllReimbursementByStatus ArrayList " + reimb);
					System.out.println("PENDING select all reimbursement by status complete");


					return reimb.toString();
		}

}
