package Validate;



public class Validation {
	public static boolean IsNotEmpty(String demo)
	{
		boolean check;
		if (demo.equals(""))
			check=false;
		else
			check=true;
		
		return check;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
