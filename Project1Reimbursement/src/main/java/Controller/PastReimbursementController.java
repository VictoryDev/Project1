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

public class PastReimbursementController {
	
	static ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
	static List<Reimbursement> reimb = new ArrayList<Reimbursement>();
	
	public static String selectAllReimbursement(HttpServletRequest request ) {
		Employee emp = (Employee)request.getSession().getAttribute("username");
		reimb= rdi.selectAllReimbursement();
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
		request.getSession().setAttribute("reimb_array", reimb);
		System.out.println("SelectAllReimbursement ArrayList " + reimb);
		System.out.println("aksjdnaksjdhfajosdhfakjsdhfajdshfjd");
		
		return "/html/empDashboard.html";
	}
	
	public static String getSelectAllReimbursement(HttpServletRequest request, HttpServletResponse response) {
		
		//retrieving the pet object from our session
				reimb = (ArrayList<Reimbursement>)request.getSession().getAttribute("reimb_array");
				
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
				System.out.println("aksdjbf getSelectAllReimbursement ArrayList " + reimb);
				return reimb.toString();
	}

}
