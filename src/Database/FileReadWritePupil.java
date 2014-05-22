package Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import General.Employee;

public class FileReadWritePupil {

	public static void writingToPupildetail(ArrayList<Employee> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("PupilDB");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<Employee> readingFromPupildetail() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("PupilDB");
		read=new ObjectInputStream(file);
		ArrayList<Employee> list=(ArrayList<Employee>)read.readObject();
		return list;

	}

}
