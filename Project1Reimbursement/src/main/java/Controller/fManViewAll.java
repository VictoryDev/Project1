package Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import DAOIMPL.ReimbursementDAOImpl;
import expense.Reimbursement;
public class fManViewAll {
		public static String selectAllReimbursementByStatus(HttpServletRequest request ) {
			System.out.println("entered selet all reimbursmeents");
			ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
			List<Reimbursement> reimb = new ArrayList<Reimbursement>();
			reimb= rdi.selectAllReimbursementByStatus();
			request.getSession().setAttribute("fMan_reimb_pendingArray", reimb);
			System.out.println("getSelectAllReimbursementByStatus ArrayList " + reimb);
			return "/html/fManDashboard.html";
		}
		public static String getSelectAllReimbursementByStatus(HttpServletRequest request, HttpServletResponse response) {
			//retrieving the pet object from our session
			System.out.println("in get attribute");		
			ArrayList<Reimbursement> reimb = (ArrayList<Reimbursement>)request.getSession().getAttribute("fMan_reimb_pendingArray");
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
					System.out.println("getSelectAllReimbursementByStatus ArrayList " + reimb);
					return reimb.toString();
		}
}