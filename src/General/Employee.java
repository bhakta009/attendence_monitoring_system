package General;

import java.io.Serializable;
import java.util.ArrayList;

import Database.FileReadWritelogindetail;

public class Employee implements Serializable{
	private int employeeid;
	
	private String firstname,middlename,lastname,dateofjoining,department,designation,level,address,mobno,username,password,bloodgroup,email,usertype;
	
	
	

	public Employee(int employeeid,String firstname, String middlename, String lastname
			,String dateofjoining, String department, String designation,String level,String address,
			String mobno, String username, String password, String bloodgroup,
			String email,String usertype) {
		
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofjoining = dateofjoining;
		this.department = department;
		this.designation = designation;
		this.level = level;
		this.mobno = mobno;
		this.username = username;
		this.password = password;
		this.bloodgroup = bloodgroup;
		this.email = email;
		this.usertype = usertype;
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

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsertype() {
		return usertype;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public String getDateofjoining() {
		return dateofjoining;
	}

	public String getDepartment() {
		return department;
	}

	public String getDesignation() {
		return designation;
	}

	public String getMobno() {
		return mobno;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public String getEmail() {
		return email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setDateofjoining(String dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
