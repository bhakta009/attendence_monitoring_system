package General;

import java.io.Serializable;

public class plcldata implements Serializable
{
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	private int employeeid,pl,cl,year;
	private String name,department,designation,level,doj;
	public plcldata(int employeeid, String name, String department,
			String designation, String level, String doj, int pl, int cl,int year) {
		//super();
		this.employeeid = employeeid;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.level = level;
		this.doj = doj;
		this.pl = pl;
		this.cl = cl;
		this.year=year;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public void setPl(int pl) {
		this.pl = pl;
	}
	public void setCl(int cl) {
		this.cl = cl;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	public int getEmployeeid() {
		return employeeid;
	}
	public int getPl() {
		return pl;
	}
	public int getCl() {
		return cl;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public String getDesignation() {
		return designation;
	}
	public String getLevel() {
		return level;
	}
	public String getDoj() {
		return doj;
	}

}
