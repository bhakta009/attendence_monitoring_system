package ViewDB;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.FileReadWriteReport;
import Database.FileReadWritelogindetail;
import General.Fetch;
import General.FetchReport;
import General.Logindetail;
import General.Report;

public class ViewReport extends JFrame
{
	private String[] heading={"ID","Name","Dept","Usertype","Total present","Total absent","Total Late","PL","CL"};
	private ArrayList<Logindetail> listlogin;
	private ArrayList<Report> listreport;
	private JTable table;
	private String[][] data;
	private JScrollPane pane;
	
	public ViewReport(String month,String year) 
	{
		try
		{
			listlogin=FileReadWritelogindetail.readingFromUserDetailsDB();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(table,"File not found");
			
		}
		
		data=new String[listlogin.size()][9];
		//get object
		 int row=0,col=0;
		for(int index=0;index<listlogin.size()-1;index++)
		{
			Logindetail detail=listlogin.get(index);
			int id=detail.getEmployeeid();
			
			FetchReport fetch=new FetchReport(id,month,year);
			data[row][col]=String.valueOf(id);
			data[row][++col]=fetch.getName();
			data[row][++col]=fetch.getDepartment();
			data[row][++col]=fetch.getUsertype();
			data[row][++col]=String.valueOf(fetch.getNoofdayspresent());
			data[row][++col]=String.valueOf(fetch.getNoofdaysabsent());
			data[row][++col]=String.valueOf(fetch.getTotallate());
			data[row][++col]=String.valueOf(fetch.getPl());
			data[row][++col]=String.valueOf(fetch.getCl());
			col=0;
			++row;
		}
		
		table=new JTable(data,heading);
		table.setVisible(true);
		pane=new JScrollPane(table);
		add(pane);
		setSize(800,200);
		setVisible(true);
		setTitle("Monthly Report");

	}

}
