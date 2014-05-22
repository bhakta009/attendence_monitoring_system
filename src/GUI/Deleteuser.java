package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Validate.Valid;

import Database.FileReadWriteConsultantdetail;
import Database.FileReadWritePupil;
import Database.FileReadWriteRegularEmployeedetail;
import Database.FileReadWritelogindetail;
import General.Employee;
import General.Logindetail;

public class Deleteuser extends JFrame implements ActionListener
{
	
	private JButton btndelete,btncancel,btnshowdetails;
	private JTextField txtemployeeid;
	private JLabel lblleveldata,lblAddressdata,lblusernamedata,lblnamedat,lbldateofjoiningdata,lbldepartmentdata,lbldesignationdata,lblmobnodata,lblbloodgroupdata,lblemaildata;
	private JPasswordField txtpassword,txtrepassword;
	private JLabel lbllevel,lblemployeeid,lblusertype,lblusertypedata,lblemployeeiddata,lblusername,lblname,lbldateofjoining,lbldepartment,lbldesignation,lblmobno,lblpassword,lblrepassword,lblbloodgroup,lblAddress,lblemail;
	private Box boxlabel,boxdata,boxdetail,boxusertxt,boxbutton,boxinput;
	private JTextArea txtAddress;
	//private JRadioButton rdusertype[];
	private JPanel pnl;
	private ButtonGroup group;
	private ArrayList<Logindetail> listlogin;
	private ArrayList<Employee> list;
	
	
	
public Deleteuser()
{
listlogin=new ArrayList<Logindetail>();
	
	try
	{
		listlogin=FileReadWritelogindetail.readingFromUserDetailsDB();
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
		
	}
	
		
	 btndelete=new JButton("DELETE");
	 btncancel=new JButton("CANCEL");
	 btnshowdetails=new JButton("SHOW DETAIL");
	 //boxlabel.add(lblusername);
		
	 
	 lblusername=new JLabel("Username");
	 lblemployeeid=new JLabel("Employee ID");
	 lblusertype=new JLabel("User Type");
	 lblname=new JLabel("Name");
	 lbldateofjoining=new JLabel("Date Of Joining");
	 lbldepartment=new JLabel("Department");
	 lbldesignation=new JLabel("Designation");
	 lbllevel=new JLabel("Level");
	 lblmobno=new JLabel("Mob No");
	 lblbloodgroup=new JLabel("Bloodgroup");
	 lblAddress=new JLabel("Address");
	 lblemail=new JLabel("E-mail");
	 
	
	 
	 txtemployeeid=new JTextField(10);
	 lblusertypedata=new JLabel("----");
	 lblAddressdata=new JLabel("----");
	 lblusernamedata=new JLabel("----");
	 lblnamedat=new JLabel("----");
	 lbldateofjoiningdata=new JLabel("----");
	 lbldepartmentdata=new JLabel("----");
	 lbldesignationdata=new JLabel("----");
	 lblleveldata=new JLabel("----");
	 lblmobnodata=new JLabel("----");
	 lblbloodgroupdata=new JLabel("----");
	 lblemaildata=new JLabel("----");
	 
	 	boxlabel=Box.createVerticalBox();
	 	boxdata=Box.createVerticalBox();
		boxbutton=Box.createHorizontalBox();
		boxusertxt=Box.createHorizontalBox();
		boxinput=Box.createHorizontalBox();
		
		boxusertxt.add(lblemployeeid);
		boxusertxt.add(txtemployeeid);
		boxusertxt.add(btnshowdetails);
		
		boxlabel.add(lblname);
		boxlabel.add(lblusertype);
		boxlabel.add(lbldepartment);
		boxlabel.add(lbldesignation);
		boxlabel.add(lbllevel);
		boxlabel.add(lbldateofjoining);
		boxlabel.add(lblbloodgroup);
		boxlabel.add(lblAddress);
		boxlabel.add(lblmobno);
		boxlabel.add(lblusername);
		boxlabel.add(lblemail);
 
 boxdata.add(lblnamedat);
 boxdata.add(lblusertypedata);
 boxdata.add(lbldepartmentdata);
 boxdata.add(lbldesignationdata);
 boxdata.add(lblleveldata);
 boxdata.add(lbldateofjoiningdata);
 boxdata.add(lblbloodgroupdata);
 boxdata.add(lblAddressdata);
 boxdata.add(lblmobnodata);
 boxdata.add(lblusernamedata);
 boxdata.add(lblemaildata);
		
		
		
		boxinput.add(Box.createRigidArea(new Dimension(10,30)));
		boxinput.add(boxlabel);
		boxinput.add(Box.createRigidArea(new Dimension(10,30)));
		boxinput.add(boxdata);
		boxinput.add(Box.createRigidArea(new Dimension(10,30)));
		
		
		boxbutton.add(Box.createRigidArea(new Dimension(120,10)));
		boxbutton.add(btndelete);
		boxbutton.add(Box.createRigidArea(new Dimension(30,10)));
		boxbutton.add(btncancel);
		btndelete.setMaximumSize(btncancel.getMaximumSize());
		boxbutton.setEnabled(false);
		boxinput.setEnabled(false);
		 add(boxusertxt,BorderLayout.NORTH);
		 add(boxbutton,BorderLayout.SOUTH);
		 add(boxinput,BorderLayout.CENTER);
			setSize(450,400);
			setVisible(true);
			setTitle("delete User");
			setLocationRelativeTo(null);
			
			boxbutton.setVisible(false);
			boxinput.setVisible(false);			
		btndelete.setEnabled(false);
		
		 btndelete.addActionListener(this);
		 btncancel.addActionListener(this);
		 btnshowdetails.addActionListener(this);
}
	
public void getlocation()
{
  if(Valid.isEmpty(txtemployeeid.getText().trim())==false)
  {
	list=new ArrayList<Employee>();
	for(int index=0;index<listlogin.size();index++)
	{
		Logindetail detail=listlogin.get(index);
		if(detail.getEmployeeid()==Integer.parseInt(txtemployeeid.getText().trim()))
		{
			JOptionPane.showMessageDialog(lblemployeeiddata,""+detail.getUsertype());
			if ((detail.getUsertype()).equalsIgnoreCase("REGULAR EMPLOYEE"))
			{
				try
				{
					list=FileReadWriteRegularEmployeedetail.readingFromRegularEmployeedetail();
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
			
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
					JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
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
					e.printStackTrace();
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
	{//JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
		boolean check=false;
		for(int index=0;index<list.size();index++)
		{
			Employee employee=list.get(index);
			if(Integer.parseInt(txtemployeeid.getText())==employee.getEmployeeid())
			{
				lblusernamedata.setText(employee.getUsername());
				lblnamedat.setText(employee.getFirstname()+" "+employee.getMiddlename()+" "+employee.getLastname());
				lbldateofjoiningdata.setText(employee.getDateofjoining());
				lbldepartmentdata.setText(employee.getDepartment());
				lbldesignationdata.setText(employee.getDesignation());
				lblleveldata.setText(employee.getLevel());
				lblAddressdata.setText(employee.getAddress());
				lblmobnodata.setText(employee.getMobno());
				lblbloodgroupdata.setText(employee.getBloodgroup());
				lblemaildata.setText(employee.getEmail());
				lblusertypedata.setText(employee.getUsertype());
				btndelete.setEnabled(true);
				check=true;
			}
		}
		if(check==false)
		{
			JOptionPane.showMessageDialog(lblemployeeiddata,"data not found");
			lblusernamedata.setText("N/A");
			lblnamedat.setText("N/A");
			lbldateofjoiningdata.setText("N/A");
			lbldepartmentdata.setText("N/A");
			lbldesignationdata.setText("N/A");
			lblleveldata.setText("N/A");
			lblAddressdata.setText("N/A");
			lblmobnodata.setText("N/A");
			lblbloodgroupdata.setText("N/A");
			lblemaildata.setText("N/A");
			lblusertypedata.setText("N/A");
			btndelete.setEnabled(false);
		}
		boxbutton.setVisible(true);
		boxinput.setVisible(true);
		}
			
public void delete()
{
	Employee employee = null;
	for(int index=0;index<listlogin.size();index++)
	{
		Logindetail detail=listlogin.get(index);
		//System.out.println(""+employee.getEmployeeid()+"   "+Integer.parseInt(txtemployeeid.getText()));
		if(detail.getEmployeeid()==Integer.parseInt(txtemployeeid.getText()))
		{
			listlogin.remove(index);
			JOptionPane.showMessageDialog(lblemployeeiddata,"file Successfully deleted");
			break;
		}
	}
	for(int index=0;index<list.size();index++)
	{
		employee=list.get(index);
		//System.out.println(""+employee.getEmployeeid()+"   "+Integer.parseInt(txtemployeeid.getText()));
		if(employee.getEmployeeid()==Integer.parseInt(txtemployeeid.getText()))
		{
			list.remove(index);
			//JOptionPane.showMessageDialog(lblemployeeiddata,"file Successfully deleted");
			break;
		}
	}
	try {
		FileReadWritelogindetail.writingToUserDetailsDB(listlogin);
	}
	catch (Exception e) 
	{
		JOptionPane.showMessageDialog(btndelete,"File not found");
	}
	
	if ((employee.getUsertype()).equalsIgnoreCase("REGULAR EMPLOYEE"))
	{
	
		//list.add(adduser());
			try
		{
			FileReadWriteRegularEmployeedetail.writingToRegularEmployeedetail(list);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
			e.printStackTrace();
		}
	}
		
	

	if (employee.getUsertype().equalsIgnoreCase("PUPIL"))
			
	{
		//list.add(adduser());
		try
		{
			FileReadWritePupil.writingToPupildetail(list);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
		}
	}
	
	if (employee.getUsertype().equalsIgnoreCase("CONSULTANT"))
	{
		
		//list.add(adduser());
		try
		{
			FileReadWriteConsultantdetail.writingToConsultantdetail(list);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
		}
	}
}
		
			
		

		
	public void actionPerformed(ActionEvent event)
	{

		if (event.getSource()==btnshowdetails)
		{
			getlocation();
				
			//System.out.println("defjn");

		}
		if (event.getSource()==btndelete)
		{
		delete();
		}

	}
	public static void main(String[] args) 
	{
			new Deleteuser();
	}
}
