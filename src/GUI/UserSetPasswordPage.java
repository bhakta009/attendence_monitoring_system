package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Database.FileReadWriteConsultantdetail;
import Database.FileReadWritePupil;
import Database.FileReadWriteRegularEmployeedetail;
import Database.FileReadWritelogindetail;
import Validate.Valid;
import ViewDB.ViewRegularEmployeeDetails;
import ViewDB.ViewUserDetails;

import General.Consultant;
import General.Employee;
import General.Pupil;
import General.RegularEmployee;
import General.Logindetail;


public class UserSetPasswordPage extends JFrame implements ActionListener {
	
	private JButton btnsubmit,btnexit;
	private JPasswordField password,reenterpassword,currentpassword;
    private JLabel lblconfirmpassword,lblpassword,lblheading,lblicon,lblcurrentpassword;
    private JPanel panel1,panelicon;
    private Font lblfont;
	private ArrayList<Logindetail> listlogin;
	private ArrayList<Employee> list;
   
    private static String empid;
    
	public  UserSetPasswordPage() 
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

	
	lblfont=new Font("Tahoma",1, 14);
	panel1=new JPanel();
	panelicon=new JPanel();
	lblicon=new JLabel();
	lblicon.setIcon(new ImageIcon());
	panelicon.add(lblicon);
	add(panelicon);
	lblheading=new JLabel("                              RESET PASSWORD                         ");
	lblheading.setFont(new Font("",8,20));
	lblheading.setForeground(Color.ORANGE);
	add(lblheading);
	
	setLayout(new FlowLayout());
	
	lblcurrentpassword=new JLabel("ENTER current PASSWORD:     ");
	lblcurrentpassword.setFont(lblfont);
	lblcurrentpassword.setForeground(new Color(154, 200, 3));
	add(lblcurrentpassword);
	//
	currentpassword=new JPasswordField(15);
	//currentpassword.setEchoChar('*');
	add(currentpassword);
	
	lblpassword=new JLabel("           ENTER NEW PASSWORD:  ");
	lblpassword.setFont(lblfont);
	lblpassword.setForeground(new Color(102, 0,0));
	add(lblpassword);
	//
	
	//
	
	password=new JPasswordField(15);
	//password.setEchoChar('*');
	add(password);
	//
	lblconfirmpassword=new JLabel("REENTER PASSWORD:      ");
	lblconfirmpassword.setFont(lblfont);
	lblconfirmpassword.setForeground(new Color(102, 0,0));
	add(lblconfirmpassword);
	
	//
	reenterpassword=new JPasswordField(15);
	//reenterpassword.setEchoChar('*');
	add(reenterpassword);
	//
	
	btnsubmit=new JButton("Submit");
	btnsubmit.setToolTipText("Click to save  ");
	panel1.add(btnsubmit);
	//
	btnexit=new JButton("Exit");
	btnexit.setToolTipText("Click to exit");
	panel1.add(btnexit);
	//
	 add(panel1,new BorderLayout().SOUTH);
	 //
	btnsubmit.addActionListener(this);
	btnexit.addActionListener(this);
	
	 //
	 setVisible(true);
	 setSize(480,530);
	 setResizable(false);
	 setTitle("User Reset password page");
		setLocationRelativeTo(null);
	 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}	
			
	
	


public void getlocation()
{
	list=new ArrayList<Employee>();
	for(int index=0;index<listlogin.size();index++)
	{
		Logindetail detail=listlogin.get(index);
		if(Login.getUserid()==detail.getEmployeeid())
		{
			//JOptionPane.showMessageDialog(lblemployeeiddata,""+detail.getUsertype());
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
			
			if ((detail.getUsertype()).equalsIgnoreCase("PUPIL"))
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
				if ((detail.getUsertype()).equalsIgnoreCase("CONSULTANT"))
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
}

public boolean check()
{
	boolean check=true;
	if(Valid.isEmpty(currentpassword.getText())==false)
	{
	if(password.getText().equals(reenterpassword.getText())==false||Valid.isEmpty(password.getText())==true)
	{
		password.setBackground(Color.RED);
		reenterpassword.setBackground(Color.RED);
		check=false;
		//checkmsg=true;
		JOptionPane.showMessageDialog(this,"password not matching or empty");
	}
	
	else	
	{
	password.setBackground(Color.WHITE);
	reenterpassword.setBackground(Color.WHITE);
	}
	}
	else
		JOptionPane.showMessageDialog(this,"Current Password field empty");
	
	return check;
}

public void setdata()
{
	getlocation();
	 boolean check=false;
	for(int index=0;index<list.size();index++)
	{
	Employee employee=list.get(index);
	if(Login.getUserid()==employee.getEmployeeid())
	{
		
			if(currentpassword.getText().equals(employee.getPassword()))
			{
				check=true;
				String passworddata=password.getText();
				employee.setPassword(passworddata);
			}
			else
				JOptionPane.showMessageDialog(this,"Current password not correct");
		}
	
	
	if(check==true)
	{
		if ((employee.getUsertype()).equalsIgnoreCase("REGULAR EMPLOYEE"))
		{
		
				try
			{
				FileReadWriteRegularEmployeedetail.writingToRegularEmployeedetail(list);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this,"File not found");
				
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
				JOptionPane.showMessageDialog(this,"File not found");
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
				JOptionPane.showMessageDialog(this,"File not found");
			}
		}
	}
	}
	if(check==true)
	{
	
	for(int index1=0;index1<list.size();index1++)
	{
		Logindetail detail=listlogin.get(index1);
		if(Login.getUserid()==detail.getEmployeeid())
		{
			String passworddata=password.getText();
			detail.setPassword(passworddata);
			
		}
	
	try
	{
		FileReadWritelogindetail.writingToUserDetailsDB(listlogin);
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(this,"File not found");
	}
	
	}
	
	JOptionPane.showMessageDialog(this,"password changed successfully");
	}
}
	
public void actionPerformed(ActionEvent event) 
{
	if(event.getSource()==btnsubmit) 
	{
		if(check()==true)
		{
			setdata();
		}
	}
			
	if(event.getSource()==btnexit)
	{
			dispose();
	}
}
		
		
		
public static void main(String[] args) {
	//new UserSetPasswordPage().setVisible(true);
new	UserSetPasswordPage();
}

}
