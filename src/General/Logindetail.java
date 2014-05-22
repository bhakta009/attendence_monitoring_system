package General;

import java.io.Serializable;

public class Logindetail implements Serializable {
	private int employeeid;
	private String username,password,usertype,admin;
	
	public Logindetail(int employeeid, String username, String password,
			String usertype, String admin) {
		this.employeeid = employeeid;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.admin = admin;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
}

	