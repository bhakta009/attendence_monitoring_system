package ViewDB;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.FileReadWriteLeaveRequest;
import General.RequestedLeave;
import General.RequestedLeave;;

public class ViewLeaveRequest extends JFrame{
	private JTable table;
	private ArrayList<RequestedLeave> list;
	private String[] heading={"Employeeid","name","Department","Designation","Level","typeofleave","applieddate","noofdays","datefrom","dateto","status","remark"};
	private String[][] data;
	private JScrollPane pane;
	
	
	public ViewLeaveRequest()
	{
		list=new ArrayList<RequestedLeave>();
		try
		{
			list=FileReadWriteLeaveRequest.readingFromLeaveRequest();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(table,"NO Records");
			//System.out.println("NO Records");
		}

		data=new String[list.size()][12];
		int index,row=0,col=0;
		for(index=1;index<list.size();index++)
		{
			RequestedLeave leave=list.get(index);
			data[row][col]=String.valueOf(leave.getEmployeeid());
			data[row][++col]=leave.getName();
			data[row][++col]=leave.getDepartment();
			data[row][++col]=leave.getDesignation();
			data[row][++col]=leave.getLevel();
			data[row][++col]=leave.getTypeofleave();
			data[row][++col]=leave.getApplieddate();
			data[row][++col]=String.valueOf(leave.getNoofdays());
			data[row][++col]=leave.getDatefrom();
			data[row][++col]=leave.getDateto();
			data[row][++col]=leave.getStatus();
			data[row][++col]=leave.getRemark();
			
			col=0;
			++row;
			
		}
		table=new JTable(data,heading);
		pane=new JScrollPane(table);
		add(pane);
		setSize(800,200);
		setVisible(true);
		setTitle("LEAVE REQUEST");
	}
	public static void main(String[] args) 
	{
		new ViewLeaveRequest();
	}

}
