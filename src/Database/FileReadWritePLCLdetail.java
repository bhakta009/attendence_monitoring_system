package Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import General.plcldata;

public class FileReadWritePLCLdetail 
{
	public static void writingToPLCLdetail(ArrayList<plcldata> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("PLCLdb");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<plcldata> readingFromPLCLdetail() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("PLCLdb");
		read=new ObjectInputStream(file);
		ArrayList<plcldata> list=(ArrayList<plcldata>)read.readObject();
		return list;

	}

}
