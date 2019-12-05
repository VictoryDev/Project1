package expense;

public class Employee {

	private int employee_id_pk;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String passwords;
	private String employee_role;
	
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employee_id_pk, String firstname, String lastname, String email, String username,
			String passwords, String employee_role) {
		super();
		this.employee_id_pk = employee_id_pk;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.passwords = passwords;
		this.employee_role = employee_role;
	}
	public int getEmployee_id_pk() {
		return employee_id_pk;
	}
	public void setEmployee_id_pk(int employee_id_pk) {
		this.employee_id_pk = employee_id_pk;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getEmployee_role() {
		return employee_role;
	}
	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}
	@Override
	public String toString() {
		return "Employee [employee_id_pk=" + employee_id_pk + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", username=" + username + ", passwords=" + passwords + ", employee_role="
				+ employee_role + "]";
	}


	
	
}

	