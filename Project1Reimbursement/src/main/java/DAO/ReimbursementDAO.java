package DAO;
import expense.Reimbursement;

public interface ReimbursementDAO {

	public int insertReimbursement(Reimbursement reimb);
	public Reimbursement selectReimbursement(int id);
	
}



