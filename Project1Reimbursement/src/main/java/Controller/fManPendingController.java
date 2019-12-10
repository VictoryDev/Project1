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
public class fManPendingController {
		public static String selectAllReimbursementByStatus(HttpServletRequest request ) {
			ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
			List<Reimbursement> reimb = new ArrayList<Reimbursement>();
			reimb= rdi.selectAllReimbursementByStatus();
			request.getSession().setAttribute("fMan_pending_array", reimb);
			System.out.println("FMAN PENDING getSelectAllReimbursementByStatus ArrayList " + reimb);
			return "/html/fManDashboard.html";
		}
		public static String getSelectAllReimbursementByStatus(HttpServletRequest request, HttpServletResponse response) {
			//retrieving the pet object from our session
					ArrayList<Reimbursement> reimb = (ArrayList<Reimbursement>)request.getSession().getAttribute("fMan_pending_array");
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
					System.out.println("FMAN PENDING getSelectAllReimbursementByStatus ArrayList " + reimb);
					return reimb.toString();
		}
}