package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Validate.Valid;

import Database.FileReadWritePLCLdetail;
import General.plcldata;

public class Leavestatus extends JFrame implements ActionListener
{
	private static final String String = null;
	private JButton btncheck,btnshowrequest;
	private JTextField txtemployeeid,txtdateapplied;
	private JLabel lblemployeeid,lbldateapplied,lblcl,lblcldata,lblpl,lblpldata;
	private Box boxlabel,boxtext,boxcl,boxpl,boxbutton,boxinput,boxleavetype,boxdetail,boxdate;
	//private JTextArea txt;
	//private JRadioButton ;
	private JComboBox cmbday,cmbmonth,cmbyear;
	private String[] month= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private ArrayList<plcldata> list;
	private int id;
	
	public Leavestatus()
	{
		
		
		btncheck=new JButton("CHECK");
		btnshowrequest=new JButton("SHOW REQUEST");
		
		txtemployeeid=new JTextField(10);
		txtdateapplied=new JTextField(10);
		
		lblemployeeid=new JLabel("Employee ID");
		lbldateapplied=new JLabel("Date Applied");	 
		lblcl=new JLabel("Availabe CL");
		lblcldata=new JLabel("--");
		lblpl=new JLabel("Availabe PL");
		lblpldata=new JLabel("--");
		
		String datevalue[]=new String[32];
        //datevalue[0]="";
		for(int i=0;i<=30;i++)
		{
			datevalue[i]=String.valueOf(i+1);
		}
		cmbday=new JComboBox(datevalue);
		cmbmonth=new JComboBox(month);
		String yearvalue[]=new String[51];
		//yearvalue[0]="";
		int cnt=0;
		for(int i=2013;i>=1970;i--)
		{
			yearvalue[cnt]=String.valueOf(i);
			cnt++;	
		}
		cmbyear=new JComboBox(yearvalue);
		
		boxlabel=Box.createVerticalBox();
		boxtext=Box.createVerticalBox();
		boxcl=Box.createVerticalBox();
		boxpl=Box.createVerticalBox();
		boxbutton=Box.createHorizontalBox();
		boxinput=Box.createVerticalBox();
		boxleavetype=Box.createHorizontalBox();
		boxdetail=Box.createHorizontalBox();
		boxdate=Box.createHorizontalBox();
		
		boxdate.add(cmbday);
		boxdate.add(cmbmonth);
		boxdate.add(cmbyear);
		
		boxlabel.add(Box.createRigidArea(new Dimension(50,30)));
		boxlabel.add(lblemployeeid);
		boxlabel.add(Box.createRigidArea(new Dimension(0,25)));
		boxlabel.add(lbldateapplied);
		boxtext.add(Box.createRigidArea(new Dimension(50,30)));
		boxtext.add(txtemployeeid);
		boxtext.add(Box.createRigidArea(new Dimension(50,10)));
		boxtext.add(boxdate);
		
		boxcl.add(lblcl);			
		boxcl.add(lblcldata);
		boxpl.add(lblpl);
		boxpl.add(lblpldata);
		boxbutton.add(Box.createRigidArea(new Dimension(30,40)));
		boxbutton.add(btncheck);
		boxbutton.add(Box.createRigidArea(new Dimension(30,40)));
		boxbutton.add(btnshowrequest);
		boxleavetype.add(Box.createRigidArea(new Dimension(40,90)));
		boxleavetype.add(boxcl);
		boxleavetype.add(Box.createRigidArea(new Dimension(90,90)));
		boxleavetype.add(boxpl);
		boxdetail.add(boxlabel);
		boxdetail.add(boxtext);
		
		
		boxinput.add(boxdetail);
		boxinput.add(Box.createRigidArea(new Dimension(90,40)));
		boxinput.add(boxleavetype);
		boxleavetype.setMaximumSize(new Dimension(300,30));
		boxdetail.setMaximumSize(new Dimension(300,110));
		btncheck.setMaximumSize(btnshowrequest.getMaximumSize());
		
			
			//add(frmtype,BorderLayout.SOUTH);
			 add(boxbutton,BorderLayout.SOUTH);
			 add(boxinput,BorderLayout.CENTER);
				setSize(350,400);
				setVisible(true);
				setTitle("Leave Status");
				setLocationRelativeTo(null);
				setResizable(false);
				
			 
				btncheck.addActionListener(this);
				btnshowrequest.addActionListener(this);
		
	}
	
	public void getdata()
	{
		
		
		list=new ArrayList<plcldata>();
		try {
			list=FileReadWritePLCLdetail.readingFromPLCLdetail();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this,"File not found");
		}
		
		if(Valid.isEmpty(txtemployeeid.getText().trim())==false)
		{
			id=Integer.parseInt(txtemployeeid.getText().trim());
			for(int index=0;index<list.size();index++)
			{
				plcldata detail=list.get(index);
				if(detail.getEmployeeid()==id)
	        	{
	        	lblpldata.setText(Integer.toString(detail.getPl()));
	        	lblcldata.setText(Integer.toString(detail.getCl()));
	        	}
			
			}
		}
		
	}
	public void senddata()
	{
		 
		String day=(String) cmbday.getSelectedItem();
		String month=(String) cmbmonth.getSelectedItem();
		String year=(String)cmbyear.getSelectedItem();
		String date=day+" "+month+", "+year;
		new Leavedecision(id,date);
		//JOptionPane.showMessageDialog(this,date);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource()==btnshowrequest)
		{
			getdata();
			senddata();
		}
		
		if (event.getSource()==btncheck)
		getdata();
	}
	public static void main(String[] args) 
	{
		new Leavestatus();
	}
	}

