package expense;

import java.sql.Date;
import java.sql.Timestamp;


public class Reimbursement {

	private int reimb_id_pk;
	private int reimb_id;
	private String reimb_type;
	private double amount;
	private String reimb_status;
	private Timestamp dates;
	private Timestamp reimb_submit;
	private Timestamp reimb_resolve;
	private String reimb_description;

	public Reimbursement() {
		super();
	}

	public int getReimb_id_pk() {
		return reimb_id_pk;
	}

	public void setReimb_id_pk(int reimb_id_pk) {
		this.reimb_id_pk = reimb_id_pk;
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

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public Timestamp getDates() {
		return dates;
	}

	public void setDate(Timestamp dates) {
		this.dates = dates;
	}

	public Timestamp getReimb_submit() {
		return reimb_submit;
	}

	public void setReimb_submit(Timestamp reimb_submit) {
		this.reimb_submit = reimb_submit;
	}

	public Timestamp getReimb_resolve() {
		return reimb_resolve;
	}

	public void setReimb_resolve(Timestamp reimb_resolve) {
		this.reimb_resolve = reimb_resolve;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public Reimbursement(int reimb_id_pk, int reimb_id, String reimb_type, double amount, String reimb_status,
			Timestamp dates, Timestamp reimb_submit, Timestamp reimb_resolve, String reimb_description) {
		super();
		this.reimb_id_pk = reimb_id_pk;
		this.reimb_id = reimb_id;
		this.reimb_type = reimb_type;
		this.amount = amount;
		this.reimb_status = reimb_status;
		this.dates = dates;
		this.reimb_submit = reimb_submit;
		this.reimb_resolve = reimb_resolve;
		this.reimb_description = reimb_description;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id_pk=" + reimb_id_pk + ", reimb_id=" + reimb_id + ", reimb_type=" + reimb_type
				+ ", amount=" + amount + ", reimb_status=" + reimb_status + ", dates=" + dates + ", reimb_submit="
				+ reimb_submit + ", reimb_resolve=" + reimb_resolve + ", reimb_description=" + reimb_description + "]";
	}

}
