package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Adminpage extends JFrame implements ActionListener
{
	private JButton btnnewuser,btndeluser,btnoutduty,btnleaverequest,btnreports,btnedituser;
	private Box boxrow1,boxrow2,boxbutton;
public Adminpage()
{
	btnleaverequest=new JButton("Leave Request");
	btnnewuser = new JButton("New User");
	btnnewuser.setMaximumSize(btnleaverequest.getMaximumSize());
	btnedituser = new JButton("Edit User");
	btnedituser.setMaximumSize(btnleaverequest.getMaximumSize());
	btndeluser=new JButton("Delete User");
	btndeluser.setMaximumSize(btnleaverequest.getMaximumSize());
	btnoutduty=new JButton("Out Duty");
	btnoutduty.setMaximumSize(btnleaverequest.getMaximumSize());
	
	//btnleaverequest.setMaximumSize();
	btnreports=new JButton("Reports");
	btnreports.setMaximumSize(btnleaverequest.getMaximumSize());
	
	boxrow1=Box.createHorizontalBox();
	boxrow2=Box.createHorizontalBox();
	boxbutton=Box.createVerticalBox();
	
	btnnewuser.addActionListener(this);
	btnedituser.addActionListener(this);
	btndeluser.addActionListener(this);
	btnoutduty.addActionListener(this);
	btnleaverequest.addActionListener(this);
	btnreports.addActionListener(this);
	
	boxrow1.add(btnnewuser);
	boxrow1.add(Box.createRigidArea(new Dimension(25, 35)));
	boxrow1.add(btnedituser);
	boxrow1.add(Box.createRigidArea(new Dimension(25, 35)));
	boxrow1.add(btndeluser);
	
	boxrow2.add(btnoutduty);
	boxrow2.add(Box.createRigidArea(new Dimension(25, 35)));
	boxrow2.add(btnleaverequest);
	boxrow2.add(Box.createRigidArea(new Dimension(25, 35)));
	boxrow2.add(btnreports);
	boxbutton.add(Box.createRigidArea(new Dimension(25, 35)));
	boxbutton.add(boxrow1);
	boxbutton.add(Box.createRigidArea(new Dimension(25, 15)));
	boxbutton.add(boxrow2);
	
	add(boxbutton,BorderLayout.CENTER);
		setSize(500,200);
		setVisible(true);
		setTitle("ADMIN PAGE");
		setLocationRelativeTo(null);
}
public void actionPerformed(ActionEvent event)
  {
		if (event.getSource()==btnnewuser)
			new Newuser();
		if (event.getSource()==btnedituser)
			new Edituserloginpage();
		if (event.getSource()==btnleaverequest)
			new Leavestatus();
		if (event.getSource()==btnoutduty)
			new OutDutyGui();
		if (event.getSource()==btndeluser)
			new Deleteuser();
		if (event.getSource()==btnreports)
			new ReportGUI();
  }
	
	

public static void main(String[] args) 
{
	new Adminpage();
}
}
