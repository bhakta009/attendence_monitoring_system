package General;

import java.util.ArrayList;

import Database.FileReadWritelogindetail;

public class Maintainid {
	private static int id;
	private static ArrayList<Logindetail> list;
	private static int temp=1,p;
	public static int getId() 
	{
		
		list=new ArrayList<Logindetail>();
		try
		{
			list=FileReadWritelogindetail.readingFromUserDetailsDB();
		}
		catch(Exception exp)
		{
			System.out.println("NO Records");
			temp=0;
		}
			if(temp==0)
			{
				p=0;
				temp=1;
			//System.out.println(p);
			}
			else
			{
				Logindetail employee=list.get(list.size()-1);
				p=employee.getEmployeeid();
				//System.out.println(p);
				temp=1;
			}
		
		return (p+1);
			
		
	}

	public static void setId(int id) {
		Maintainid.id = id;
	}

	
	}


