package General;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JOptionPane;

import GUI.LeaveRequest;

public class DaysDifference {

	
	public static int  getDaysDifference(String dateStart,String dateStop)
	{
	
		dateStart = dateStart+" 00:00:00";
		dateStop = dateStop+" 00:00:00";
		
        
		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");  
        Date startDate = null;
		Date endDate= null;
		 try 
		  {
		   startDate = format.parse(dateStart);
		   endDate = format.parse(dateStop);
		  } catch (ParseException e)
		  {
		   e.printStackTrace();
		  }    

		// Get msec from each, and subtract.
		long difftime = endDate.getTime() - startDate.getTime();
		long diffSeconds = difftime / 1000;         
		long diffMinutes = difftime / (60 * 1000);         
		long diffHours = difftime / (60 * 60 * 1000); 
		long min=diffMinutes-(diffHours*60);
		long sec=((diffSeconds)-(diffHours*60*60)-(min*60));
		int days=(int) (diffHours/24);
		return days;
		
	}
	public static int  getTimeDifference(String timeStart,String timeStop)
	{
	
		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");  
        Date startDate = null;
		Date endDate= null;
		 try 
		  {
		   startDate = format.parse(timeStart);
		   endDate = format.parse(timeStop);
		  } catch (ParseException e)
		  {
		   e.printStackTrace();
		  }    

		// Get msec from each, and subtract.
		long difftime = endDate.getTime() - startDate.getTime();
		long diffSeconds = difftime / 1000;         
		long diffMinutes = difftime / (60 * 1000);         
		long diffHours = difftime / (60 * 60 * 1000); 
		long min=diffMinutes-(diffHours*60);
		long sec=((diffSeconds)-(diffHours*60*60)-(min*60));
		int days=(int) (diffHours/24);
		System.out.println(""+diffMinutes);
		return  (int) (diffMinutes);
		
	}
	public static void main(String args[]) throws Exception
	{
		
	}

}
