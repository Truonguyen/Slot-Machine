import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
import java.text.*;

public class Player {
	private Name name;
	private Date DOB;
	private double wallet;

	public Player() {
		addPlayer();
	}

	public Player(Name name, Date DOB, double wallet) {
		super();
		setName(name);
		setDOB(DOB);
		setWallet(wallet);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {

		this.name = name;
	}

	public Date getDOB() {

		return DOB;
	}

	public void setDOB(Date DOB) {

		this.DOB = DOB;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		while (wallet < 0) {
			wallet = Methods.getDouble("enter how much money you have in your wallet: ");
		}
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		NumberFormat def = new DecimalFormat("##.00");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		return name + " (" + df.format(DOB) + ") | $" + def.format(wallet) + " remaining";
	}

	// ======================================================================

	public void addPlayer() {
		Name name = new Name();
		double wallet = 0;

		DOB = Methods.getDate("enter your birthday (mm/dd/yyyy): ");
		wallet = Methods.getDouble("how much money do you have in your wallet ($)?: ");
		setName(name);
		setDOB(DOB);
		setWallet(wallet);

	} // end addPlayer

	public int playerList(ArrayList<Player> players) {
		String menu = "";
		int choice = 0;
		int i = 1;

		for (Player p : players) {
			menu += ("[" + i + "] " + p + "\n");
			i++;
		}
		menu += "[0] return to main menu";
		do {	
			choice = Methods.getInt(menu);
			if (choice > players.size()) {
				JOptionPane.showMessageDialog(null, "that's not a choice!");
			}
		} while (choice > players.size());

		return choice;
	} // end playerList

	public static void print(ArrayList<Player> players) {
		PrintWriter output = null;
		boolean found = true;
		String print = "";

		try {
			output = new PrintWriter("playerList.txt");
		} catch (FileNotFoundException x) {
			found = false;
		}

		if (!found) {
			JOptionPane.showMessageDialog(null, "the file could not be created!");
		} else {
			for (Player p : players) {
				print += p.toString() + "\n";
			}
			output.println(print);
		}
		output.close();
	} // end print

	public static void uncleCharlie(ArrayList<Player> players) {
		Name name = new Name("Charlie", "", "Uncle");
		String result;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date date = null;
		df.setLenient(false);

		result = "01/04/1955";
		try {
			date = df.parse(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "invalid date! make sure to enter it as mm/dd/yyyy");

		}
		players.add(new Player(name, date, 100));
	}
}
