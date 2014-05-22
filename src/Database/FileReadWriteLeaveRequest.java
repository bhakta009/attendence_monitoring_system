package Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import General.RequestedLeave;

public class FileReadWriteLeaveRequest {
	public static void writingToLeaveRequest(ArrayList<RequestedLeave> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("LeaveRequestDB");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<RequestedLeave> readingFromLeaveRequest() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("LeaveRequestDB");
		read=new ObjectInputStream(file);
		ArrayList<RequestedLeave> list=(ArrayList<RequestedLeave>)read.readObject();
		return list;

	}
	


}
