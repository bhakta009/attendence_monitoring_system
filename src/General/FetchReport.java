package General;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Validate.Valid;

import Database.AttendanceStorge;
import Database.FileReadWriteConsultantdetail;
import Database.FileReadWritePLCLdetail;
import Database.FileReadWritePupil;
import Database.FileReadWriteRegularEmployeedetail;
import Database.FileReadWritelogindetail;
import GUI.Edituserloginpage;
import GUI.Login;

public class FetchReport 

{

private ArrayList<Logindetail> listlogin;
private ArrayList<Employee> list;




private String username,name,dateofjoining,department,designation,mobno,bloodgroup,email,password,usertype,level;
private int pl,cl,userid,noofdaysabsent,noofdayspresent,totallate;
private ArrayList<plcldata> listplcl;
private ArrayList<Attendance> listattendance;

public FetchReport (int userid,String month,String year)
{
	get(userid);
	fetchattendance(month,year);
}

	
	public void get(int userid)
	{
		this.userid=userid;
		listlogin=new ArrayList<Logindetail>();
		
		try
		{
			listlogin=FileReadWritelogindetail.readingFromUserDetailsDB();
		}
		catch (Exception e)
		{
			//JOptionPane.showMessageDialog(this,"File not found");
			
		}
		
		
		list=new ArrayList<Employee>();
		for(int index=0;index<listlogin.size();index++)
		{
			Logindetail detail=listlogin.get(index);
			if(userid==detail.getEmployeeid())
			{
				if ((detail.getUsertype()).equalsIgnoreCase("REGULAR EMPLOYEE"))
				{
					try
					{
						list=FileReadWriteRegularEmployeedetail.readingFromRegularEmployeedetail();
					}
					catch (Exception e)
					{
						//JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
				
					}
				}
				
				if ((detail.getUsertype()).equalsIgnoreCase("PUPIL"))
				{
					try
					{
						list=FileReadWritePupil.readingFromPupildetail();
						
					}
					catch (Exception e)
					{
					//	JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
					}
				}
					if ((detail.getUsertype()).equalsIgnoreCase("CONSULTANT"))
				{
					try
					{
						list=FileReadWriteConsultantdetail.readingFromConsultantdetail();
					}
					catch (Exception e)
					{
						//JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
						e.printStackTrace();
					}
				}
			}
		}
		
		for(int index=0;index<list.size();index++)
		{
		Employee employee=list.get(index);
		if(userid==employee.getEmployeeid())
		{
			username=employee.getUsername();
			name=employee.getFirstname()+" "+employee.getMiddlename()+" "+employee.getLastname();
			dateofjoining=employee.getDateofjoining();
			department=employee.getDepartment();
			designation=employee.getDesignation();
			mobno=employee.getMobno();
			bloodgroup=employee.getBloodgroup();
			email=employee.getEmail();
			password=employee.getPassword();
			usertype=employee.getUsertype();
			level=employee.getLevel();
		}
		}
		fetchplcl();
		
	}
	public void fetchplcl()
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
	        	pl=detail.getPl();
	        	cl=detail.getCl();
	        	}
			
			}
	}
	
	public void fetchattendance(String word,String year)
	{
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
	    				boolean foundre= date.contains(year);
	    				if(found==true&&foundre==true)
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
	    	
	}
	
	
	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
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

	public String getBloodgroup() {
		return bloodgroup;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUsertype() {
		return usertype;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public ArrayList<plcldata> getListplcl() {
		return listplcl;
	}
	public void setListplcl(ArrayList<plcldata> listplcl) {
		this.listplcl = listplcl;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	

	public int getTotallate() {
		return totallate;
	}
	public void setTotallate(int totallate) {
		this.totallate = totallate;
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
	public static void main(String[] args) {
		

	}

}
