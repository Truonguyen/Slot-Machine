import java.text.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class SlotMachine {
	private String slotName;
	private double slotHopper;
	private int jackWin;
	private double jackPays;
	private int jackChance;
	private int regWin;
	private double regPays;
	private int regChance;

	public SlotMachine() {
		addSlotMachine();
	}

	public SlotMachine(String slotName, double slotHopper, int jackWin, double jackPays, int regWin, double regPays,
			int jackChance, int regChance) {
		super();
		setSlotName(slotName);
		setSlotHopper(slotHopper);
		setJackWin(jackWin);
		setJackPays(jackPays);
		setRegWin(regWin);
		setRegPays(regPays);
		setJackChance(jackChance);
		setRegChance(regChance);
	}// end constructor

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public double getSlotHopper() {
		return slotHopper;
	}

	public void setSlotHopper(double slotHopper) {
		this.slotHopper = slotHopper;
	}

	public int getJackWin() {
		return jackWin;
	}

	public void setJackWin(int jackWin) {
		this.jackWin = jackWin;
	}

	public double getJackPays() {
		return jackPays;
	}

	public void setJackPays(double jackPays) {
		this.jackPays = jackPays;
	}

	public int getRegWin() {
		return regWin;
	}

	public void setRegWin(int regWin) {
		this.regWin = regWin;
	}

	public double getRegPays() {
		return regPays;
	}

	public void setRegPays(double regPays) {
		this.regPays = regPays;
	}

	public int getJackChance() {
		return jackChance;
	}

	public void setJackChance(int jackChance) {
		this.jackChance = jackChance;
	}

	public int getRegChance() {
		return regChance;
	}

	public void setRegChance(int regChance) {
		this.regChance = regChance;
	}

	@Override
	public String toString() {
		NumberFormat df = new DecimalFormat("##.00");
		String result;
		result = slotName ;
		result += " || Machine Hopper: $" + df.format(slotHopper) + "";
		result += " || Jackpot: $" + df.format(jackPays) + " || Chance: 1/" + jackChance;
		result += " || Regular: $" + df.format(regPays) + " || Chance: 1/" + regChance;
		result += " || Number of Jackpot Wins:" + jackWin;
		result +=  "|| Number of Regular Wins:" + regWin;
		result += "\n\n";
		return result;
	}
//==================================================================================================================================================

	public void addSlotMachine() {
		String name;
		double hopper;
		double jackPays;
		int jackChance;
		double regPays;
		int regChance;

		name = Methods.getString("Enter the name of Slot Machine: ");
		setSlotName(name);

		do {
			hopper = Methods.getDouble("Enter the amount money <" + name + "> contains: ");
			setSlotHopper(hopper);
			if (hopper == 0) {
				JOptionPane.showMessageDialog(null, "The hopper can't start off with $0!");
			}
		} while (hopper == 0);

		jackChance = Methods.getInt("Enter the odds of winning a jackpot: 1/ ");
		setJackChance(jackChance);

		do {
			jackPays = Methods.getDouble("Enter the amount you win from one jackpot: ");
			setJackPays(jackPays);
			if (jackPays == 0) {
				JOptionPane.showMessageDialog(null, "The jackpot can't be $0!");
			} //end if
		} while (jackPays == 0);
		do {
			regPays = Methods.getDouble("Enter the amount you win from playing:  ");
			setRegPays(regPays);
			if (regPays == 0 || regPays >= jackPays) {
				JOptionPane.showMessageDialog(null, "The regular payout can't be $0 or more than the jackpot payout!");
			} //end if
		} while (regPays == 0 || regPays >= jackPays);

		do {
			regChance = Methods.getInt("\"Enter the odds of a regular win: 1/ ");
			setRegChance(regChance);
			if (regChance >= jackChance) {
				JOptionPane.showMessageDialog(null, "The odds of getting the regular payout can't be smaller than the jackpot odds!");
			} //end if
		} while (regChance >= jackChance);

	} // end addSlotMachine

	public static void hardCodeMachine(ArrayList<SlotMachine> m) {
		// Parameters (String slotName, double slotHopper, int jackWin, double jackPays,
		// int regWin, double regPays, int jackChance, int regChance)
		m.add(new SlotMachine("Lucky Seven", 5000, 0, 5000, 0, 5, 10000, 10));
		m.add(new SlotMachine("Lucky Lotto", 55000, 0, 75000, 0, 25, 100000, 50));
		m.add(new SlotMachine("Purple People Eater", 1000, 0, 40, 0, 2, 50, 5));
		m.add(new SlotMachine("rebekah sucks", 1, 0, 100, 0, 2, 1000000, 1));
	} // end hardCodeMachine
	
	public String displayMachine(ArrayList<SlotMachine> m) {
		String menu = "";
		NumberFormat df = new DecimalFormat("##.00");
		for (int i = 0; i < m.size(); i++) {
			menu += "[" + (i + 1) + "] " + m.get(i).getSlotName() + "\t| Jackpot: $" + df.format(m.get(i).getJackPays())
					+ " | Odds: 1/" + m.get(i).getJackChance() + "\t";
			menu += " Win: $" + df.format(m.get(i).getRegPays()) + " | Odds: 1/" + m.get(i).getRegChance() + "\n\n";
		} //end for
		return menu;
	} //end displayMachine

	public static int pickMachine(ArrayList<SlotMachine> m) {
		int result = 0;
		String menu = m.get(0).displayMachine(m);
		menu += "[0] return to man menu";

		do {
			// display player
			result = Methods.getInt(menu + "\nPlease select a machine");

			// validation
			if (result < 0 || result > m.size()) {
				JOptionPane.showMessageDialog(null, "Please choose a machine within the range!");
			}
		} while (result < 0 || result > m.size());

		return result;
	} //end pickMachine

	public static void playMachine(Player p, SlotMachine m) {
		Random rand = new Random(); // create random object from "random" class
		int ranJack = rand.nextInt(m.getJackChance()) + 1; // ranNum from 1 to jackChance
		int ranReg = rand.nextInt(m.getRegChance()) + 1; // ranNum from 1 to regChance
		double wallet = p.getWallet();
		String message = "";
	
		wallet--; // subtract one from wallet every time they play
		m.setSlotHopper(m.getSlotHopper() + 1); // add one to hopper every time they play
		
		if(m.getSlotHopper() < m.getJackPays()){
			do{
				message += "The JACKPOT payout is $" + m.getJackPays() + " but there is only $" + m.getSlotHopper() + " in the slot hopper";
				message += "\nThere might not be enough money for us to distribute";
				m.setSlotHopper(m.getSlotHopper() + m.getJackPays()); 
				message += "\nLet us refill it for you" + "\nThe hopper now has $" + m.getSlotHopper();
				JOptionPane.showMessageDialog(null, message);
			}while(m.getSlotHopper() < m.getJackPays());
		} // refill the hopper (hopper won't ever be negative)
		
		if (ranJack == m.getJackChance()) {
			m.setSlotHopper(m.getSlotHopper() - m.getJackPays());
			m.setJackWin(m.getJackWin() + 1);
			wallet += m.getJackPays();
			JOptionPane.showMessageDialog(null, "====JACKPOT===\n" + "You won $" + m.getJackPays() + "!" +
												" You now have $" + wallet);

		} else if (ranReg == m.getRegChance()) {
			m.setSlotHopper(m.getSlotHopper() - m.getRegPays());
			m.setRegWin(m.getRegWin() + 1);
			wallet += m.getRegPays();
			JOptionPane.showMessageDialog(null, "====WINNER===\n" + "You won $" + m.getRegPays() + "!" + 
												" You now have $" + wallet);
		} else {
			JOptionPane.showMessageDialog(null, "====YOU LOST===\n" + "Keep gamblin your life away!" + 
												" You now have $" + wallet);
		} //end if else

		p.setWallet(wallet);

	}// end playMachine
	
	public static void playSlotMachine(ArrayList<SlotMachine> m, ArrayList<Player> p) {
		int player = 0;
		int machine = 0;
		char repeatPlay = 'Y';

		do {
			player = p.get(0).playerList(p) - 1; // pick user
			if (player == -1) {
				return;
			}
			if (p.get(player).getWallet() < 1) {
				JOptionPane.showMessageDialog(null, "you don't have enough money to play!");
			} //end if
		} while (p.get(player).getWallet() < 1);
		
		machine = SlotMachine.pickMachine(m); // pick machine
		machine--; //adjusts to array index
		if (machine == -1) {
			return;
		}
		
		do {
			playMachine(p.get(player), m.get(machine));
			repeatPlay = Methods.getString("Would you like to play again? 'Y' to play again/any button to exit").charAt(0);
		} while (repeatPlay == 'y' || repeatPlay == 'Y');
	} //end playSlotMachine

}// end class slotMachine
