package General;

import java.io.Serializable;
import java.util.ArrayList;

import Database.AttendanceStorge;
import Database.FileReadWritePLCLdetail;

public class Report implements Serializable {

	private String name,department;
	private int userid,noofdaysabsent,noofdayspresent,totallate,pl,cl;
	private ArrayList<plcldata> listplcl;
	private ArrayList<Attendance> listattendance;
	
	
	/*public Report(int userid,String word) 
	{
		listplcl=new ArrayList<plcldata>();
		try 
		{
			listplcl=FileReadWritePLCLdetail.readingFromPLCLdetail();
		}
		catch (Exception e) 
		{
			//JOptionPane.showMessageDialog(this,"File not found");
		}
		
		for(int index=0;index<listplcl.size();index++)
			{
				plcldata detail=listplcl.get(index);
				if(detail.getEmployeeid()==userid)
	        	{
				name=detail.getName();
				department=detail.getDepartment();
	        	pl=detail.getPl();
	        	cl=detail.getCl();
	        	
	        	}
			
			}

		 listattendance=new ArrayList<Attendance>();
	        //reading data in list   	
	    	try
	    	{
	    		listattendance=AttendanceStorge.readingFromUserAttendanceDB();
	    	}
	    	catch (Exception e)
	    	{
	    		//JOptionPane.showMessageDialog(btnintime,"File not found");
	    		
	    	}
	    	for(int index=0;index<listattendance.size();index++)
			{
	    		Attendance detail=listattendance.get(index);
	    		if(userid==detail.getId())
	    			{
	    			
	    				String date=detail.getDate();
	    				boolean found= date.contains(word);
	    				if(found==true)
	    				{
	    					++noofdayspresent;
	    				}
	    				if(detail.getLatemin()>0)
	    				{
	    					++totallate;
	    				}
	    		}
	    	 }
	    	noofdaysabsent=30-noofdayspresent;
		
		}*/
	public String getName() {
		return name;
	}
	public Report(String name, String department, int userid,
			int noofdaysabsent, int noofdayspresent, int totallate, int pl,
			int cl) {
		super();
		this.name = name;
		this.department = department;
		this.userid = userid;
		this.noofdaysabsent = noofdaysabsent;
		this.noofdayspresent = noofdayspresent;
		this.totallate = totallate;
		this.pl = pl;
		this.cl = cl;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getNoofdaysabsent() {
		return noofdaysabsent;
	}
	public void setNoofdaysabsent(int noofdaysabsent) {
		this.noofdaysabsent = noofdaysabsent;
	}
	public int getNoofdayspresent() {
		return noofdayspresent;
	}
	public void setNoofdayspresent(int noofdayspresent) {
		this.noofdayspresent = noofdayspresent;
	}
	public int getTotallate() {
		return totallate;
	}
	public void setTotallate(int totallate) {
		this.totallate = totallate;
	}
	public int getPl() {
		return pl;
	}
	public void setPl(int pl) {
		this.pl = pl;
	}
	public int getCl() {
		return cl;
	}
	public void setCl(int cl) {
		this.cl = cl;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
