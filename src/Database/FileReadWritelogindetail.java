package Database;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import General.Logindetail;


public class FileReadWritelogindetail {
	public static void writingToUserDetailsDB(ArrayList<Logindetail> list) throws Exception 
	{
		ObjectOutputStream write;
		FileOutputStream file=new FileOutputStream("UserDetailDB");
		write=new ObjectOutputStream(file);
		write.writeObject(list);
	}
	public static ArrayList<Logindetail> readingFromUserDetailsDB() throws Exception
	{
		ObjectInputStream read;
		FileInputStream file=new FileInputStream("UserDetailDB");
		read=new ObjectInputStream(file);
		ArrayList<Logindetail> list=(ArrayList<Logindetail>)read.readObject();
		return list;

	}
}
