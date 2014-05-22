package ViewDB;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.FileReadWritePLCLdetail;
import General.plcldata;


public class ViewPLCLdata extends JFrame {

	private JTable table;
	private ArrayList<plcldata> list;
	private String[] heading={"Employee Id", "Name", "Department","Designation","Level","doj","PL","CL"};
	private String[][] data;
	private JScrollPane pane;
	
	public ViewPLCLdata()
	{
		list=new ArrayList<plcldata>();
		try {
			list=FileReadWritePLCLdetail.readingFromPLCLdetail();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(table,"File not found");
		}
		

		data=new String[list.size()][8];
		
	//get object
		int index,row=0,col=0;
		for(index=0;index<list.size();index++)
		{
			plcldata plcldata=list.get(index);
			data[row][col]=String.valueOf(plcldata.getEmployeeid());
			data[row][++col]=plcldata.getName();
			data[row][++col]=plcldata.getDepartment();
			data[row][++col]=plcldata.getDesignation();
			data[row][++col]=plcldata.getLevel();
			data[row][++col]=plcldata.getDoj();
			data[row][++col]=Integer.toString(plcldata.getPl());
			data[row][++col]=Integer.toString(plcldata.getCl());			
			col=0;
			++row;
			
		}
		table=new JTable(data,heading);
		pane=new JScrollPane(table);
		add(pane);
		setSize(800,200);
		setVisible(true);
		setTitle("PL-CL DATABASE");
	}
	public static void main(String[] args) 
	{
		new ViewPLCLdata();
	}

}
