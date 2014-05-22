
package ViewDB;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.AttendanceStorge;
//import Database.FileReadWrite;
import General.Attendance;

public class InOutTimeDB extends JFrame {

		private JTable table;
		private ArrayList<Attendance> list;
		private String[] heading={"ID","name","date","intime","outtime","Late min"};
		private String[][] data;
		private JScrollPane pane;
		
		public InOutTimeDB()
		{
			list=new ArrayList<Attendance>();
			
			try
			{
				list=AttendanceStorge.readingFromUserAttendanceDB();             
			}
			catch(Exception exp)
			{
				JOptionPane.showMessageDialog(table,"NO Records");
				//System.out.println("NO Records");
			}

			data=new String[list.size()][6];
			//get object
			int index,row=0,col=0;
			for(index=1;index<list.size();index++)
			{
				Attendance attendance=list.get(index);
				data[row][col]=String.valueOf(attendance.getId());
				data[row][++col]=attendance.getName();
				data[row][++col]=attendance.getDate();
				data[row][++col]=attendance.getIntime();
				data[row][++col]=attendance.getOuttime();
				data[row][++col]=String.valueOf(attendance.getLatemin());
				col=0;
				++row;
				
			}
			table=new JTable(data,heading);
			pane=new JScrollPane(table);
			add(pane);
			setSize(800,200);
			setVisible(true);
			setTitle("View Attendance");
			
			
			
			
			
		}
		public static void main(String[] args) 
		{
			new InOutTimeDB();
		}

		}
