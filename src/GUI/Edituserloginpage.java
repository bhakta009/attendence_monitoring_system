package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Database.FileReadWritelogindetail;
import General.Logindetail;

public class Edituserloginpage extends JFrame implements ActionListener{
	private JButton btnproceed,btncancel;
	private static JTextField txtuserid;
	private JLabel lbluserid;
	private Box boxlogin,boxbutton,boxinput;
	private ArrayList<Logindetail> listlogin;
	
	
	
	public static int getuserid() {
		return Integer.parseInt(txtuserid.getText());
	}
	public void setTxtuserid(JTextField txtuserid) {
		this.txtuserid = txtuserid;
	}
	Edituserloginpage()
{
		
	 btnproceed=new JButton("PROCEED");
	 btncancel=new JButton("CANCEL");
	 lbluserid=new JLabel("User ID");
	 txtuserid=new JTextField(10);
	 
	 boxlogin=Box.createHorizontalBox();
	 boxlogin.setMaximumSize(new Dimension(300,30));
	 boxbutton=Box.createHorizontalBox();
	 boxinput=Box.createVerticalBox();
	//boxlogin
	 boxlogin.add(lbluserid);
	 boxlogin.add(Box.createRigidArea(new Dimension(50,10)));
	 boxlogin.add(txtuserid);
	 //boxlogin
	 boxbutton.add(Box.createRigidArea(new Dimension(170,10)));
	 boxbutton.add(btnproceed);
	 boxbutton.add(Box.createRigidArea(new Dimension(20,10)));
	 boxbutton.add(btncancel);
	 boxinput.add(Box.createRigidArea(new Dimension(50,40)));
	 boxinput.add(boxlogin);
	 add(boxbutton,BorderLayout.SOUTH);
	 add(boxinput,BorderLayout.CENTER);
		setSize(450,200);
		setVisible(true);
		setTitle("Login Form");
		setLocationRelativeTo(null);
		
	 
	 btnproceed.addActionListener(this);
	 btncancel.addActionListener(this);
	 
	
	
}
public void check()
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
	boolean check = false;
	for(int index=0;index<listlogin.size();index++)
	{
		Logindetail detail=listlogin.get(index);
		if(getuserid()==detail.getEmployeeid())
		{
			new Edituserdetails();
			check=true;
		}
	}
		if(check==false)
			JOptionPane.showMessageDialog(this,"User does not Exist");
	
}
	
public void actionPerformed(ActionEvent event)
{
	if (event.getSource()==btnproceed)
			check();
}

	
	public static void main(String[] args) {
		new Edituserloginpage();

	}

}
