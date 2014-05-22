package Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import General.Employee;
import General.RegularEmployee;

public class FileReadWriteRegularEmployeedetail 
  {
	public static void writingToRegularEmployeedetail(ArrayList<Employee> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("RegularEmployeeDB");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<Employee> readingFromRegularEmployeedetail() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("RegularEmployeeDB");
		read=new ObjectInputStream(file);
		ArrayList<Employee> list=(ArrayList<Employee>)read.readObject();
		return list;

	}

}
