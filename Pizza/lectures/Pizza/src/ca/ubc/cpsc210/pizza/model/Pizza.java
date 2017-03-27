package ca.ubc.cpsc210.pizza.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a pizza

public class Pizza {
    public static final int CRUSTCOST = 5;
    public static final String INGREDIENT_DESCRIPTOR = " topped by ";
    public int totalcost = CRUSTCOST;

    public Crust crust;

    List<Ingredient> ingredientslist;

	// EFFECTS: pizza has a crust and empty list of ingredients
	public Pizza() {
        ingredientslist = new ArrayList<>();
	}

	// REQUIRES: newIngredient is not null
	// MODIFIES: this
	// EFFECTS: newIngredient is added to end of list of ingredients
	public void addIngredient(Ingredient newIngredient) {
        ingredientslist.add(newIngredient);
	}

	// EFFECTS: the returned string starts with CRUST_DESCRIPTOR followed by
	// all ingredients in the order in which they were added,
    // with INGREDIENT_DESCRIPTOR between each ingredient
	public String ingredientsAsString() {
        String stringingredients = "crust";
        for (Ingredient item:ingredientslist) {
            stringingredients = stringingredients + INGREDIENT_DESCRIPTOR + item.getName();
        }
        return stringingredients;   // stub
	}

    // EFFECTS: Return the total cost of the pizza with crust and
	// all ingredients. Total cost >= CRUSTCOST.
	public int totalCost() {
        if (ingredientslist.isEmpty()){
            return totalcost;
        }
        for (Ingredient item:ingredientslist){
            totalcost += item.getCost();
        }
        return totalcost;   // stub
	}
}
