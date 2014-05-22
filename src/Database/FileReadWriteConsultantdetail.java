package Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import General.Employee;

public class FileReadWriteConsultantdetail 
{
	public static void writingToConsultantdetail(ArrayList<Employee> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("ConsultantDB");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<Employee> readingFromConsultantdetail() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("ConsultantDB");
		read=new ObjectInputStream(file);
		ArrayList<Employee> list=(ArrayList<Employee>)read.readObject();
		return list;

	}
	

}
