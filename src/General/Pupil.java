package General;

public class Pupil extends Employee{
	private int employeeid;
	private String firstname,middlename,lastname,dateofjoining,address,mobno,username,password,bloodgroup,email,usertype;

	public Pupil(int employeeid,String firstname, String middlename, String lastname,
			String dateofjoining, String department, String designation,String level,String address,
			String mobno, String username, String password, String bloodgroup,
			String email) {
		
		super(employeeid,firstname, middlename, lastname, dateofjoining, null,
				null,null,address, mobno,  username, password, bloodgroup, email,
				"PUPIL");
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofjoining = dateofjoining;
		this.mobno = mobno;
		this.username = username;
		this.password = password;
		this.bloodgroup = bloodgroup;
		this.usertype="PUPIL";
		this.email = email;
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(String dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
