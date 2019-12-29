
import java.text.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Methods {
	
	public static int displayMenu(){
		  String menu;
	        int choice = 0;

	        menu = "main menu\n\n";
	        menu += "1. create a player\n";
	        menu += "2. create a machine\n";
	        menu += "3. play slots\n";
	        menu += "4. display players\n";
	        menu += "5. display machines\n";
	        menu += "0. quit\n";

	        menu += "\nselect a choice";
	        
	       choice = Methods.getInt(menu);
	       return choice;

	} //end display
	
	public static Date getDate(String message) {
		boolean good;
		String result;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date date = null;
		df.setLenient(false);
		
		do { 
			good = true;
			result = getString(message);
			try {
				date = df.parse(result);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "invalid date! make sure to enter it as mm/dd/yyyy");
				good = false;
				
			}			
		} while (!good);
		
		return date;
	} //end getDate
	
	public static double getDouble(String message){
		String input;
		double num = 0.0;
		boolean good = true;

		do {
			good = true;
			input = JOptionPane.showInputDialog(message, "enter a number");
			try {
				num = Double.parseDouble(input);
			} //end try
			catch (StringIndexOutOfBoundsException | NullPointerException | NumberFormatException x) {
				if (input == null) {
					quit();
					good = false;
				}
				else {
					JOptionPane.showMessageDialog(null, "that's not a number!");
					good = false;
				} //end if else
			} //end catch
			if (num < 0) {
				JOptionPane.showMessageDialog(null, "you can't enter a negative number!");
				good = false;
			} //end if

		} while (good == false);
		//end do while

		return num;
	} //end getInt
	
	public static int getInt(String message){
		String input;
		int num = 0;
		boolean good = true;

		do {
			good = true;
			input = JOptionPane.showInputDialog(message, "enter an integer");
			
			try {
				num = Integer.parseInt(input);
			} //end try
			catch (NumberFormatException x) {
				if (input == null) {
					quit();
					good = false;
				}
				else {
					JOptionPane.showMessageDialog(null, "that's not an integer!");
					good = false;
				} //end if else
			} //end catch
			
			if (num < 0 && good) {
				JOptionPane.showMessageDialog(null, "you can't enter a negative number!");
				good = false;
			} //end if
		
		} while (good == false);
		//end do while
		return num;
	} //end getInt
	
	public static String getString(String message) {
		String input;
		int n;
		
		do {
			n = 0;
			input = JOptionPane.showInputDialog(message, null);
			try { 
				if (Character.isDigit(input.charAt(0)) && input.charAt(0) < 2) {
					n = Integer.parseInt(input);
					if (n == JOptionPane.CANCEL_OPTION) {
						Methods.quit();
					} //end if
				} //end if
			} //end try
			catch (StringIndexOutOfBoundsException | NullPointerException | NumberFormatException x) {
				if (input == null) {
					Methods.quit();
				} //end if
				else {
					JOptionPane.showMessageDialog(null, "not a valid input!");
				} //end if else
				n = -1;
			} //end catch
			
		} while(n == -1); //end do while
		return input;
	} //end getString

	public static void quit() {
		int quit;
		quit = JOptionPane.showConfirmDialog(null, "are you sure you want to quit the program? your players won't be saved!", "quit?", JOptionPane.YES_NO_OPTION);
		if (quit == JOptionPane.YES_OPTION || quit == JOptionPane.CLOSED_OPTION) {
			JOptionPane.showMessageDialog(null, "goodbye!");
			System.exit(0);
		} //end if
		
			return;
	} //end quit
	
	
}