package General;

import java.io.Serializable;

public class Outduty implements Serializable{
	private int employeeid;
	private String name,department,designation,date,timeout,reason;
	public Outduty(int employeeid, String name, String department,
			String designation, String date, String timeout, String reason) {
		
		this.employeeid = employeeid;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.date = date;
		this.timeout = timeout;
		this.reason = reason;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}