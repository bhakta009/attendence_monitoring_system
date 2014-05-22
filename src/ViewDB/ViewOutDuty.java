package ViewDB;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.FileReadWriteOutDuty;
import General.Outduty;

public class ViewOutDuty extends JFrame{
	private JTable table;
	private ArrayList<Outduty> list;	
	private String[] heading={"Employee ID","Name","Department","Designation","Date","Time Out","Reason"};
	private String[][] data;
	private JScrollPane pane;
	
	public ViewOutDuty()
	{
		list=new ArrayList<Outduty>();
		//reading from file
		try
		{
			list=FileReadWriteOutDuty.readingFromOutDutydetail();
		}
		catch (Exception e)
		{
			System.out.println("File not found");
		}
		data=new String[list.size()][7];
		
		//get object
			int index,row=0,col=0;
			for(index=0;index<list.size();index++)
			{
				Outduty outduty=list.get(index);
				data[row][col]=String.valueOf(outduty.getEmployeeid());
				data[row][++col]=outduty.getName();
				data[row][++col]=outduty.getDepartment();
				data[row][++col]=outduty.getDesignation();
				data[row][++col]=outduty.getDate();
				data[row][++col]=outduty.getTimeout();
				data[row][++col]=outduty.getReason();
				col=0;
				++row;
			}
			table=new JTable(data,heading);
			pane=new JScrollPane(table);
			add(pane);
			setSize(400,200);
			setVisible(true);
			setTitle("View Details");
	}
	public static void main(String []arg)
	{
		new ViewOutDuty();
	}
}
