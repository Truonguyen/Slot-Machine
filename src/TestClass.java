//info doc: https://docs.google.com/document/d/16NLNY-AGeofnpPYgyE-3smV9kC6HRt3GVmEwmDkOLEM/edit?usp=sharing

import java.util.*;
import javax.swing.JOptionPane;


//    written by :
//        brandon alba
//        james davie
//        truong nguyen
//        rebekah salsburg
public class TestClass {

    public static void main(String[] args) {
        final int maxPlayer = 51;
        final int maxMach = 50;
        int choice;
        String message = "";
     
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<SlotMachine> machines = new ArrayList<SlotMachine>();
        SlotMachine.hardCodeMachine(machines);
        Player.uncleCharlie(players);


        do {
            choice = Methods.displayMenu();
            switch (choice) {
                case 1: //create a player
                    if (players.size() == maxPlayer) {
                        JOptionPane.showMessageDialog(null, "you've entered the max amount of players! [" + maxPlayer + "]", "Max Players Created", JOptionPane.ERROR_MESSAGE);
                        //max player count reached 
                    }
                    else {
                        players.add(new Player()); //however the constructor is done
                    }

                    break;
                case 2: //create a machine
                     if (machines.size() == maxMach) {
                         JOptionPane.showMessageDialog(null, "you've made the max amount of machines! [" + maxMach + "]", "Max Machines Created", JOptionPane.ERROR_MESSAGE);
                         //max machine count reached
                     }
                     else {
                         machines.add(new SlotMachine()); //however the constructor is done
                     }
                    break;

                case 3: //play
                	SlotMachine.playSlotMachine(machines, players);
                    break;
                case 4: //display players
                	message = "";
                    for (Player p : players) {
                    	message += p + "\n";
                    }
                    JOptionPane.showMessageDialog(null, message);

                    break;

                case 5: //display machines
                	message = "";
                	int i = 0;
                    for (i = 0; i < machines.size(); i++) {
                    	message += machines.get(i);
                    	if (i != 0 && i % 10 == 0) {
                    		message += "\n";
                    	}
                    }
                    JOptionPane.showMessageDialog(null, message);
                    
                    break;
                case 0: //quit
                    Player.print(players);
                    JOptionPane.showMessageDialog(null, "goodbye!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "that's not a valid option.");

            } //end switch case
        } while (choice != 0);
        //end do while

    } //end main


    // ===========================================================

}



