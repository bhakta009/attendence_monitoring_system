package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Box;

import Database.FileReadWritelogindetail;
import General.Logindetail;

public class Login extends JFrame implements ActionListener
{
	private JButton btnlogin,btnreset;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	private JLabel lblusername,lblpassword,lblheading;
	private Box boxheading,boxlogin,boxpassword,boxbutton,boxinput;
	private ArrayList<Logindetail> listlogin;
	private static int userid;
	
	
	
 Login()
{
	 listlogin=new ArrayList<Logindetail>();
		
		try
		{
			listlogin=FileReadWritelogindetail.readingFromUserDetailsDB();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(btnlogin,"File not found");
			
		}
		lblheading=new JLabel("WELCOME TO GLOBSYN TECHNOLOGIES LIMITED");
		lblheading.setFont(new Font("",Font.ITALIC,20) );
		lblheading.setBackground(Color.RED);
	 btnlogin=new JButton("LOGIN");
	 btnreset=new JButton("RESET");
	 lblusername=new JLabel("Username");
	 lblpassword=new JLabel("Password");
	 txtusername=new JTextField(10);
	 txtpassword=new JPasswordField(10);
	 boxheading=Box.createHorizontalBox();
	 boxheading.setMaximumSize(new Dimension(300,30));
	 boxlogin=Box.createHorizontalBox();
	 boxlogin.setMaximumSize(new Dimension(300,30));
	 boxpassword=Box.createHorizontalBox();
	 boxpassword.setMaximumSize(new Dimension(300,30));
	 boxbutton=Box.createHorizontalBox();
	 boxinput=Box.createVerticalBox();
	//boxlogin
	 boxheading.add(lblheading);
	 boxlogin.add(lblusername);
	 boxlogin.add(Box.createRigidArea(new Dimension(50,10)));
	 boxlogin.add(txtusername);
	 //boxlogin
	 add(Box.createRigidArea(new Dimension(60,90)));
	 boxpassword.add(lblpassword);
	 boxpassword.add(Box.createRigidArea(new Dimension(50,10)));
	 boxpassword.add(txtpassword);
	 boxbutton.add(Box.createRigidArea(new Dimension(170,10)));
	 boxbutton.add(btnlogin);
	 boxbutton.add(Box.createRigidArea(new Dimension(20,10)));
	 boxbutton.add(btnreset);
	 boxheading.add(lblheading);
	 boxheading.add(Box.createRigidArea(new Dimension(20,10)));
	 boxinput.add(Box.createRigidArea(new Dimension(50,40)));
	 boxinput.add(boxlogin);
	 boxinput.add(Box.createRigidArea(new Dimension(50,10)));
	 boxinput.add(boxpassword);
	 add(boxbutton,BorderLayout.SOUTH);
	 add(boxinput,BorderLayout.CENTER);
	 add(boxheading,BorderLayout.NORTH);
		setSize(500,235);
		setVisible(true);
		setTitle("Login Form");
		setLocationRelativeTo(null);
		setResizable(false);
	 btnlogin.addActionListener(this);
	 btnreset.addActionListener(this);
	 
	
	
}
 public void logincheck()
 {
	 InOut ref;
	String username= txtusername.getText().trim();
	String password= txtpassword.getText();
	boolean check=false;
	 for(int index=0;index<listlogin.size();index++)
		{
			Logindetail detail=listlogin.get(index);
			if(detail.getUsername().equals(username))
			{
				if(detail.getPassword().equals(password))
				{
					userid=detail.getEmployeeid();
					if(detail.getAdmin().equalsIgnoreCase("YES"))
					{
						ref=new InOut();
						ref.visible(true);
					}
					else
					{
						ref=new InOut();
						ref.visible(false);
					}
					
					
					
					check=true;
					
				}
			}
		
		}
			if(check==false) 
				JOptionPane.showMessageDialog(btnlogin,"USERNAME/PASSWORD IS INCORRECT");
		
 }
 
public static int getUserid() {
	return userid;
}
public void actionPerformed(ActionEvent event)
{
	if (event.getSource()==btnlogin)
	 logincheck();
	resetAll();
}
public void resetAll(){
	txtusername.setText("");
	txtpassword.setText("");
}
public static void main(String[] args) 
{
	new Login();
}
}
