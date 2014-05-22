
package Database;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import General.Attendance;


public class  AttendanceStorge {
	public static void writingToUserAttendanceDB(ArrayList<Attendance> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("AttendanceDB");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<Attendance> readingFromUserAttendanceDB() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("AttendanceDB");
		read=new ObjectInputStream(file);
		ArrayList<Attendance> list=(ArrayList<Attendance>)read.readObject();
		return list;

	}
	
	
}