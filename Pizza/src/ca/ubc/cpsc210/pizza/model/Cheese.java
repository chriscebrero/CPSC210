package ca.ubc.cpsc210.pizza.model;

// Represent the cheese for a pizza

public class Cheese extends Ingredient{
    public static final String DESCRIPTOR = "cheese";
    private String name;   // the name of the Specific Cheese
    private int cost;      // the cost of the Specific Cheese

	// EFFECTS: name is set to DESCRIPTOR, cost is set to given cost
	public Cheese(int start) {
        super(start);
	}

    // EFFECTS: name is set to cheeseName + " " + DESCRIPTOR, cost is set to given cost
    public Cheese(String cheeseName, int cost) {
        this.name = cheeseName + "" + DESCRIPTOR;
        this.cost = cost;
    }
}
