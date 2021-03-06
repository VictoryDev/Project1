package DAO;

import java.util.ArrayList;

import expense.Reimbursement;

public interface ReimbursementDAO {

	public boolean insertReimbursement(Reimbursement reimb);

	// Read
	public Reimbursement getReimbursement(int id);
	public ArrayList<Reimbursement> getAllReimbursement();
	public ArrayList<Reimbursement> getAllReimbursementByEmployee(int emp);
	public ArrayList<Reimbursement> getAllReimbursementByNext(int emp);

	// Update
	public boolean updateReimbursement(Reimbursement reimb);

	// Delete
	public boolean deleteReimbursement(int id);

}



