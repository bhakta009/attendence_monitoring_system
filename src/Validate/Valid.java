package Validate;

import java.util.Scanner;

public class Valid {
public static boolean isEmpty(String str)
{
	if(str.equals(""))
		return(true);
		else
		return(false);
}
public static boolean isEmail(String str)
{
	Scanner scan=new Scanner(str);
	//String pattern="^[a-z]{1}[a-z0-9]{0,}a[a-z]{1,10}.[a-z]{2,8}$'";
	String pattern=".+@.+\\.[a-z]+";
	if(scan.findInLine(pattern)==null)
		return(false);
	else
		return(true);
}

public static boolean isMobileNO(String str)
{
	Scanner scan=new Scanner(str);
	String pattern="^\\d{10}";
	if(scan.findInLine(pattern)==null)
		return(false);
		else
			return(true);
}
public static boolean isPassword(String str)
{
	Scanner scan=new Scanner(str);
	String pattern="^[A-Za-Z]{5}[0-9]{3}$";
	if(scan.findInLine(pattern)==null)
		return(false);
	else
		return(true);
	
}

}
