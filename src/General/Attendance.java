package General;
import java.io.Serializable;

import Database.AttendanceStorge;
//import Database.FileReadWrite;

public class Attendance implements Serializable{
	private  int id,Latemin;
	private String Name, date,intime,outtime;

	public Attendance(int id, String name, String date, String intime,
			String outtime,int Latemin) {
		super();
		this.id = id;
		Name = name;
		this.date = date;
		this.intime = intime;
		this.outtime = outtime;
		this.Latemin=Latemin;
	}

	public int getLatemin() {
		return Latemin;
	}

	public void setLatemin(int latemin) {
		Latemin = latemin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	
	public static void main(String[] args) {
	

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public String getDate() {
		return date;
	}

	public String getIntime() {
		return intime;
	}

	public String getOuttime() {
		return outtime;
	}

}
