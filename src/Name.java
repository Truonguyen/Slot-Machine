import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class Name {

	String firstName, middleInitial, lastName;

	public Name() {
		setFirstName();
		setMiddleInitial();
		setLastName();
	}

	public Name(String firstName, String middleInitial, String lastName) {
		this.firstName = firstName;
		this.middleInitial = (middleInitial == null) ? "" : middleInitial;
		this.lastName = lastName;

	}

	public String setFirstName() {

		// Get the first name from the user
		do {
			do {
				firstName = Methods.getString("Please enter the players first name");

				if (!Pattern.matches("[a-zA-Z]+", firstName)) {

					JOptionPane.showMessageDialog(null, "You're not a robot, enter in letters");

				}

			} while (!Pattern.matches("[a-zA-Z]+", firstName));

			// Make sure the first name is less than 20 characters

			
			if (firstName.length() > 20) {

				JOptionPane.showMessageDialog(null, "Please enter a first name that is less than 20 characters!");

			}

		} while (firstName.length() > 20);

		// Capitalize first letter of first name

		firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

		return firstName;

	}

	public String setMiddleInitial() {

		// Get the middle initial from the user
		do {
			do {
				middleInitial = Methods.getString("Please enter the middle initial (Enter a space for none)");

				if (!Pattern.matches("[a-z A-Z]+", middleInitial)) {
					JOptionPane.showMessageDialog(null, "You're not a robot, enter in letters");
				}
			} while (!Pattern.matches("[a-z A-Z]+", middleInitial));

			if (middleInitial.length() > 1) {
				JOptionPane.showMessageDialog(null, "Please enter a middle initial that is one character!");
			}
		} while (middleInitial.length() > 1);

		// Capitalize middle initial
		middleInitial = middleInitial.substring(0, 1).toUpperCase();

		return middleInitial;
	}

	public String setLastName() {

		// Get the last name from the user
		do {

			do {

				lastName = Methods.getString("Please enter the players last name");

				if (!Pattern.matches("[a-zA-Z]+", lastName)) {

					JOptionPane.showMessageDialog(null, "You're not a robot, enter in letters");

				}

			} while (!Pattern.matches("[a-zA-Z]+", lastName));

			// Make sure the last name is less than 20 characters

			if (lastName.length() > 20) {

				JOptionPane.showMessageDialog(null, "Please enter a last name that is less than 20 characters!");

			}

		} while (lastName.length() > 20);

		// Capitalize first letter of last name

		lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

		return lastName;

	}

	public String toString() {
		return firstName + (middleInitial != " " ? " " + middleInitial : "") + " " + lastName;
	}

}
