package expense;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class Reimbursement {
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
	Employee e = new Employee();

	private int reimb_id_pk;
	private int reimb_id;
	private int reimb_type;
	private double amount;
	private int reimb_status;
	private String dates = timeStamp;
	private String reimb_submit = timeStamp;
	private String reimb_resolve = timeStamp;
	private String reimb_description;
	private int author_id = e.getEmployee_id_pk();
	private int resolver_id = 0;

	
	
	public Reimbursement() {
		super();
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id_pk=" + reimb_id_pk + ", reimb_id=" + reimb_id + ", reimb_type=" + reimb_type
				+ ", amount=" + amount + ", reimb_status=" + reimb_status + ", dates=" + dates + ", reimb_submit="
				+ reimb_submit + ", reimb_resolve=" + reimb_resolve + ", reimb_description=" + reimb_description
				+ ", author_id=" + author_id + ", resolver_id=" + resolver_id + "]";
	}



	public Reimbursement(int reimb_id_pk, int reimb_id, int reimb_type, double amount, int reimb_status,
			String dates, String reimb_submit, String reimb_resolve, String reimb_description, int author_id,
			int resolver_id) {
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
		this.author_id = author_id;
		this.resolver_id = resolver_id;
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

	public int getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(int reimb_type) {
		this.reimb_type = reimb_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(int reimb_status) {
		this.reimb_status = reimb_status;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getReimb_submit() {
		return reimb_submit;
	}

	public void setReimb_submit(String reimb_submit) {
		this.reimb_submit = reimb_submit;
	}

	public String getReimb_resolve() {
		return reimb_resolve;
	}

	public void setReimb_resolve(String reimb_resolve) {
		this.reimb_resolve = reimb_resolve;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public int getResolver_id() {
		return resolver_id;
	}

	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}

}