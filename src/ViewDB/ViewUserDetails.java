package ViewDB;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.FileReadWritelogindetail;
import General.Employee;
import General.Logindetail;

public class ViewUserDetails extends JFrame {

		private JTable table;
		private ArrayList<Logindetail> list;
		private String[] heading={"ID","username","password","usertype","Admin"};
		private String[][] data;
		private JScrollPane pane;
		
		public ViewUserDetails()
		{
			list=new ArrayList<Logindetail>();
			try
			{
				list=FileReadWritelogindetail.readingFromUserDetailsDB();
			}
			catch(Exception exp)
			{
				JOptionPane.showMessageDialog(table,"NO Records");
				//System.out.println("NO Records");
			}

			data=new String[list.size()][5];
			
		//get object
			int index,row=0,col=0;
			for(index=0;index<list.size();index++)
			{
				Logindetail employee=list.get(index);
				data[row][col]=String.valueOf(employee.getEmployeeid());
				data[row][++col]=employee.getUsername();
				data[row][++col]=employee.getPassword();
				data[row][++col]=employee.getUsertype();
				data[row][++col]=employee.getAdmin();
				
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
			new ViewUserDetails();
		}

		}


