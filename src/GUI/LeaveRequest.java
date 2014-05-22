package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Validate.Valid;

import Database.AttendanceStorge;
import Database.FileReadWriteLeaveRequest;
import Database.FileReadWriteOutDuty;
import Database.FileReadWritePLCLdetail;
import General.Attendance;
import General.DaysDifference;
import General.Fetch;
import General.Maintainid;
import General.Outduty;
import General.RequestedLeave;
import General.plcldata;

	public class LeaveRequest extends JFrame implements ActionListener
	{	private JLabel lblid,lblname,lbldepartment,lbldesignation,lblleavetype,lbldays,lblto,lblfrom,lbldateapplied,lbllevel;
    	private Box boxbutton,boxinput,boxlabel,boxtext,boxdate,boxdateapplied,boxappliedddate,boxcentre;
    	private JLabel lbliddata,lblnamedata,lbldepartmentdata,lbldesignationdata,lblleveldata,lbldateapplieddata;
    	private JButton btnapply,btncancel,btnrefresh,btnapprove,btnreject;
    	//private JPanel panelbutton;
		private JPanel panelbutton,panelinput;
		private JTextField txtaddress,txtdays,txtto,txtfrom;
		private JComboBox cmbleavetype;
		private String[] leavetype= {"select","PL","CL"};
		ArrayList<RequestedLeave> list;
		
		public LeaveRequest()  
		{   list=new ArrayList<RequestedLeave>();
			try
			{
				list=FileReadWriteLeaveRequest.readingFromLeaveRequest();
		
			}
			catch(Exception exp)
			{
				JOptionPane.showMessageDialog(btnapply,"File not found");
			}
			boxbutton=Box.createHorizontalBox();
			 boxlabel=Box.createVerticalBox();
			 boxtext=Box.createVerticalBox();
			 boxdate=Box.createHorizontalBox();
			 
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
				
				 lbliddata= new JLabel("----");
				 lblnamedata= new JLabel("----");
				 lbldepartmentdata= new JLabel("----");
				 
				 cmbleavetype= new JComboBox(leavetype);
				 txtdays= new JTextField(2);
				 txtdays.setText("1");
				 txtdays.setMaximumSize(new Dimension(50, 25));
				 txtto= new JTextField(10);
				 txtfrom= new JTextField(10);
				 lblleveldata= new JLabel("----");
				 lbldateapplieddata= new JLabel("----");
				 lbldesignationdata=new JLabel("----");
				 
				 btnapply=new JButton("APPLY");
					btncancel=new JButton("CANCEL");
					btnrefresh=new JButton("REFRESH");

				 
				
				
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
				boxtext.add(cmbleavetype);
				boxtext.add(Box.createRigidArea(new Dimension(10, 10)));
				boxtext.add(txtdays);
				
				boxdate.add(lblto);
				boxdate.add(Box.createRigidArea(new Dimension(10, 20)));
				boxdate.add(txtto);
				boxdate.add(Box.createRigidArea(new Dimension(30, 20)));
				boxdate.add(lblfrom);
				boxdate.add(Box.createRigidArea(new Dimension(10, 20)));
				boxdate.add(txtfrom);
				
				
				boxlabel.setMaximumSize(new Dimension(150,270));
				boxtext.setMaximumSize(new Dimension(150,270));
				boxdate.setMaximumSize(new Dimension(280,20));
				
				
				boxinput=Box.createHorizontalBox();
				boxinput.add(boxlabel);
				boxinput.add(boxtext);
				
				
				boxcentre=Box.createVerticalBox();
				boxcentre.add(boxinput);
				boxcentre.add(boxdate);
			
				panelbutton=new JPanel();
				
				panelbutton.add(btnapply);
				panelbutton.add(btncancel);
				panelbutton.add(btnrefresh);
			add(panelbutton,BorderLayout.SOUTH);
			add(boxcentre,BorderLayout.CENTER);
			//add(lbltop,BorderLayout.NORTH);
			
			setSize(600,500);
			setVisible(true);
			setTitle("LEAVE REQUEST");
			setLocationRelativeTo(null);
			setResizable(false);
			btnapply.addActionListener(this);
			btncancel.addActionListener(this);
			btnrefresh.addActionListener(this);
			setplcl();
			getdata();
			
			
		}
	

		public  void setplcl()
		{
			int id=Login.getUserid();
			//date
			/*Date d =new Date();
			d.getDate();
			DateFormat outdate;
	        outdate=DateFormat.getDateInstance();
	        String date = outdate.format(d);*/
			ArrayList<plcldata> listplcl=new ArrayList<plcldata>();
			try {
				listplcl=FileReadWritePLCLdetail.readingFromPLCLdetail();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(btnapply,"File not found");
			}
			SimpleDateFormat sdf;
		    sdf = new SimpleDateFormat("dd/MM/yy");
	        String date = sdf.format(new Date());
			boolean check = false;
			for(int index=0;index<listplcl.size();index++)
	        {
				plcldata detail=listplcl.get(index);
        		//JOptionPane.showMessageDialog(lblemployeeiddata,""+employee.getEmployeeid()+"...."+detail.getEmployeeid());

	        	if(id==detail.getEmployeeid())
	        	{
	        		//JOptionPane.showMessageDialog(lblemployeeiddata,""+date+"...."+detail.getDate());
	        		for(int count=1;count<60;count++)
	        		{
	        			int set = detail.getYear();
	        			if(DaysDifference.getDaysDifference(detail.getDoj(),date)>(count*365))
	        			{
	        				if(detail.getPl()==0&&detail.getCl()==0&&set==(count-1))
	        				{
	        					check=true;
	        					detail.setPl(detail.getPl()+30);
	        					detail.setCl(10);
	        					detail.setYear(count);
	        				}
	        			}
	        		}
	        	}
	        }
	        	if(check==true)
	        		{
	    		
	    			try
	    	        {
	    				FileReadWritePLCLdetail.writingToPLCLdetail(listplcl);
	    			
	    	        	
	    	        }
	    	        catch(Exception exp)
	    	        {
	    	        	JOptionPane.showMessageDialog(btnapply,"File not found");
	    	        }
        			//JOptionPane.showMessageDialog(btnapply,"Leave Request Successfully submitted");
        			
	        	     	
	        		}
	        	//else
	        	//	JOptionPane.showMessageDialog(btnapply,"You have already applied for Leave request today");
			
			//plcldata
			
			
			
			
		}
		
		
		
		public  void getdata()
		{
			//Date
			int id=Login.getUserid();
			Fetch fetch=new Fetch(id);
			Date d =new Date();
			d.getDate();
			DateFormat outdate;
	        outdate=DateFormat.getDateInstance();
	        String date = outdate.format(d);
	        
			int userid=Login.getUserid();
			Fetch userdetail=new Fetch(userid);
			
			String iddata= Integer.toString(userid);
			String name= userdetail.getName();
			String department= userdetail.getDepartment();
			String leavetype= "PL";
			String level= userdetail.getLevel();
			String dateapplied= date;
			String designation=userdetail.getDesignation();
			
			lbliddata.setText(iddata);
			 lblnamedata.setText(name);
			 lbldepartmentdata.setText(department);
			 //cmbleavetype.setText(leavetype);
			 lblleveldata.setText(level);
			 lbldateapplieddata.setText(dateapplied);
			 lbldesignationdata.setText(designation);
			
			
		}
		
		
		private void   writetodb() 
		{
			int id=Login.getUserid();
			Fetch fetch=new Fetch(id);
			Date d =new Date();
			d.getDate();
			DateFormat outdate;
	        outdate=DateFormat.getDateInstance();
	        String date = outdate.format(d);
	        
			int userid=Login.getUserid();
			Fetch userdetail=new Fetch(userid);
			
			String name= userdetail.getName();
			String department= userdetail.getDepartment();
			String leavetype= (String) cmbleavetype.getSelectedItem();
			String level= userdetail.getLevel();
			String dateapplied= date;
			String designation=userdetail.getDesignation();
			int days=Integer.parseInt(txtdays.getText());
			String dateto=txtto.getText().trim();
			String datefrom=txtfrom.getText().trim();
			
			boolean check = true;
			boolean checkmsg = true;
			
			//JOptionPane.showMessageDialog(this,"333");
			if(leavetype.equals("select")==true||Valid.isEmpty(txtdays.getText().trim())==true||Valid.isEmpty(txtto.getText().trim())==true||Valid.isEmpty(txtfrom.getText().trim())==true)
			{
				JOptionPane.showMessageDialog(this,"Empty Field");
				check=false;
				checkmsg = false;
			}
			else
			{
				//JOptionPane.showMessageDialog(this,"111");
				for(int index=0;index<list.size();index++)
				{
					RequestedLeave detail=list.get(index);
        		
					if(userid==detail.getEmployeeid())
					{
						if(date.equals(detail.getApplieddate()))
						{  
							if(detail.getStatus().equals("REJECTED"))
	        				{
	        					check=true;
	        			
	        				}
	        				else
	        				check=false;
						}
												
					}
				}
			}
			
	        	if(check==true)
	        		{		        
	        		RequestedLeave ref=new RequestedLeave(userid,name,department,designation,level,leavetype,dateapplied,days,dateto,datefrom,"PENDING",null);
	    			list.add(ref);
	    		
	    			try
	    	        {
	    				FileReadWriteLeaveRequest.writingToLeaveRequest(list);
	    			
	    	        	
	    	        }
	    	        catch(Exception exp)
	    	        {
	    	        	JOptionPane.showMessageDialog(this,"File not found");
	    	        }
        			JOptionPane.showMessageDialog(this,"Leave Request Successfully submitted");
        			
	        	     	
	        		}
	        	else
	        		if(checkmsg == true)
	        		JOptionPane.showMessageDialog(this,"You have already applied for Leave request today");
		
			
			
		}	
		
		public void actionPerformed(ActionEvent event)
		{

			if (event.getSource()==btnapply)
			{
	            writetodb(); 
			}
			if (event.getSource()==btncancel)
			{
				
			}
			if (event.getSource()==btnrefresh)
			{
				
			}
		}
		
	public static void main(String args[]) throws Exception
	{
		new LeaveRequest();
		}

	
}

