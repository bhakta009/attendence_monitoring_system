package Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import General.Report;

public class FileReadWriteReport 
{
	public static void writingToReport(ArrayList<Report> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("ReportDB");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<Report> readingFromReport() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("ReportDB");
		read=new ObjectInputStream(file);
		ArrayList<Report> list=(ArrayList<Report>)read.readObject();
		return list;

	}

}
