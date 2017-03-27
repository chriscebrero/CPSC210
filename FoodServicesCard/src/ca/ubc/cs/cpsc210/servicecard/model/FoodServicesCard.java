package ca.ubc.cs.cpsc210.servicecard.model;

// Represents a card used to purchase food services at a university
public class FoodServicesCard {
    // NOTE TO CPSC 210 STUDENTS: normally, the 'final' keyword would be used in the declaration
    // of constants.  We omit it here to allow us to run tests against your code to
    // check that it works when different values are assigned.
    public static int POINTS_NEEDED_FOR_CASH_BACK = 2000;    // points needed to get cash-back reward
    public static int REWARD_POINTS_PER_CENT_CHARGED = 1;    // points earned for each cent charged to card
    public static int CASH_BACK_REWARD = 10;                 // reward in cents

    // add fields to represent changing properties of a food services card
    private int Balance;
    private int RP;

    // REQUIRES: initialBalance >= 0
    // EFFECTS: constructs food service card with given initial balance in cents and zero reward points
    public FoodServicesCard(int initialBalance) {
        Balance = initialBalance;
        RP = 0;
        // stub
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: adds amount cents to balance on card
    public void reload(int amount) {
        Balance += amount;
        // stub
    }

    // MODIFIES: this
    // EFFECTS: if there is sufficient balance on the account
    //            - subtracts amount cents from balance
    //            - adds reward points and then
    //                - if eligible, adds cash back reward(s) to account and deducts corresponding reward points
    //            - returns true
    //          otherwise, returns false
    public boolean makePurchase(int amount) {
        if (Balance >= amount) {
            Balance -= amount;
            RP += amount * REWARD_POINTS_PER_CENT_CHARGED;
            do {
                Balance += CASH_BACK_REWARD;
                RP -= POINTS_NEEDED_FOR_CASH_BACK;
            } while (RP >= POINTS_NEEDED_FOR_CASH_BACK);
            return true;
        }
        return false;
    }


    // EFFECTS: returns remaining balance in cents
    public int getBalance() {
        return Balance;    // stub
    }

    // EFFECTS: returns number of unused reward points
    public int getRewardPoints() {
        return RP;    // stub
    }
}