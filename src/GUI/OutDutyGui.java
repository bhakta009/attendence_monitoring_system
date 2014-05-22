package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Validate.Valid;

import Database.AttendanceStorge;
import Database.FileReadWriteConsultantdetail;
import Database.FileReadWriteOutDuty;
import Database.FileReadWritePupil;
import Database.FileReadWriteRegularEmployeedetail;
import Database.FileReadWritelogindetail;
import General.Attendance;
import General.Employee;
import General.Fetch;
import General.Logindetail;
import General.Outduty;



public class OutDutyGui extends JFrame implements ActionListener{
	private JButton btnsubmit,btncancel,btnshowform,btntime;
	private JTextField txtemployeeid,txttimeout,txtreason;
	private JLabel lbltimeout,lblreason,lbllevel,lblnametext,lbldateofjoiningtext,lbldepartmenttext,lbldesignationtext,lblusertype;
	private JLabel lblemployeeid,lblleveldata,lblusertypedata,lblemployeeiddata,lblname,lbldateofjoining,lbldepartment,lbldesignation;
	private Box boxlabel,boxtext,boxinput,boxbutton,boxuserinput,boxtime;
	//private JTextArea txtAddress;
	private ArrayList<Logindetail> listlogin;
	private ArrayList<Employee> list;
	private ArrayList<Outduty> listoutduty;
	private JLabel lblemployeeidlabel;
	private int position;
	private ArrayList<Attendance> listsetouttime;
	
	
	
public OutDutyGui()
{
	
listlogin=new ArrayList<Logindetail>();
	
	try
	{
		listlogin=FileReadWritelogindetail.readingFromUserDetailsDB();
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(this,"File not found");
		
	}
	listoutduty=new ArrayList<Outduty>();
	
	try
	{
		listoutduty=FileReadWriteOutDuty.readingFromOutDutydetail();
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(this,"File not found");
		
	}
	
	 btnsubmit=new JButton("SUBMIT");
	 btncancel=new JButton("CANCEL");
	 btnshowform=new JButton("SHOW FORM");
	 btntime=new JButton("GET TIME");
	 //boxlabel.add(lblusername);
		
	 
	 //lblusername=new JLabel("Username");
	 lblemployeeid=new JLabel("Enter Employee ID");
	 lblemployeeidlabel=new JLabel("Employee ID");
	 lblusertype=new JLabel("User Type");
	 lblname=new JLabel("Name");
	 lbldateofjoining=new JLabel("Date Of Joining");
	 lbldepartment=new JLabel("Department");
	 lbldesignation=new JLabel("Designation");
	 lbllevel=new JLabel("Level");
	 lblreason=new JLabel("Reason");
	 lbltimeout=new JLabel("Time Out");
	 
	 
	 txtemployeeid=new JTextField(10);
	 lblemployeeiddata=new JLabel("----");
	 lblusertypedata=new JLabel("----");
	 lblnametext=new JLabel("----");
	 lbldateofjoiningtext=new JLabel("----");
	 lbldepartmenttext=new JLabel("----");
	 lbldesignationtext=new JLabel("----");
	 lblleveldata=new JLabel("----");
	 txtreason=new JTextField("");
	 txttimeout=new JTextField("");
	 
	
	 boxlabel=Box.createVerticalBox();
		boxtext=Box.createVerticalBox();
		boxbutton=Box.createHorizontalBox();
		boxinput=Box.createHorizontalBox();
		boxuserinput=Box.createHorizontalBox();
		boxtime=Box.createHorizontalBox();
		
		boxbutton.add(Box.createRigidArea(new Dimension(150, 30)));
		boxbutton.add(btnsubmit);
		boxbutton.add(Box.createRigidArea(new Dimension(10, 10)));
		boxbutton.add(btncancel);
		
		
		boxlabel.add(lblemployeeidlabel);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lblusertype);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lblname);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbldateofjoining);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbldepartment);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbldesignation);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbllevel);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbltimeout);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lblreason);
		//boxlabel.setMaximumSize(new Dimension(100,200));
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		boxtime.add(txttimeout);
		boxtime.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtime.add(btntime);
		
		boxtext.add(lblemployeeiddata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lblusertypedata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lblnametext);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lbldateofjoiningtext);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lbldepartmenttext);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lbldesignationtext);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lblleveldata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(boxtime);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(txtreason);
		
		txtreason.setMaximumSize(new Dimension(500,100));		
		txttimeout.setMaximumSize(new Dimension(100,30));
		boxlabel.setMaximumSize(new Dimension(150,300));
		boxtext.setMaximumSize(new Dimension(300,300));
		
		boxuserinput.add(lblemployeeid);
		boxuserinput.add(txtemployeeid);
		boxuserinput.add(btnshowform);
		
		//boxinput.add(Box.createRigidArea(new Dimension(10,30)));
		boxinput.add(boxlabel);	
		//boxinput.add(Box.createRigidArea(new Dimension(0,0)));
		boxinput.add(boxtext);
		//boxinput.add(Box.createRigidArea(new Dimension(10,30)));
		//boxinput.setMaximumSize(new Dimension(300,200));
	 	
		
		
		
		
		boxbutton.add(Box.createRigidArea(new Dimension(0,10)));
		boxbutton.add(btnsubmit);
		boxbutton.add(Box.createRigidArea(new Dimension(30,10)));
		boxbutton.add(btncancel);
		//btncancel.setMaximumSize(btnsubmit.getMaximumSize());
		boxbutton.setEnabled(false);
		boxinput.setEnabled(false);
		 add(boxuserinput,BorderLayout.NORTH);
		 add(boxbutton,BorderLayout.SOUTH);
		 add(boxinput,BorderLayout.CENTER);
			setSize(450,500);
			setVisible(true);
			setTitle("Out duty ");
			
			boxbutton.setVisible(false);
			boxinput.setVisible(false);	
		
		 btnsubmit.addActionListener(this);
		 btncancel.addActionListener(this);
		 btnshowform.addActionListener(this);
		 btntime.addActionListener(this);
		 
}

public void getdata()
{
	if(Valid.isEmpty(txtemployeeid.getText().trim())==false)
	{
	list=new ArrayList<Employee>();
	for(int index=0;index<listlogin.size();index++)
	{
		Logindetail detail=listlogin.get(index);
		if(detail.getEmployeeid()==Integer.parseInt(txtemployeeid.getText()))
		{
			//JOptionPane.showMessageDialog(this,""+detail.getUsertype());
			if ((detail.getUsertype()).equalsIgnoreCase("REGULAR EMPLOYEE"))
			{
				try
				{
					list=FileReadWriteRegularEmployeedetail.readingFromRegularEmployeedetail();
					
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(this,"File not found");
			
				}
			}
			
			if (detail.getUsertype().equalsIgnoreCase("PUPIL"))
			{
				try
				{
					list=FileReadWritePupil.readingFromPupildetail();
					
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(this,"File not found");
				}
			}
			if (detail.getUsertype().equalsIgnoreCase("CONSULTANT"))
			{
				try
				{
					list=FileReadWriteConsultantdetail.readingFromConsultantdetail();
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(this,"File not found");
					//e.printStackTrace();
				}
			}
			
		}
	}
	setdata();
	}
	else
		JOptionPane.showMessageDialog(this,"Please enter a valid ID");
}
	


	public void setdata() 
	{
		boolean check=false;
		for(int index=0;index<list.size();index++)
		{
			
			Employee employee=list.get(index);
			if(Integer.parseInt(txtemployeeid.getText())==employee.getEmployeeid())
			{ 
				position=index;
				lblemployeeiddata.setText(""+employee.getEmployeeid());
				
				lblnametext.setText(employee.getFirstname()+" "+employee.getMiddlename()+" "+employee.getLastname());
				lbldateofjoiningtext.setText(employee.getDateofjoining());
				lbldepartmenttext.setText(employee.getDepartment());
				lbldesignationtext.setText(employee.getDesignation());
				lblleveldata.setText(employee.getLevel());
				lblusertypedata.setText(employee.getUsertype());
				//btndelete.setEnabled(true);
				check=true;
								
			}
		}
		if(check==false)
		{
			JOptionPane.showMessageDialog(lblemployeeiddata,"data not found");
			lblnametext.setText("N/A");
			lbldateofjoiningtext.setText("N/A");
			lbldepartmenttext.setText("N/A");
			lbldesignationtext.setText("N/A");
			lblusertypedata.setText("N/A");
			lblleveldata.setText("N/A");
			//btndelete.setEnabled(false);
		}
		boxbutton.setVisible(true);
		boxinput.setVisible(true);
		txttimeout.setText("");
		txtreason.setText("");
		}
	
	public void submit()
	{
		//get date
		int id=Login.getUserid();
		Fetch fetch=new Fetch(id);
		Date d =new Date();
		d.getDate();
		DateFormat outdate;
        outdate=DateFormat.getDateInstance();
        Outduty ref;
        boolean check=false;
		Employee employee=list.get(position);
		
		int employeeid=employee.getEmployeeid();
		String name=employee.getFirstname()+" "+employee.getMiddlename()+" "+employee.getLastname();
		String department=employee.getDepartment();
		String designation=employee.getDesignation();
		String date=outdate.format(d);
		String timeout=txttimeout.getText().trim();
		String reason=txtreason.getText().trim();
		boolean verify=writetoinoutdb(employeeid,date);
		        //if date exists
		if(verify==true)
		{
		        for(int index=0;index<listoutduty.size();index++)
		        {
		        	Outduty detail=listoutduty.get(index);
	        		//JOptionPane.showMessageDialog(lblemployeeiddata,""+employee.getEmployeeid()+"...."+detail.getEmployeeid());

		        	if(employee.getEmployeeid()==detail.getEmployeeid())
		        	{
		        		//JOptionPane.showMessageDialog(lblemployeeiddata,""+date+"...."+detail.getDate());
		        		if(date.equals(detail.getDate()))
		        		{
		        			if(detail.getTimeout()!=null)
		        			{
		        			
		        			check=true;
		        			}
		        		}
		        	}
		        }
		        	if(check==false)
		        		{		        
		        			ref=new Outduty(employeeid,name,department,designation,date,timeout,reason);
		        			listoutduty.add(ref);
		        			try
		        			{
		        			FileReadWriteOutDuty.writingToOutDutydetail(listoutduty);
							
		        			}
		        			catch (Exception e)
		        			{
							JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
					
		        			}
		        			JOptionPane.showMessageDialog(lblemployeeiddata,"submitted");
		        			txttimeout.setText("");
		        			txtreason.setText("");	        			
		        	
		        	     }	
		        	else
		        		JOptionPane.showMessageDialog(lblemployeeiddata,"out duty already granted");
		}
		else
			JOptionPane.showMessageDialog(lblemployeeiddata,"In Time not marked by the user");
		
		//writetoinoutdb(employeeid,date);
	}

	
	
	
	public boolean writetoinoutdb(int employeeid,String date)
	{
		String timeout=txttimeout.getText().trim();
		listsetouttime=new ArrayList<Attendance>();
		boolean check=false;
        //reading data in list   	
    	try
    	{
    		listsetouttime=AttendanceStorge.readingFromUserAttendanceDB();
    	}
    	catch (Exception e)
    	{
    		JOptionPane.showMessageDialog(txttimeout,"File not found");
    		
    	}
		for(int index=0;index<listsetouttime.size();index++)
		{
    		Attendance detail=listsetouttime.get(index);
		
    	if(employeeid==detail.getId())
    	 {
    		if(detail.getDate().equalsIgnoreCase(date));
    		{
    			if(detail.getIntime()!=null)
    			{
    				
    				if(detail.getOuttime()==null)
    				{
    			  detail.setOuttime(timeout);
    			  //check=true;
    			
    				}
    				check=true;
    			 
    			}
    	   }
    	 }
		}
		
		
		try
        {
        	AttendanceStorge.writingToUserAttendanceDB(listsetouttime);
        	
        }
        catch(Exception exp)
        {
        	System.out.println("Cannot write to database");
        }
		return check;
	}




public void actionPerformed(ActionEvent event)
{

	if (event.getSource()==btnshowform)
	{
		getdata();

	}
	if (event.getSource()==btntime)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		txttimeout.setText(sdf.format(new Date()));
	}
	
	if (event.getSource()==btnsubmit)
	{
		submit();
	}
	
	
}
public static void main(String[]arg)
{
new OutDutyGui();
}
}