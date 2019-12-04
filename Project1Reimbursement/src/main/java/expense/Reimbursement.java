package expense;

import java.util.Date;

public class Reimbursement {

	private int reimb_id;
	private String reimb_type;
	private double amount;
	private int status_id;
	private String status;
	private Date dates;

	public Reimbursement(int reimb_id, String reimb_type, double amount, int status_id, String status, Date date) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_type = reimb_type;
		this.amount = amount;
		this.status_id = status_id;
		this.status = status;
		this.date = date;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_type=" + reimb_type + ", amount=" + amount
				+ ", status_id=" + status_id + ", status=" + status + ", date=" + date + "]";
	}

}
