package ca.ubc.cpsc210.pizza.model;

// Represent an ingredient for a pizza

public abstract class Ingredient implements Chargeable{
	private String name;   // the name of the ingredient
	private int cost;      // the cost of the ingredient
    protected String DESCRIPTOR;

    // EFFECTS: constructs ingredient with given name and cost
    public Ingredient(int start) {
        super();
        this.name = DESCRIPTOR;
        this.cost = start;
    }

	public String getName() {
		return name;
	}
	
	@Override
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int getCost() {
		return cost;
	}
}
