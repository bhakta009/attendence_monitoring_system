
	package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Database.AttendanceStorge;
import Database.FileReadWritelogindetail;
import General.Attendance;
import General.DaysDifference;
import General.Employee;
import General.Fetch;
import General.Logindetail;
import General.Maintainid;

public class InOut extends JFrame implements ActionListener
	{
		private static final long duration = 0;
		private JButton btnleaverequest,btnouttime,btnintime,btninfo,btnadimlogin,btnchangepass;
		private Box boxbutton;
		private ArrayList<Attendance> list;
		private String intime,outtime,date ;
		private SimpleDateFormat sdf;
		//private DateFormat sdr;
		 
		 
	
	public InOut()
	{  
		sdf = new SimpleDateFormat("HH:mm:ss");
        list=new ArrayList<Attendance>();
        //reading data in list   	
    	try
    	{
    		list=AttendanceStorge.readingFromUserAttendanceDB();
    	}
    	catch (Exception e)
    	{
    		JOptionPane.showMessageDialog(btnintime,"File not found");
    		
    	}
    	
    	
		
    	//GUI INTERFACE
        btnadimlogin=new JButton("      Work as Admin      ");
		btninfo=new JButton("Employee Information");
		btnintime = new JButton("IN Time");
		btnchangepass= new JButton("Change Password");
		btnintime.setMaximumSize(btninfo.getMaximumSize());
		btnouttime = new JButton("OUT Time");
		btnchangepass.setMaximumSize(btninfo.getMaximumSize());
		btnouttime.setMaximumSize(btninfo.getMaximumSize());
		btnleaverequest=new JButton("Leave Request");
		btnleaverequest.setMaximumSize(btninfo.getMaximumSize());
		boxbutton=Box.createVerticalBox();
		boxbutton.add(Box.createRigidArea(new Dimension(60,20)));
		boxbutton.add(btnintime);
		boxbutton.add(Box.createRigidArea(new Dimension(60,20)));
		boxbutton.add(btnouttime);
		boxbutton.add(Box.createRigidArea(new Dimension(60,20)));
		boxbutton.add(btnleaverequest);
		boxbutton.add(Box.createRigidArea(new Dimension(60,20)));
		boxbutton.add(btnchangepass);
		boxbutton.add(Box.createRigidArea(new Dimension(60,20)));
		boxbutton.add(btnadimlogin);
		
		
    	
		btnintime.addActionListener(this);
		btnouttime.addActionListener(this);
		btnleaverequest.addActionListener(this);
		btnchangepass.addActionListener(this);
		btnadimlogin.addActionListener(this);
		add(boxbutton,BorderLayout.CENTER);
		setSize(240,290);
		setVisible(true);
		setTitle("ATTENDENCE");
		setLocationRelativeTo(null);
		setResizable(false);
		
		//button enable check
		initialdata();
    	
	}
	
	
	public void visible(boolean set)
	{
		if (set==true)
			btnadimlogin.setVisible(true);
		else
			btnadimlogin.setVisible(false);
	}

	
	public void setbutton()
	{
		for(int index=0;index<list.size();index++)
		{
    		Attendance detail=list.get(index);
		
    	if(Login.getUserid()==detail.getId())
    	 {
    		if(detail.getDate().equalsIgnoreCase(date))
    		{
    		if(detail.getIntime()==null)
    		{
    		  btnintime.setEnabled(true);
    		  btnouttime.setEnabled(false);
    		  btnadimlogin.setEnabled(false);
    		  btnleaverequest.setEnabled(false);
    		  btnchangepass.setEnabled(false);
    		}
    		else
    		{
      		  btnintime.setEnabled(false);
      		  btnouttime.setEnabled(true);
      		 btnadimlogin.setEnabled(true);
      		 btnleaverequest.setEnabled(true);
      		btnchangepass.setEnabled(true);
      		}
    		if(detail.getIntime()!=null&&detail.getOuttime()!=null)
    		{
    			btnintime.setEnabled(false);
        		btnouttime.setEnabled(false);
         		 btnadimlogin.setEnabled(true);
          		 btnleaverequest.setEnabled(true);
          		btnchangepass.setEnabled(true);
    		}
    		
    	}
    	}
    }
		Fetch fetch=new Fetch(Login.getUserid());
		
    	if(fetch.getUsertype().equals("REGULAR EMPLOYEE"))
    		btnleaverequest.setEnabled(true);
    	else

    		btnleaverequest.setEnabled(false);
}
		
	public void initialdata()
	{
		int id=Login.getUserid();
		Fetch fetch=new Fetch(id);
		Date d =new Date();
		d.getDate();
		DateFormat outdate;
        outdate=DateFormat.getDateInstance();
        date=outdate.format(d);
        boolean check=false;
        
        for(int index=0;index<list.size();index++)
		{
    		Attendance detail=list.get(index);
		
    	if(Login.getUserid()==detail.getId())
    	 {
    		if(detail.getDate().equalsIgnoreCase(date))
    		 {
    			if(detail.getIntime()!=null||detail.getOuttime()!=null)
        		{
    				check=true;
                //
        		}
    		}
    	 }
		}
        if(check==false)
    		{
        		
    			Attendance ref=new Attendance(id,fetch.getName(),date,null,null,0);
				list.add(ref);
				
				try
		        {
		        	AttendanceStorge.writingToUserAttendanceDB(list);
		        	
		        }
		        catch(Exception exp)
		        {
		        	System.out.println("Cannot write to database");
		        }
    		}
        setbutton();
	}
	
				
	
	
	
	
	private void   writetodb() 
	{
        
        for(int index=0;index<list.size();index++)
		{
    		Attendance detail=list.get(index);
		
    	if(Login.getUserid()==detail.getId())
    	 {
    		if(detail.getDate().equalsIgnoreCase(date));
    		{
    		if(detail.getIntime()==null)
    		{
    			detail.setIntime(intime);
    			int latemin=DaysDifference.getTimeDifference("09:00:00", intime);
    			if(latemin>0)
    			{
    				detail.setLatemin(latemin);
    			}
    		}
    	 	
    		else if(detail.getOuttime()==null)
    		{
    			detail.setOuttime(outtime);
    			
      		}
    		}
    	 }
	}
		
		try
        {
        	AttendanceStorge.writingToUserAttendanceDB(list);
        	
        }
        catch(Exception exp)
        {
        	System.out.println("Cannot write to database");
        }
		setbutton();
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource()==btnintime)
		{
	        intime = sdf.format(new Date());
            JOptionPane.showMessageDialog( btnintime,"IN TIME  : "+intime);
	        writetodb();
		
		}
		
		
		if (event.getSource()==btnouttime)
		{
			outtime=sdf.format(new Date());
			writetodb();
	        JOptionPane.showMessageDialog( btnouttime,"OUT TIME  : "+outtime ); 
	        
		}
	
		if (event.getSource()==btnleaverequest)
		{
				new LeaveRequest();
		}
		
		if (event.getSource()==btnchangepass)
		{
		new	UserSetPasswordPage();
		}
		if (event.getSource()==btnadimlogin)
		{
				new Adminpage();
		}
	}
	

	public static void main(String[] args) 
	{
		new InOut();
	}

	
	}

	