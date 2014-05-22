package Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import General.Outduty;

public class FileReadWriteOutDuty {
	public static void writingToOutDutydetail(ArrayList<Outduty> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("OutdutyDB");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<Outduty> readingFromOutDutydetail() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("OutdutyDB");
		read=new ObjectInputStream(file);
		ArrayList<Outduty> list=(ArrayList<Outduty>)read.readObject();
		return list;

	}
	

}
