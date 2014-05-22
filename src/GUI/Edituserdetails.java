package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Validate.Valid;

import Database.FileReadWriteConsultantdetail;
import Database.FileReadWritePupil;
import Database.FileReadWriteRegularEmployeedetail;
import Database.FileReadWritelogindetail;
import General.Consultant;
import General.Employee;
import General.Logindetail;
import General.Maintainid;
import General.Pupil;
import General.RegularEmployee;

public class Edituserdetails extends JFrame implements ActionListener
{
	
	private JButton btnsubmit,btncancel;
	private JTextField txtusername,txtfirstname,txtmiddlename,txtlastname,txtdateofjoining,txtmobno,txtbloodgroup,txtemail;
	private JPasswordField txtpassword,txtrepassword;
	private JLabel lbldepartmentdata,lbldesignationdata,lblleveldata,lbllevel,lblemployeeid,lblusertype,lblusertypedata,lblemployeeiddata,lblusername,lblfirstname,lblmiddlename,lbllastname,lbldateofjoining,lbldepartment,lbldesignation,lblmobno,lblpassword,lblrepassword,lblbloodgroup,lblAddress,lblemail;
	private Box boxemployeeid,boxtype,boxnamelbl,boxfirstname,boxmiddlename,boxlastname,boxname,boxdet,boxdepdesiglabel,boxdepdesigtext,boxdojbldgrplabel,boxdojbldgrptext,boxaddress,boxmobile,boxuser,boxuserlabel,boxusertxt,boxbutton,boxinput;
	private JTextArea txtaddress;
	//private JRadioButton rdusertype[];
	private JPanel pnl;
	private ButtonGroup group;
	private ArrayList<Logindetail> listlogin;
	private ArrayList<Employee> list;
	//private Box //boxlevel;
	//private TitledBorder title;
	//private JFrame frmtype;
	
	
	
	
public Edituserdetails()

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

		
	 btnsubmit=new JButton("SUBMIT");
	 btncancel=new JButton("CANCEL");
	 lblusername=new JLabel("Username");
	 lblemployeeid=new JLabel("Employee ID");
	 lblusertype=new JLabel("User Type");
	 lblusertypedata=new JLabel("");
	 lbllevel=new JLabel("Level");
	 lblemployeeiddata=new JLabel(" "+Edituserloginpage.getuserid());
	 lblpassword=new JLabel("Password");
	 lblrepassword=new JLabel("Password");
	 txtusername= new JTextField(10);
	 txtpassword=new JPasswordField(10);
	 txtrepassword=new JPasswordField(10);
	 txtfirstname= new JTextField(10);
	 txtmiddlename= new JTextField(10);
	 txtlastname= new JTextField(10);
	 txtdateofjoining= new JTextField(10);
	 lbldepartmentdata= new JLabel("");
	 lbldesignationdata= new JLabel("");
	 lblleveldata= new JLabel("");
	 txtmobno= new JTextField(10);
	 txtbloodgroup= new JTextField(10);
	 txtaddress= new JTextArea(4,40);
	 txtemail= new JTextField(10);
	 lblfirstname=new JLabel("First Name");
	 lblmiddlename=new JLabel("Middle Name");
	 lbllastname=new JLabel("Last Name");
	 lbldateofjoining=new JLabel("Date Of Joining");
	 lbldepartment=new JLabel("Department");
	 lbldesignation=new JLabel("Designation");
	 lblmobno=new JLabel("Mob No");
	 lblpassword=new JLabel("Password");
	 lblrepassword=new JLabel("Re-Password");
	 lblbloodgroup=new JLabel("Bloodgroup");
	 lblAddress=new JLabel("Address");
	 lblemail=new JLabel("E-mail");
	 
	 	boxemployeeid=Box.createHorizontalBox(); 
	 	boxtype=Box.createHorizontalBox();
		boxfirstname=Box.createVerticalBox();
		boxmiddlename=Box.createVerticalBox();
		boxlastname=Box.createVerticalBox();
		boxname=Box.createHorizontalBox();
		boxdepdesiglabel=Box.createVerticalBox();
		boxdepdesigtext=Box.createVerticalBox();
		boxdojbldgrplabel=Box.createVerticalBox();
		boxdojbldgrptext=Box.createVerticalBox();
		boxaddress=Box.createHorizontalBox();		
		boxmobile=Box.createHorizontalBox();
		boxbutton=Box.createHorizontalBox();
		boxuser=Box.createHorizontalBox();
		boxuserlabel=Box.createVerticalBox();
		boxusertxt=Box.createVerticalBox();
		boxinput=Box.createVerticalBox();
		boxdet=Box.createHorizontalBox();
		
		
		//boxemployeeid.add(Box.createRigidArea(new Dimension(10,30)));
		boxemployeeid.add(lblemployeeid);
		boxemployeeid.add(lblemployeeiddata);
		boxfirstname.add(lblfirstname);
		//boxfirstname.setMaximumSize(new Dimension(9000,7000));
		
		boxfirstname.add(txtfirstname);
		boxmiddlename.add(lblmiddlename);
		boxmiddlename.add(txtmiddlename);
		//boxmiddlename.setMaximumSize(new Dimension(9000,7000));
		boxlastname.add(lbllastname);			
		boxlastname.add(txtlastname);
		//boxlastname.setMaximumSize(new Dimension(9000,7000));
		boxname.add(boxfirstname);
		boxname.add(boxmiddlename);
		boxname.add(boxlastname);
		//boxname.setMaximumSize(new Dimension(9000,7000));
	
		boxdepdesiglabel.add(lbldepartment);
		boxdepdesiglabel.add(lbldesignation);
		boxdepdesiglabel.add(lbllevel);
		boxdepdesigtext.add(lbldepartmentdata);
		boxdepdesigtext.add(lbldesignationdata);
		boxdepdesigtext.add(lblleveldata);
		
		
		boxdojbldgrplabel.add(lbldateofjoining);
		boxdojbldgrplabel.add(lblbloodgroup);
		boxdojbldgrptext.add(txtdateofjoining);
		boxdojbldgrptext.add(txtbloodgroup);
		
		
		boxdet.add(boxdojbldgrplabel);
		boxdet.add(boxdojbldgrptext);
		boxdet.add(boxdepdesiglabel);
		boxdet.add(boxdepdesigtext);
		
		boxaddress.add(lblAddress);
		boxaddress.add(txtaddress);
		//txtAddress.setMaximumSize(new Dimension(700,700));
		
		boxmobile.add(lblmobno);
		boxmobile.add(txtmobno);
		
		
		boxuserlabel.add(lblusername);
		boxuserlabel.add(lblpassword);
		boxuserlabel.add(lblrepassword);
		boxusertxt.add(txtusername);
		boxusertxt.add(txtpassword);
		boxusertxt.add(txtrepassword);
		boxuser.add(boxuserlabel);
		boxuser.add(boxusertxt);
		
		boxtype.add(lblusertype);
		boxtype.add(lblusertypedata);
		//lblusertype.setBounds(100, 50, 100, 50);
		
		//title = BorderFactory.createTitledBorder("Choose The User Type");
		//boxtype.setBorder(title);
		
		
		boxinput.add(Box.createRigidArea(new Dimension(10,30)));
		boxinput.add(boxemployeeid);
		boxinput.add(Box.createRigidArea(new Dimension(10,30)));
		boxinput.add(boxtype);
		boxinput.add(Box.createRigidArea(new Dimension(10,30)));
		boxinput.add(boxname);
		boxinput.add(Box.createRigidArea(new Dimension(0,30)));
		boxinput.add(boxdet);
		boxinput.add(Box.createRigidArea(new Dimension(17,10)));
		boxinput.add(boxaddress);
		boxinput.add(Box.createRigidArea(new Dimension(17,10)));
		boxinput.add(boxmobile);
		boxinput.add(Box.createRigidArea(new Dimension(17,10)));
		boxinput.add(boxuser);
		boxinput.add(Box.createRigidArea(new Dimension(17,10)));
		//boxinput.setVisible(false);
		//boxinput.setMaximumSize(new Dimension(170,100));
		
		boxbutton.add(Box.createRigidArea(new Dimension(170,10)));
		boxbutton.add(btnsubmit);
		boxbutton.add(Box.createRigidArea(new Dimension(30,10)));
		boxbutton.add(btncancel);
		btnsubmit.setMaximumSize(btncancel.getMaximumSize());
		
		
		//add(boxtype,BorderLayout.NORTH);
		 add(boxbutton,BorderLayout.SOUTH);
		 add(boxinput,BorderLayout.CENTER);
			setSize(750,600);
			setVisible(true);
			setTitle("Edit User");
			setLocationRelativeTo(null);
			
			
		 
		 btnsubmit.addActionListener(this);
		 btncancel.addActionListener(this);
		 getdata();
}
public void getlocation()
{
	//int location=-1;
	list=new ArrayList<Employee>();
	for(int index=0;index<listlogin.size();index++)
	{
		Logindetail detail=listlogin.get(index);
		if(Edituserloginpage.getuserid()==detail.getEmployeeid())
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
					JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
			
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
					JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
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
					JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
					e.printStackTrace();
				}
			}
		}
	}
	//return location;
}

public void getdata() 
{getlocation();
	
		//int location=getlocation();
		for(int index=0;index<list.size();index++)
		{
		Employee employee=list.get(index);
		if(Edituserloginpage.getuserid()==employee.getEmployeeid())
		{
			txtusername.setText(employee.getUsername());
			txtfirstname.setText(employee.getFirstname());
			txtmiddlename.setText(employee.getMiddlename());
			txtlastname.setText(employee.getLastname());
			txtdateofjoining.setText(employee.getDateofjoining());
			lbldepartmentdata.setText(employee.getDepartment());
			lbldesignationdata.setText(employee.getDesignation());
			lblleveldata.setText(employee.getLevel());
			txtaddress.setText(employee.getAddress());
			txtmobno.setText(employee.getMobno());
			txtbloodgroup.setText(employee.getBloodgroup());
			txtemail.setText(employee.getEmail());
			txtpassword.setText(employee.getPassword());
			txtrepassword.setText(employee.getPassword());
			lblusertypedata.setText(employee.getUsertype());
		}
		}
		
	}

public void blankcheck()
{
	boolean check=false;
	boolean checkmsg = false;
	String usertype = null;
	int employeeid=Maintainid.getId();
	String username=txtusername.getText().trim();
	String firstname=txtfirstname.getText().trim();
	String address=txtaddress.getText().trim();
	String lastname=txtlastname.getText().trim();
	String dateofjoining=txtdateofjoining.getText().trim();
	//String department=(String) cmbdepartment.getSelectedItem();
	//String designation=(String) cmbdesignation.getSelectedItem();
	//String level=(String)cmblevel.getSelectedItem();
	String mobno=txtmobno.getText().trim();
	String password=txtpassword.getText();
	String repassword=txtrepassword.getText();
	String bloodgroup=txtbloodgroup.getText().trim();
	
	
	if(Valid.isEmpty(address)==true)
	{
		txtaddress.setBackground(Color.RED);
		check=true;
	}
	else
		txtaddress.setBackground(Color.WHITE);
	if(Valid.isEmpty(firstname)==true)
	{
		txtfirstname.setBackground(Color.RED);
		check=true;
	}
	else
		txtfirstname.setBackground(Color.WHITE);
	
	if(Valid.isEmpty(lastname)==true)
	{
		txtlastname.setBackground(Color.RED);
		check=true;
	}
	else
		txtlastname.setBackground(Color.WHITE);
	
	if(Valid.isEmpty(dateofjoining)==true)
	{
		txtdateofjoining.setBackground(Color.RED);
		check=true;
	}
	else
		txtdateofjoining.setBackground(Color.WHITE);
	
	

	if(Valid.isEmpty(mobno)==true)
	{
		txtmobno.setBackground(Color.RED);
		check=true;
	}
	else
		if(Valid.isMobileNO(mobno)==false)
		{
			txtmobno.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this,"Invalid mobile number");
			check=true;
			checkmsg=true;
		}
		else
			txtmobno.setBackground(Color.WHITE);
	
	if(Valid.isEmpty(username)==true)
	{
		txtusername.setBackground(Color.RED);
		check=true;
	}
	else
		if(Valid.isEmail(username)==false)
		{
			txtusername.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this,"Invalid email");
			check=true;
			checkmsg=true;
		}
		else
			txtusername.setBackground(Color.WHITE);
			
	
	if(Valid.isEmpty(password)==true||Valid.isEmpty(repassword))
	{
		txtpassword.setBackground(Color.RED);
		txtrepassword.setBackground(Color.RED);
		check=true;
	}
	else
		/*if(Valid.isPassword(password)==false)
		{
			txtpassword.setBackground(Color.RED);
			txtrepassword.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this,"Invalid password");
			check=true;
			checkmsg=true;
		}
		else*/
			if(password.equals(repassword)==false)
			{
				txtpassword.setBackground(Color.RED);
				txtrepassword.setBackground(Color.RED);
				check=true;
				checkmsg=true;
				JOptionPane.showMessageDialog(this,"password not matching");
			}
			else	
			txtpassword.setBackground(Color.WHITE);
	
	if(Valid.isEmpty(bloodgroup)==true)
	{
		txtbloodgroup.setBackground(Color.RED);
		check=true;
	}
	else
		txtbloodgroup.setBackground(Color.WHITE);
	
	if(check==true)
	{
		if(checkmsg==false)
		JOptionPane.showMessageDialog(this,"PLEASE VERIFY YOUR DATA AGAIN");
	}
	else
	{		
		setdata();
	}
		
}

	public void setdata()
	{
		getlocation();
		 
		for(int index=0;index<list.size();index++)
		{
		Employee employee=list.get(index);
		if(Edituserloginpage.getuserid()==employee.getEmployeeid())
		{
				String username=txtusername.getText();
				employee.setUsername(username);
				String firstname=txtfirstname.getText();
				employee.setFirstname(firstname);
				String middlename=txtmiddlename.getText();
				employee.setMiddlename(middlename);
				String lastname=txtlastname.getText();
				employee.setLastname(lastname);
				String dateofjoining=txtdateofjoining.getText();
				employee.setDateofjoining(dateofjoining);
				String address=txtaddress.getText();
				employee.setAddress(address);
				String mobno=txtmobno.getText();
				employee.setMobno(mobno);
				String bloodgroup=txtbloodgroup.getText();
				employee.setBloodgroup(bloodgroup);
				String email=txtemail.getText();
				employee.setEmail(email);
				String password=txtpassword.getText();
				
				employee.setPassword(password);
							
			}
			
		
			if ((employee.getUsertype()).equalsIgnoreCase("REGULAR EMPLOYEE"))
			{
			
					try
				{
					FileReadWriteRegularEmployeedetail.writingToRegularEmployeedetail(list);
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
					
				}
			}
				
			

			if ((employee.getUsertype()).equalsIgnoreCase("PUPIL"))
					
			{
				try
				{
					FileReadWritePupil.writingToPupildetail(list);
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
				}
			}
			
			if ((employee.getUsertype()).equalsIgnoreCase("CONSULTANT"))
			{
				
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
		for(int index=0;index<list.size();index++)
		{
			Logindetail detail=listlogin.get(index);
			if(Edituserloginpage.getuserid()==detail.getEmployeeid())
			{
				String username=txtusername.getText();
				detail.setUsername(username);
				String password=txtpassword.getText();
				detail.setPassword(password);
			}
		}
		try
		{
			FileReadWritelogindetail.writingToUserDetailsDB(listlogin);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
		}
		
			
	}
		
	

	
public void actionPerformed(ActionEvent event)
{
	if (event.getSource()==btnsubmit)
	{
		blankcheck();
		JOptionPane.showMessageDialog(this,"Changes Saved Successfully");
	}

}

}
