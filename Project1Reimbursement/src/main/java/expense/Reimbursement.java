package expense;


import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SessionController;


public class Reimbursement extends SessionController {
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));

	private int reimb_id_pk;
	private double amount;
	private String dates = timeStamp;
	private String reimb_submit = timeStamp;
	private String reimb_description;
	private String reimb_resolve = timeStamp;
	private int author_id = 0;
	private int resolver_id = 0;
	private int reimb_status;
	private int reimb_type;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Reimbursement(int reimb_id_pk, double amount, String dates,
			String reimb_submit, String reimb_description, String reimb_resolve, int author_id, int resolver_id,
			int reimb_status, int reimb_type) {
		super();
		this.reimb_id_pk = reimb_id_pk;
		this.amount = amount;
		this.dates = dates;
		this.reimb_submit = reimb_submit;
		this.reimb_description = reimb_description;
		this.reimb_resolve = reimb_resolve;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}




	@Override
	public String toString() {
		return "Reimbursement [timeStamp=" + timeStamp + ", reimb_id_pk=" + reimb_id_pk + ", amount="
				+ amount + ", dates=" + dates + ", reimb_submit=" + reimb_submit + ", reimb_description="
				+ reimb_description + ", reimb_resolve=" + reimb_resolve + ", author_id=" + author_id + ", resolver_id="
				+ resolver_id + ", reimb_status=" + reimb_status + ", reimb_type=" + reimb_type + "]";
	}




	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public int getReimb_id_pk() {
		return reimb_id_pk;
	}

	public void setReimb_id_pk(int reimb_id_pk) {
		this.reimb_id_pk = reimb_id_pk;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public String getReimb_resolve() {
		return reimb_resolve;
	}

	public void setReimb_resolve(String reimb_resolve) {
		this.reimb_resolve = reimb_resolve;
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

	public int getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(int reimb_status) {
		this.reimb_status = reimb_status;
	}

	public int getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(int reimb_type) {
		this.reimb_type = reimb_type;
	}

	
	
}