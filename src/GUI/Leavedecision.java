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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Validate.Valid;

import Database.FileReadWriteLeaveRequest;
import Database.FileReadWritePLCLdetail;
import General.DaysDifference;
import General.RequestedLeave;
import General.plcldata;

public class Leavedecision extends JFrame implements ActionListener
{
	private JLabel lblid,lblname,lbldepartment,lbldesignation,lblleavetype,lbldays,lblto,lblfrom,lbldateapplied,lbllevel;
    private Box boxremark,boxbutton,boxinput,boxlabel,boxtext,boxdate,boxdateapplied,boxappliedddate,boxcentre;
	private JLabel lblremark,lbldaysdata,lbltodata,lblfromdata,lbliddata,lblnamedata,lbldepartmentdata,lbldesignationdata,lblleavetypedata,lblleveldata,lbldateapplieddata;
	private JButton btnapply,btncancel,btnrefresh,btnapprove,btnreject;
	private JPanel panelbutton;
	private JTextArea txtremark;
	private ArrayList<RequestedLeave> list;
	private int location,id;
	
 public Leavedecision(int id,String date)
 {
	 this.id=id;
	 list=new ArrayList<RequestedLeave>();
		try
		{
			list=FileReadWriteLeaveRequest.readingFromLeaveRequest();
	
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(this,"File not found");
		}
	 btnapprove=new JButton("APPROVE");
	 btnreject=new JButton("REJECT");
	 boxbutton=Box.createHorizontalBox();
	 boxlabel=Box.createVerticalBox();
	 boxtext=Box.createVerticalBox();
	 boxdate=Box.createHorizontalBox();
	 boxremark=Box.createHorizontalBox();
	 
	 //begin
	 	lblid=new JLabel("EMP ID");
		lblname=new JLabel("NAME");
		lbldepartment=new JLabel("DEPARTMENT");
		lbldesignation=new JLabel("DESIGNATION");
		lbllevel=new JLabel("LEVEL");
		lbldateapplied=new JLabel("DATE APPLIED");
		lblleavetype=new JLabel("TYPE OF LEAVE");
		lbldays=new JLabel("No.of.Days");
		lblto=new JLabel("To");
		lblfrom=new JLabel("From");
		lblremark=new JLabel("Remark");
		txtremark=new JTextArea(2,10);
		
		
		 lbliddata= new JLabel("----");
		 lblnamedata= new JLabel("----");
		 lbldepartmentdata= new JLabel("----");
		 lblleavetypedata= new JLabel("----");
		 lbldaysdata= new JLabel("----");
		 lbltodata= new JLabel("----");
		 lblfromdata= new JLabel("----");
		 lblleveldata= new JLabel("----");
		 lbldateapplieddata= new JLabel("----");
		 lbldesignationdata=new JLabel("----");
		
		
		boxlabel.add(Box.createRigidArea(new Dimension(10, 50)));
		boxlabel.add(lblid);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lblname);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbldepartment);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbldesignation);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbllevel);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbldateapplied);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lblleavetype);
		boxlabel.add(Box.createRigidArea(new Dimension(10, 10)));
		boxlabel.add(lbldays);
		
		
		boxtext.add(Box.createRigidArea(new Dimension(10, 50)));
		boxtext.add(lbliddata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lblnamedata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lbldepartmentdata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lbldesignationdata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lblleveldata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lbldateapplieddata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lblleavetypedata);
		boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
		boxtext.add(lbldaysdata);
		
		boxdate.add(lblto);
		boxdate.add(Box.createRigidArea(new Dimension(10, 20)));
		boxdate.add(lbltodata);
		boxdate.add(Box.createRigidArea(new Dimension(30, 20)));
		boxdate.add(lblfrom);
		boxdate.add(Box.createRigidArea(new Dimension(10, 20)));
		boxdate.add(lblfromdata);
		
		boxremark.add(lblremark);
		boxremark.add(Box.createRigidArea(new Dimension(10, 20)));
		boxremark.add(txtremark);
		
		
		boxlabel.setMaximumSize(new Dimension(150,270));
		boxtext.setMaximumSize(new Dimension(150,270));
		boxdate.setMaximumSize(new Dimension(280,20));
		boxremark.setMaximumSize(new Dimension(280,100));
		
		boxinput=Box.createHorizontalBox();
		boxinput.add(boxlabel);
		boxinput.add(boxtext);
		
		
		
		boxcentre=Box.createVerticalBox();
		boxcentre.add(boxinput);
		boxcentre.add(boxdate);
		boxcentre.add(Box.createRigidArea(new Dimension(10, 30)));
		boxcentre.add(boxremark);
	
	 boxbutton.add(btnapprove);
	 boxbutton.add(btnreject);
	 add(boxcentre,BorderLayout.CENTER);
	 add(boxbutton,BorderLayout.SOUTH);
	  setSize(350,500);
	  setVisible(true);
	  setTitle("Leave Request Decision");
	  setLocationRelativeTo(null);
		setResizable(false);
	 btnapprove.addActionListener(this);
	 btnreject.addActionListener(this);
	 
	 getdata(id,date);
	
 }
 public void getdata(int userid,String date)
 {
	 boolean check=false;
	 
		
		
		for(int index=0;index<list.size();index++)
		{
			RequestedLeave detail=list.get(index);
		
			
			if(userid==detail.getEmployeeid())
			{
				if(date.equals(detail.getApplieddate()))
				{  
					if(detail.getStatus().equals("PENDING"))
					{
						check=true;
						location=index;
			
					}
					else
						JOptionPane.showMessageDialog(this,"no new request");
				}
										
			}
		}
		if(check==true)
		{
			RequestedLeave detail=list.get(location);
			lbliddata.setText(Integer.toString(detail.getEmployeeid()));
			 lblnamedata.setText(detail.getName());
			 lbldepartmentdata.setText(detail.getDepartment());
			 lblleavetypedata.setText(detail.getTypeofleave());
			 lbldaysdata.setText(Integer.toString(detail.getNoofdays()));
			 lbltodata.setText(detail.getDateto());
			 lblfromdata.setText(detail.getDatefrom());
			 lblleveldata.setText(detail.getLevel());
			 lbldateapplieddata.setText(detail.getApplieddate());
			 lbldesignationdata.setText(detail.getDesignation());
		}
 }
 public boolean update()
 {
	 boolean check = true;
	 RequestedLeave leave=list.get(location);
	 ArrayList<plcldata> listplcl=new ArrayList<plcldata>();
		try {
			listplcl=FileReadWritePLCLdetail.readingFromPLCLdetail();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(btnapply,"File not found");
		}
 
	 for(int index=0;index<listplcl.size();index++)
     {
			plcldata detail=listplcl.get(index);
 		//JOptionPane.showMessageDialog(lblemployeeiddata,""+employee.getEmployeeid()+"...."+detail.getEmployeeid());

     	if(id==detail.getEmployeeid())
     	{
     		
			//JOptionPane.showMessageDialog(lblemployeeiddata,""+date+"...."+detail.getDate());
     		if(leave.getTypeofleave().equals("PL"))
     			if((detail.getPl()-leave.getNoofdays())>=0)
     					detail.setPl(detail.getPl()-leave.getNoofdays());
     			else
     				check=false;
     		if(leave.getTypeofleave().equals("CL"))
     			if((detail.getCl()-leave.getNoofdays())>=0)
     					detail.setCl(detail.getCl()-leave.getNoofdays());
     			else
     				check=false;
     	}
     }
     	
 			try
 	        {
 				FileReadWritePLCLdetail.writingToPLCLdetail(listplcl);
 			
 	        	
 	        }
 	        catch(Exception exp)
 	        {
 	        	JOptionPane.showMessageDialog(btnapply,"File not found");
 	        }
			return check;
 }
 
  public void actionPerformed(ActionEvent event)
	{
		if (event.getSource()==btnapprove)
		{
			if(Valid.isEmpty(txtremark.getText().trim())==false)
			{
				boolean check=update();
				if(check==true)
				{
					RequestedLeave detail=list.get(location);
					detail.setStatus("APPROVED");
					JOptionPane.showMessageDialog(this,"appoved");
				}
				else
					JOptionPane.showMessageDialog(this,"Days greater than available");
			}
			else
				JOptionPane.showMessageDialog(this,"please add Remark");
 			try
 	        {
 				FileReadWriteLeaveRequest.writingToLeaveRequest(list);
 			
 	        	
 	        }
 	        catch(Exception exp)
 	        {
 	        	JOptionPane.showMessageDialog(btnapply,"File not found");
 	        }
			
			
			
		}
			
		if (event.getSource()==btnreject)
		{
			if(Valid.isEmpty(txtremark.getText().trim())==false)
			{
				RequestedLeave detail=list.get(location);
				detail.setStatus("REJECTED");
				JOptionPane.showMessageDialog(this,"Rejected");
			}
			else
				JOptionPane.showMessageDialog(this,"please add Remark");
			
			try
 	        {
 				FileReadWriteLeaveRequest.writingToLeaveRequest(list);
 			
 	        	
 	        }
 	        catch(Exception exp)
 	        {
 	        	JOptionPane.showMessageDialog(btnapply,"File not found");
 	        }
			
		}
		
		
	}
	public static void main(String[] args) 
	{
		new Leavedecision(1,"d");
	}
}
