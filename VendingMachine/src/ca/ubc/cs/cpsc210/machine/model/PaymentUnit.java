package ca.ubc.cs.cpsc210.machine.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the payment unit in a vending machine.
 */
public class PaymentUnit {
    private int numLoonies;   // number of loonies banked in machine for making change
    private int numQuarters;  // number of quarters banked in machine for making change
    private int numDimes;     // number of dimes banked in machine for making change
    private int numNickels;   // number of nickels banked in machine for making change
    private List<Coin> currentTransaction;   // list of coins inserted into machine during current transaction
    private List<Coin> backTransaction;
    private int moneyBack;
    private int CoinsBanked;

    // EFFECTS: constructs a payment unit with no banked coins and no coins inserted into the machine
    // as part of a payment
    public PaymentUnit() {
        numLoonies = 0;
        numQuarters = 0;
        numDimes = 0;
        numNickels = 0;
        currentTransaction = new ArrayList<>();
        backTransaction = new ArrayList<>();
        //TODO: complete implementation
    }

    // MODIFIES: this
    // EFFECTS: clears all the coins banked in the unit
    public void clearCoinsBanked() {
        numLoonies = 0;
        numQuarters = 0;
        numDimes = 0;
        numNickels = 0;
        currentTransaction = Collections.emptyList();
        //TODO: complete implementation
    }

    // REQUIRES: number > 0
    // MODIFIES: this
    // EFFECTS: adds number coins of type c to the banked coins in the unit
    public void addCoinsToBanked(Coin c, int number) {
        if (c == Coin.LOONIE)
            numLoonies += number;
        else if (c == Coin.QUARTER)
            numQuarters += number;
        else if (c == Coin.DIME)
            numDimes += number;
        else if (c == Coin.NICKEL)
            numNickels += number;
        //TODO: complete implementation
    }

    // EFFECTS: returns number of coins banked of the given type
    public int getNumberOfCoinsBankedOfType(Coin c) {
        if (c == Coin.LOONIE)
            CoinsBanked = numLoonies;
        else if (c == Coin.QUARTER)
            CoinsBanked = numQuarters;
        else if (c == Coin.DIME)
            CoinsBanked = numDimes;
        else if (c == Coin.NICKEL)
            CoinsBanked = numNickels;
        return CoinsBanked;
    }

    // EFFECTS: returns the total value of all coins banked in the unit
    public int getValueOfCoinsBanked() {
        int TotalValue = numLoonies * Coin.LOONIE.getValue()
                + numQuarters * Coin.QUARTER.getValue()
                + numDimes * Coin.DIME.getValue()
                + numNickels * Coin.NICKEL.getValue();
        //TODO: complete implementation
        return TotalValue;
    }

    // MODIFIES: this
    // EFFECTS: adds coin c to the unit as a part of a transaction
    public void insertCoin(Coin c) {
        if (c == Coin.LOONIE)
            currentTransaction.add(Coin.LOONIE);
        else if (c == Coin.QUARTER)
            currentTransaction.add(Coin.QUARTER);
        else if (c == Coin.DIME)
            currentTransaction.add(Coin.DIME);
        else if (c == Coin.NICKEL)
            currentTransaction.add(Coin.NICKEL);
        //TODO: complete implementation
    }

    // EFFECTS: returns value of coins inserted for current transaction
    public int getValueOfCoinsInserted() {
        int accum = 0;
        for (Coin item : currentTransaction) {
            if (item == Coin.LOONIE)
                accum += Coin.LOONIE.getValue();
            else if (item == Coin.QUARTER)
                accum += Coin.QUARTER.getValue();
            else if (item == Coin.DIME)
                accum += Coin.DIME.getValue();
            else if (item == Coin.NICKEL)
                accum += Coin.NICKEL.getValue();
        }
        return accum;
    }

    // MODIFIES: this
    // EFFECTS: coins inserted for current transaction are cleared; list of coins
    // inserted for current transaction is returned in the order in which they were inserted.
    public List<Coin> cancelTransaction() {
        for (Coin item : currentTransaction) {
            if (item == Coin.LOONIE)
                backTransaction.add(Coin.LOONIE);
            else if (item == Coin.QUARTER)
                backTransaction.add(Coin.QUARTER);
            else if (item == Coin.DIME)
                backTransaction.add(Coin.DIME);
            else if (item == Coin.NICKEL)
                backTransaction.add(Coin.NICKEL);
            currentTransaction = Collections.emptyList();
        }
        return backTransaction;
    }

    // REQUIRES: cost <= total value of coins inserted as part of current transaction
    // MODIFIES: this
    // EFFECTS: adds coins inserted to coins banked in unit and returns list of coins that will be provided as change.
    // Coins of largest possible value are used when determining the change.  Change in full is not guaranteed -
    // will provide only as many coins as are banked in the machine, without going over the amount due.
    public List<Coin> makePurchase(int cost) {
        if (cost <= getValueOfCoinsInserted()) {
            moneyBack = getValueOfCoinsInserted() - cost;
            for (Coin item : currentTransaction) {
                if (item == Coin.LOONIE)
                    numLoonies += 1;
                else if (item == Coin.QUARTER)
                    numQuarters += 1;
                else if (item == Coin.DIME)
                    numDimes += 1;
                else if (item == Coin.NICKEL)
                    numNickels += 1;
            }
        }
            currentTransaction = Collections.emptyList();
            while (moneyBack >= Coin.LOONIE.getValue() && numLoonies > 0) {
                backTransaction.add(Coin.LOONIE);
                moneyBack -= Coin.LOONIE.getValue();
                numLoonies--;
            }
            while (moneyBack >= Coin.QUARTER.getValue() && numQuarters > 0) {
                backTransaction.add(Coin.QUARTER);
                moneyBack -= Coin.QUARTER.getValue();
                numQuarters--;
            }
            while (moneyBack >= Coin.DIME.getValue() && numDimes > 0) {
                backTransaction.add(Coin.DIME);
                moneyBack -= Coin.DIME.getValue();
                numDimes--;
            }
            while (moneyBack >= Coin.NICKEL.getValue() && numNickels > 0) {
                backTransaction.add(Coin.NICKEL);
                moneyBack -= Coin.NICKEL.getValue();
                numNickels--;
            }
            return backTransaction;
        }
    }
