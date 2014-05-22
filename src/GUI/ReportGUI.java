package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ViewDB.ViewReport;
import ViewDB.viewconsultant;

import Database.AttendanceStorge;
import Database.FileReadWriteReport;
import Database.FileReadWritelogindetail;
import General.Attendance;
import General.Fetch;
import General.FetchReport;
import General.Logindetail;
import General.Report;

public class ReportGUI extends JFrame implements ActionListener{
	
	private JLabel lbllabel;
	private JComboBox cmbmonth,cmbyear;
	private Box boxinput;
	private String[] month= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private JTable table;
	private JButton btnshow;
	private ArrayList<Attendance> list;
	
	private String[][] data;
	private JScrollPane pane;
	private ArrayList<Logindetail> listlogin;
	private ArrayList<Report> listreport;
	
	public ReportGUI()
	{
		lbllabel=new JLabel("Select Month & Year:      ");
		cmbmonth=new JComboBox(month);
		
		boxinput=Box.createHorizontalBox();
		btnshow=new JButton("SHOW");
		
		
		String yearvalue[]=new String[51];
		//yearvalue[0]="";
		int cnt=0;
		for(int i=2013;i>=1970;i--)
		{
			yearvalue[cnt]=String.valueOf(i);
			cnt++;	
		}
		cmbyear=new JComboBox(yearvalue);
		
		boxinput.add(lbllabel);
		boxinput.add(cmbmonth);
		boxinput.add(cmbyear);
		boxinput.add(btnshow);
		
		listlogin=new ArrayList<Logindetail>();
		
		try
		{
			listlogin=FileReadWritelogindetail.readingFromUserDetailsDB();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,"File not found");
			
		}
	
		
		add(boxinput,BorderLayout.NORTH);
			setSize(450,200);
			setVisible(true);
			setTitle("REPORT");
			setLocationRelativeTo(null);
			setResizable(false);
			
		 
			btnshow.addActionListener(this);
		
}
	
	public void filltable()
	{
		data=new String[listlogin.size()][8];
		//get object
		 int row=0,col=0;
		
		for(int index=0;index<listlogin.size()-1;index++)
		{
			Logindetail detail=listlogin.get(index);
			int id=detail.getEmployeeid();
			String month=(String)cmbmonth.getSelectedItem();
			String year=(String)cmbyear.getSelectedItem();
			FetchReport fetch=new FetchReport(id,month,year);
			data[row][col]=String.valueOf(id);
			data[row][++col]=fetch.getName();
			data[row][++col]=fetch.getDepartment();
			data[row][++col]=String.valueOf(fetch.getNoofdayspresent());
			data[row][++col]=String.valueOf(fetch.getNoofdaysabsent());
			data[row][++col]=String.valueOf(fetch.getTotallate());
			data[row][++col]=String.valueOf(fetch.getPl());
			data[row][++col]=String.valueOf(fetch.getCl());
			col=0;
			++row;
		}
		
		//table=new JTable(data,heading);
		table.setVisible(true);
		pane=new JScrollPane(table);
		add(pane,BorderLayout.CENTER);
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		
		if(event.getSource()==btnshow)
		{
			String month=(String)cmbmonth.getSelectedItem();
			String year=(String)cmbyear.getSelectedItem();
			new ViewReport(month,year);
			
			
		}
		
		
	}
	
	public static void main(String[] args) 
	{
		new ReportGUI();
	}
}

