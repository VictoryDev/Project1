package DAO;
import java.util.List;

import expense.Reimbursement;

public interface ReimbursementDAO {

		// CREATE
				public int insertReimbursement(Reimbursement r);
				// READ
				public Reimbursement selectReimbursementID(int id);
				public List<Reimbursement> selectAllReimbursement();
				// UPDATE
				public int updateReimbursement(Reimbursement r);
	}
	




