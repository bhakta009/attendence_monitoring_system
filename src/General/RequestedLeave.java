package General;

import java.io.Serializable;

public class RequestedLeave implements Serializable{
private int employeeid,noofdays;
private String name,department,designation,level,typeofleave,applieddate,datefrom,dateto,status,remark;
public RequestedLeave(int employeeid, String name, String department,String designation,String level,String typeofleave,String applieddate,int noofdays,String datefrom,String dateto,String status,String remark) 
{
	
	this.employeeid = employeeid;
	this.name = name;
	this.department = department;
	this.designation=designation;
	this.level = level;
	this.typeofleave = typeofleave;
	this.applieddate = applieddate;
	this.noofdays = noofdays;
	this.datefrom = datefrom;
	this.dateto = dateto;
	this.status=status;
	this.remark=remark;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
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

public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public String getTypeofleave() {
	return typeofleave;
}
public void setTypeofleave(String typeofleave) {
	this.typeofleave = typeofleave;
}
public String getApplieddate() {
	return applieddate;
}
public void setApplieddate(String applieddate) {
	this.applieddate = applieddate;
}
public int getNoofdays() {
	return noofdays;
}
public void setNoofdays(int noofdays) {
	this.noofdays = noofdays;
}
public String getDatefrom() {
	return datefrom;
}
public void setDatefrom(String datefrom) {
	this.datefrom = datefrom;
}
public String getDateto() {
	return dateto;
}
public void setDateto(String dateto) {
	this.dateto = dateto;
}
}
