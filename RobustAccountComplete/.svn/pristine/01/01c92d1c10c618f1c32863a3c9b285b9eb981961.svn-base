package ca.ubc.cpsc210.bank;

import java.util.Scanner;

import ca.ubc.cpsc210.bank.exceptions.IllegalValueException;
import ca.ubc.cpsc210.bank.exceptions.NotEnoughMoneyException;

/*
 * Bank teller using exception handling.
 */
public class Teller {
    private static RobustAccount cheq;
    private static RobustAccount sav;
    private static Scanner input;
    
    /*
     * EFFECTS: process user input
     */
    public static void main(String[] args) {
        boolean keepGoing = true;
        String command = null;
        
        try {
            init();
            
            while(keepGoing) {
                displayMenu();
                command = input.next();
                command = command.toLowerCase();
                
                if(command.equals("d"))
                    doDeposit();
                else if(command.equals("w"))
                    doWithdrawal();
                else if(command.equals("t"))
                    doTransfer();
                else if(command.equals("q"))
                    keepGoing = false;  
                else
                    System.out.println("Selection not valid...");
            }
        }
        catch (IllegalValueException excep) {
            System.out.println(excep.getMessage());
            System.out.println("Terminating program...");
        }
        
        System.out.println("\nGoodbye!");
    }
    
    /*
     * EFFECTS: initialize accounts and scanner
     */
    private static void init() throws IllegalValueException {
        cheq = new RobustAccount("Joe", 145.00);
        sav = new RobustAccount("Joe", 256.50);
        input = new Scanner(System.in);
    }
    
    /*
     * EFFECTS: display main menu of options to user
     */
    private static void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\td -> deposit");
        System.out.println("\tw -> withdraw");
        System.out.println("\tt -> transfer");
        System.out.println("\tq -> quit");
    }
    
    /*
     * EFFECTS: conduct a deposit transaction
     */
    private static void doDeposit() {
        RobustAccount selected = selectAccount();
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();

        try {
            selected.deposit(amount);
        }
        catch (IllegalValueException excep) {
            System.out.println(excep.getMessage());
        }

        printBalance(selected);
    }
    
    /*
     * EFFECTS: conduct a withdraw transaction
     */
    private static void doWithdrawal() {
        RobustAccount selected = selectAccount();
        System.out.print("Enter amount to withdraw: $");
        double amount = input.nextDouble();
        
        try {
            selected.withdraw(amount);
        }
        catch (IllegalValueException excep) {
            System.out.println(excep.getMessage());
        }
        catch (NotEnoughMoneyException excep) {
            System.out.println(excep.getMessage());
        }
        
        printBalance(selected);
    }
    
    /*
     * EFFECTS: conduct a transfer from one account to another
     */
    private static void doTransfer() {
        System.out.println("\nTransfer from?");
        RobustAccount source = selectAccount();
        System.out.println("Transfer to?");
        RobustAccount destination = selectAccount();
        
        System.out.print("Enter amount to transfer: $");
        double amount = input.nextDouble();
        
        try {
            source.withdraw(amount);
            destination.deposit(amount);
        }
        catch (IllegalValueException excep) {
            System.out.println(excep.getMessage());
        }
        catch (NotEnoughMoneyException excep) {
            System.out.println(excep.getMessage());
        }
            
        System.out.print("Source ");
        printBalance(source);
        System.out.print("Destination ");
        printBalance(destination);     
    }
    
    /*
     * EFFECTS: allows user to select an account and returns selected account
     */
    private static RobustAccount selectAccount() {
        String selection = "";  // force entry into loop
        
        while(!(selection.equals("c") || selection.equals("s"))) {
            System.out.println("c for chequing");
            System.out.println("s for savings");
            selection = input.next();
            selection = selection.toLowerCase();
        }
        
        if(selection.equals("c"))
            return cheq;
        else
            return sav;        
    }
    
    /*
     * EFFECTS: prints balance of selected account on the screen
     */
    private static void printBalance(RobustAccount selected) {
        System.out.printf("Balance: $%.2f\n", selected.getBalance());
    }
}
