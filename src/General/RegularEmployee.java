package General;

public class RegularEmployee extends Employee{
private int employeeid;
 String firstname,middlename,lastname,dateofjoining,department,designation,level,address,mobno,username,password,bloodgroup,email,usertype;
	
	
	public RegularEmployee(int employeeid,String firstname, String middlename,
			String lastname, String dateofjoining, String department,
			String designation,String level,String address, String mobno, String username, String password,
			String bloodgroup, String email) {
		super(employeeid,firstname, middlename, lastname, dateofjoining, department,
				designation, level, address, mobno, username, password, bloodgroup, email,
				"REGULAR EMPLOYEE");
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofjoining = dateofjoining;
		this.mobno = mobno;
		this.username = username;
		this.password = password;
		this.bloodgroup = bloodgroup;
		this.email = email;
		this.department = department;
		this.designation = designation;
		this.level=level;
		this.usertype = "REGULAR EMPLOYEE";
		this.address=address;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
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


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
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
	

}
