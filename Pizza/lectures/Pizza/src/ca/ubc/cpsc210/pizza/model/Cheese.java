package ca.ubc.cpsc210.pizza.model;

// Represent the cheese for a pizza

public class Cheese extends Ingredient {
    public static final String DESCRIPTOR = "cheese";

	// EFFECTS: name is set to DESCRIPTOR, cost is set to given cost
	public Cheese(int cost) {
        super(DESCRIPTOR, cost);
	}

    // EFFECTS: name is set to cheeseName + " " + DESCRIPTOR, cost is set to given cost
    public Cheese(String cheeseName, int cost) {
        super(cheeseName + " " + DESCRIPTOR, cost);
    }
}
