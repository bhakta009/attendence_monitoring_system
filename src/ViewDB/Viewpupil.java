package ViewDB;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.FileReadWriteConsultantdetail;
import Database.FileReadWritePupil;
import General.Employee;

public class Viewpupil extends JFrame {

	private JTable table;
	private ArrayList<Employee> list;
	private String[] heading={"employeeid","name"," dateofjoining"," department","designation"," mobno"," username"," password"," bloodgroup"," email","usertype"};
	private String[][] data;
	private JScrollPane pane;
	
	public Viewpupil()
	{
		list=new ArrayList<Employee>();
		try
		{
			list=FileReadWritePupil.readingFromPupildetail();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(table,"NO Records");
			//System.out.println("NO Records");
		}

		data=new String[list.size()][11];
		
	//get object
		int index,row=0,col=0;
		for(index=0;index<list.size();index++)
		{
			Employee employee=list.get(index);
			data[row][col]=String.valueOf(employee.getEmployeeid());
			data[row][++col]=employee.getFirstname()+" "+employee.getMiddlename()+" "+employee.getLastname();
			data[row][++col]=employee.getDateofjoining();
			data[row][++col]=employee.getDepartment();
			data[row][++col]=employee.getDesignation();
			data[row][++col]=employee.getMobno();
			data[row][++col]=employee.getUsername();
			data[row][++col]=employee.getPassword();
			data[row][++col]=employee.getBloodgroup();
			data[row][++col]=employee.getEmail();
			data[row][++col]=employee.getUsertype();
			
			
			col=0;
			++row;
			
		}
		table=new JTable(data,heading);
		pane=new JScrollPane(table);
		add(pane);
		setSize(800,200);
		setVisible(true);
		setTitle("View All Student");
	}
	public static void main(String[] args) 
	{
		new Viewpupil();
	}

}
