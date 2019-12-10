package DAO;
import java.util.List;

import expense.Reimbursement;

public interface ReimbursementDAO {

		// CREATE
				public int insertReimbursement(Reimbursement r);
				// READ
				public List<Reimbursement> selectAllReimbursement();
				public List<Reimbursement> selectAllReimbursementByStatus();
				// UPDATE
				public int updateReimbursement(int id, int status, int resolver_id);
	}
	




