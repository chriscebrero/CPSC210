package ca.ubc.cpsc210.bank;

import ca.ubc.cpsc210.bank.exceptions.IllegalValueException;
import ca.ubc.cpsc210.bank.exceptions.NotEnoughMoneyException;
import com.sun.tools.corba.se.idl.constExpr.Not;

import java.util.IdentityHashMap;
import java.util.Scanner;

/*
 * Bank teller using exception handling (not complete).
 */

public class Teller {
    private static RobustMethodsAccount cheq;
    private static RobustMethodsAccount sav;
    private static Scanner input;

    /*
     * EFFECTS: processes user input
     */
    public static void main(String[] args) throws IllegalValueException {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("d"))
                doDeposit();
            else if (command.equals("w"))
                doWithdrawal();
            else if (command.equals("t"))
                doTransfer();
            else if (command.equals("q"))
                keepGoing = false;
            else
                System.out.println("Selection not valid...");
        }

        System.out.println("\nGoodbye!");
    }

    /*
     * EFFECTS: initializes accounts and scanner
     */
    private static void init() throws IllegalValueException {
        cheq = new RobustMethodsAccount("Joe", 145.00);
        sav = new RobustMethodsAccount("Joe", 256.50);
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
     * EFFECTS: conducts a deposit transaction
     */
    private static void doDeposit() {
        RobustMethodsAccount selected = selectAccount();
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();
        try {
            selected.deposit(amount);
            printBalance(selected);
        } catch (IllegalValueException e) {
            System.out.println("Can't deposit that amount" + e.getMessage());
        }
    }

    /*
     * EFFECTS: conducts a withdraw transaction
     */
    private static void doWithdrawal() {
        RobustMethodsAccount selected = selectAccount();
        System.out.print("Enter amount to withdraw: $");
        double amount = input.nextDouble();
        try {
            selected.withdraw(amount);
            printBalance(selected);
        } catch (IllegalValueException | NotEnoughMoneyException e) {
            System.out.println("Can't withdraw that amount" + e.getMessage());
        }
    }
    
    /*
     * EFFECTS: conducts a transfer from one account to another
     */
    private static void doTransfer() {
        System.out.println("\nTransfer from?");
        RobustMethodsAccount source = selectAccount();
        System.out.println("Transfer to?");
        RobustMethodsAccount destination = selectAccount();
        
        System.out.print("Enter amount to transfer: $");
        double amount = input.nextDouble();

        try {
            source.withdraw(amount);
            destination.deposit(amount);
        } catch (IllegalValueException | NotEnoughMoneyException e) {
            System.out.println("Can't transfer the amount");
        }
            
        System.out.print("Source ");
        printBalance(source);
        System.out.print("Destination ");
        printBalance(destination);
        
    }
    
    /*
     * EFFECTS: allows user to select an account and returns selected account
     */
    private static RobustMethodsAccount selectAccount() {
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
    private static void printBalance(RobustMethodsAccount selected) {
        System.out.printf("Balance: $%.2f\n", selected.getBalance());
    }
}
