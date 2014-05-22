package General;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.FileReadWriteConsultantdetail;
import Database.FileReadWritePupil;
import Database.FileReadWriteRegularEmployeedetail;
import Database.FileReadWritelogindetail;
import GUI.Edituserloginpage;

public class Fetch 

{private ArrayList<Logindetail> listlogin;
private ArrayList<Employee> list;


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

private String username,name,dateofjoining,department,designation,mobno,bloodgroup,email,password,usertype,level;

	public String getLevel() {
	return level;
}



	public Fetch(int userid)
	{
		listlogin=new ArrayList<Logindetail>();
		
		try
		{
			listlogin=FileReadWritelogindetail.readingFromUserDetailsDB();
		}
		catch (Exception e)
		{
			//JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
			
		}
		
		
		//int location=-1;
		list=new ArrayList<Employee>();
		for(int index=0;index<listlogin.size();index++)
		{
			Logindetail detail=listlogin.get(index);
			if(userid==detail.getEmployeeid())
			{
				//location=index;
				//JOptionPane.showMessageDialog(lblemployeeiddata,""+detail.getUsertype());
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
			level=employee.getLevel();
			mobno=employee.getMobno();
			bloodgroup=employee.getBloodgroup();
			email=employee.getEmail();
			password=employee.getPassword();
			usertype=employee.getUsertype();
		}
		}

	}

	public static void main(String[] args) {
		

	}

}
