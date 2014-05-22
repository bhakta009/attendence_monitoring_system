package GUI;

	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Validate.Valid;

import Database.FileReadWriteConsultantdetail;
import Database.FileReadWritePLCLdetail;
import Database.FileReadWritePupil;
import Database.FileReadWriteRegularEmployeedetail;
import Database.FileReadWritelogindetail;
import General.Consultant;
import General.Employee;
import General.Logindetail;
import General.Maintainid;
import General.Pupil;
import General.RegularEmployee;
import General.plcldata;
	

	public class Newuser extends JFrame implements ActionListener
	{
		
		private JButton btnsubmit,btnrefresh;
		private JTextField txtusername,txtfirstname,txtmiddlename,txtlastname,txtdateofjoining,txtmobno,txtpassword,txtrepassword,txtbloodgroup,txtemail;
		private JLabel lbllevel,lblemployeeid,lblemployeeiddata,lblusername,lblfirstname,lblmiddlename,lbllastname,lbldateofjoining,lbldepartment,lbldesignation,lblmobno,lblpassword,lblrepassword,lblbloodgroup,lblAddress,lblemail;
		private Box boxemployeeid,boxlevel,boxgender,boxtype,boxnamelbl,boxfirstname,boxmiddlename,boxlastname,boxname,boxdet,boxdepdesiglabel,boxdepdesigtext,boxdojbldgrplabel,boxdojbldgrptext,boxaddress,boxmobile,boxuser,boxuserlabel,boxusertxt,boxbutton,boxinput;
		private JTextArea txtAddress;
		private JRadioButton rdusertype[],rdgender[];
		//private JPanel pnl;
		private ButtonGroup group,grpgender;
		private ArrayList<Employee> list;
		private ArrayList<Logindetail> listlogin;
		private TitledBorder title,titlegender;
		private JComboBox cmbdepartment,cmbdesignation,cmblevel;
		private String[] deptartment= {"select","HR","PUCHASE","ACCOUNTANT","ADMIN"};
		private String[] designation= {"select","SALES","TRAINER","SALES EXECTIVE","BUSSINESS HEAD"};
		private String[] level= {"select","JUNIOR","MIDDLE","SENOIR"};
		
		
		
	public Newuser()
	{		
		 btnsubmit=new JButton("SUBMIT");
		 btnrefresh=new JButton("REFRESH");
		 lblusername=new JLabel("Username");
		 lblemployeeid=new JLabel("Employee ID");
		 lbllevel=new JLabel("Level");
		  lblemployeeiddata=new JLabel("     "+Maintainid.getId());
		  //JOptionPane.showMessageDialog(btnsubmit," "+Maintainid.getId());
		 lblpassword=new JLabel("Password");
		 lblrepassword=new JLabel("Password");
		 txtusername= new JTextField(10);
		 txtpassword=new JTextField(10);
		 txtrepassword=new JTextField(10);
		 txtfirstname= new JTextField(10);
		 txtmiddlename= new JTextField(10);
		 txtlastname= new JTextField(10);
		 txtdateofjoining= new JTextField(10);
		 cmbdepartment= new JComboBox(deptartment);
		 cmbdesignation= new JComboBox(designation);
		 cmblevel=new JComboBox(level);
		 txtmobno= new JTextField(10);
		 txtbloodgroup= new JTextField(10);
		 txtAddress= new JTextArea(4,40);
		 txtemail= new JTextField(10);
		 lblfirstname=new JLabel("First Name");
		 lblmiddlename=new JLabel("Middle Name");
		 lbllastname=new JLabel("Last Name");
		 lbldateofjoining=new JLabel("Date Of Joining (dd/mm/yyyy)");
		 lbldepartment=new JLabel("Department");
		 lbldesignation=new JLabel("Designation");
		 lblmobno=new JLabel("Mob No");
		 lblpassword=new JLabel("Password");
		 lblrepassword=new JLabel("Re-Password");
		 lblbloodgroup=new JLabel("Bloodgroup");
		 lblAddress=new JLabel("Address");
		 lblemail=new JLabel("E-mail");
		 rdusertype=new JRadioButton[3];
		 rdusertype[0]=new JRadioButton("REGULAR EMPLOYEE");
		 rdusertype[1]=new JRadioButton("PUPIL");
		 rdusertype[2]=new JRadioButton("CONSULTANT");
		 rdgender=new JRadioButton[2];
		 rdgender[0]=new JRadioButton("MALE");
		 rdgender[1]=new JRadioButton("FEMALE");
		// pnl=new JPanel();
		 group = new ButtonGroup();
		 //grpgender=new ButtonGroup();
		 
		 
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
			boxlevel=Box.createHorizontalBox();
			//boxgender=Box.createHorizontalBox();
			
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
			
			
			
			 btnsubmit.setMaximumSize(btnrefresh.getMaximumSize());
			
			boxdepdesiglabel.add(lbldepartment);
			boxdepdesiglabel.add(lbldesignation);
			boxdepdesiglabel.add(lbllevel);
			boxdepdesigtext.add(cmbdepartment);
			boxdepdesigtext.add(cmbdesignation);
			boxdepdesigtext.add(cmblevel);
			
			boxdojbldgrplabel.add(lbldateofjoining);
			boxdojbldgrplabel.add(lblbloodgroup);
			boxdojbldgrptext.add(txtdateofjoining);
			boxdojbldgrptext.add(txtbloodgroup);
			
			
			//boxlevel.add(arg0)
			
			
			boxdet.add(boxdojbldgrplabel);
			boxdet.add(boxdojbldgrptext);
			boxdet.add(boxdepdesiglabel);
			boxdet.add(boxdepdesigtext);
			
			boxaddress.add(lblAddress);
			boxaddress.add(txtAddress);
			//boxaddress.setMaximumSize(new Dimension(300,700));
			
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
			
			group.add(rdusertype[0]);
			group.add(rdusertype[1]);
			group.add(rdusertype[2]);
			boxtype.add(rdusertype[0]);
			boxtype.add(rdusertype[1]);
			boxtype.add(rdusertype[2]);
			title = BorderFactory.createTitledBorder("Choose The User Type");
			boxtype.setBorder(title);
			
			/*grpgender.add(rdgender[0]);
			grpgender.add(rdgender[1]);
			boxgender.add(rdgender[0]);
			boxgender.add(rdgender[1]);
			titlegender = BorderFactory.createTitledBorder("select ");
			boxgender.setBorder(titlegender);*/
			
			
			
			
			
			boxinput.add(Box.createRigidArea(new Dimension(10,30)));
			boxinput.add(boxemployeeid);
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
			//boxinput.add(boxgender);
			//boxinput.add(Box.createRigidArea(new Dimension(17,10)));
			
			boxinput.setVisible(false);
			//boxinput.setMaximumSize(new Dimension(170,100));
			
			boxbutton.add(Box.createRigidArea(new Dimension(170,10)));
			boxbutton.add(btnsubmit);
			boxbutton.add(Box.createRigidArea(new Dimension(30,10)));
			boxbutton.add(btnrefresh);
			//boxbutton.add(Box.createRigidArea(new Dimension(170,10)));
			//add(frmtype,BorderLayout.SOUTH);
			
			
			add(boxtype,BorderLayout.NORTH);
			 add(boxbutton,BorderLayout.SOUTH);
			 add(boxinput,BorderLayout.CENTER);
				setSize(750,600);
				setVisible(true);
				setTitle("New User");
				setLocationRelativeTo(null);
				setResizable(false);
				
			 
			 btnsubmit.addActionListener(this);
			 btnrefresh.addActionListener(this);
			 rdusertype[0].addActionListener(this);
			 rdusertype[1].addActionListener(this);
			 rdusertype[2].addActionListener(this);
			 rdgender[0].addActionListener(this);
			 rdgender[1].addActionListener(this);
			 
	
	}
	public void refreshall()
	{
		
		txtusername.setText("");
		 txtpassword.setText("");
		 txtrepassword.setText("");
		 txtfirstname.setText("");
		 txtmiddlename.setText("");
		 txtlastname.setText("");
		 txtdateofjoining.setText("");
		 //cmbdepartment..setText("");
		// cmbdesignation.setText("");
		 txtmobno.setText("");
		 txtbloodgroup.setText("");
		 txtAddress.setText("");
		// txtemail.setText("");
	}
	public Employee adduser()
	{
		Employee ref = null;
		int employeeid=Maintainid.getId();
		String username=txtusername.getText().trim();
		String firstname=txtfirstname.getText().trim();
		String middlename=txtmiddlename.getText().trim();
		String lastname=txtlastname.getText().trim();
		String dateofjoining=txtdateofjoining.getText().trim();
		String department=(String)cmbdepartment.getSelectedItem();
		String designation=(String)cmbdesignation.getSelectedItem();
		String level=(String)cmblevel.getSelectedItem();
		String address=txtAddress.getText().trim();
		String mobno=txtmobno.getText().trim();
		String password=txtpassword.getText().trim();
		String bloodgroup=txtbloodgroup.getText().trim();
		String email=username;
		if(rdusertype[0].isSelected())
		{
			 ref = new RegularEmployee(employeeid,firstname, middlename, lastname, dateofjoining, department,
					designation,level,address, mobno, username, password, bloodgroup, email);
		}
		if(rdusertype[1].isSelected())
		{
			ref=new Pupil(employeeid,firstname, middlename, lastname, dateofjoining, department,
					designation,level,address, mobno, username, password, bloodgroup, email);
		}
		if(rdusertype[2].isSelected())
		{
			ref=new Consultant(employeeid,firstname, middlename, lastname, dateofjoining, department,
					designation,level,address, mobno, username, password, bloodgroup, email);
		}
		return ref;
	}
		
	public void blankcheck()
	{
		boolean check=false;
		boolean checkmsg = false;
		String usertype = null;
		int employeeid=Maintainid.getId();
		String username=txtusername.getText().trim();
		String firstname=txtfirstname.getText().trim();
		String address=txtAddress.getText().trim();
		String lastname=txtlastname.getText().trim();
		String dateofjoining=txtdateofjoining.getText().trim();
		String department=(String) cmbdepartment.getSelectedItem();
		String designation=(String) cmbdesignation.getSelectedItem();
		String level=(String)cmblevel.getSelectedItem();
		String mobno=txtmobno.getText().trim();
		String password=txtpassword.getText();
		String repassword=txtrepassword.getText();
		String bloodgroup=txtbloodgroup.getText().trim();
		
		
		if(Valid.isEmpty(address)==true)
		{
			txtAddress.setBackground(Color.RED);
			check=true;
		}
		else
			txtAddress.setBackground(Color.WHITE);
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
		
		
	if(rdusertype[0].isSelected())
	{
		if(department.equals("select"))
		{
			check=true;
			checkmsg=true;
			JOptionPane.showMessageDialog(this,"Select a Department");
		}
		else
			if(designation.equals("select"))
		{
				JOptionPane.showMessageDialog(this,"Select a Designation");
			check=true;
			checkmsg=true;
		}
		else
			if(level.equals("select"))
		{
				JOptionPane.showMessageDialog(this,"Select a Level");
			check=true;
			checkmsg=true;
		}
	}
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
			adddata();
		}
			
	}
		
	public void adddata()
	{
		String usertype=null;
		list=new ArrayList<Employee>();	
		if(rdusertype[0].isSelected())
		{
			usertype="REGULAR EMPLOYEE";	
			//list=new ArrayList<Employee>();			
			try
			{
				list=FileReadWriteRegularEmployeedetail.readingFromRegularEmployeedetail();
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this,"File not found");
				
			}
		
		
			list.add(adduser());
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
		
		if(rdusertype[1].isSelected())
		{
			usertype="PUPIL";
		
			try
			{
				list=FileReadWritePupil.readingFromPupildetail();
				
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
			}
			list.add(adduser());
			try
			{
				FileReadWritePupil.writingToPupildetail(list);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
			}
		}
		
		if(rdusertype[2].isSelected())
		{
			usertype="CONSULTANT";
			try
			{
				list=FileReadWriteConsultantdetail.readingFromConsultantdetail();
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
				e.printStackTrace();
			}
			list.add(adduser());
			try
			{
				FileReadWriteConsultantdetail.writingToConsultantdetail(list);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(lblemployeeiddata,"File not found");
				e.printStackTrace();
			}
		}
		
		ArrayList<Logindetail> listlogin;
		int employeeid=Maintainid.getId();
		String username=(txtusername.getText()).trim();
		String password=(txtpassword.getText()).trim();
		
		Logindetail det=new Logindetail(employeeid,username,password,usertype,"NO");
			
			listlogin=new ArrayList<Logindetail>();
			
			try {
				listlogin=FileReadWritelogindetail.readingFromUserDetailsDB();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(btnsubmit,"File not found");
			}
			
			listlogin.add(det);
			try {
				FileReadWritelogindetail.writingToUserDetailsDB(listlogin);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(btnsubmit,"File not found");
			}
			
			//PLCLdb
			if(rdusertype[0].isSelected())
			{
				
				String name=txtfirstname.getText().trim()+" "+txtmiddlename.getText().trim()+" "+txtlastname.getText().trim();
				String address=txtAddress.getText().trim();
				String dateofjoining=txtdateofjoining.getText().trim();
				String department=(String)cmbdepartment.getSelectedItem();
				String designation=(String)cmbdesignation.getSelectedItem();		
				String level=(String)cmblevel.getSelectedItem();
				//public plcldata(int employeeid, String name, String department,String designation, String level, String doj, int pl, int cl)
				plcldata plclobj=new plcldata(employeeid,name,department,designation,level,dateofjoining,0,0,0);
				
			ArrayList<plcldata>	listplcl=new ArrayList<plcldata>();
				
				try {
					listplcl=FileReadWritePLCLdetail.readingFromPLCLdetail();
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(btnsubmit,"File not found");
				}
				
				listplcl.add(plclobj);
				try {
					
					FileReadWritePLCLdetail.writingToPLCLdetail(listplcl);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(btnsubmit,"File not found");
				}
			}
			
			refreshall();
			JOptionPane.showMessageDialog(btnsubmit,"User id :- "+(Maintainid.getId()-1)+"  is registered successfully as "+usertype);
			lblemployeeiddata.setText("  "+Maintainid.getId());
	
	}
		
	
	
	public void actionPerformed(ActionEvent event)
	{
		
		
		if(rdusertype[0].isSelected())
		{
			cmbdepartment.setEnabled(true);
			cmbdesignation.setEnabled(true);
			cmblevel.setEnabled(true);
			
			cmbdepartment.setBackground(Color.WHITE);
			cmbdesignation.setBackground(Color.WHITE);
			boxinput.setVisible(true);
		}
		if(rdusertype[1].isSelected())
		{
			cmbdepartment.setEnabled(false);
			cmbdesignation.setEnabled(false);
			cmblevel.setEnabled(false);
			cmbdepartment.setBackground(Color.LIGHT_GRAY);
			cmbdesignation.setBackground(Color.LIGHT_GRAY);
			boxinput.setVisible(true);
		}
		if(rdusertype[2].isSelected())
		{
			cmbdepartment.setEnabled(false);
			cmbdesignation.setEnabled(false);
			cmbdepartment.setBackground(Color.LIGHT_GRAY);
			cmbdesignation.setBackground(Color.LIGHT_GRAY);
			boxinput.setVisible(true);
		}
		if(event.getSource()==btnsubmit)
		{
			blankcheck();
			
		}
		if(event.getSource()==btnrefresh)
		{
		refreshall();
		}
		
	}
	public static void main(String[] args) 
	{
		new Newuser();
	}
	}


