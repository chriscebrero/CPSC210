package ca.ubc.cpsc210.pizza.model;

import org.omg.PortableInterceptor.INACTIVE;

// represents a topping on a pizza
public abstract class Topping extends Ingredient implements Surchargeable {
    private int surcharge;

    // EFFECTS: topping has given name, cost and the surcharge is zero
    public Topping(String name, int cost) {
        super(name, cost);
    }

    @Override
    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

    @Override
    public int getCost() {
        super.setCost(super.getCost() + surcharge);
        return super.getCost();
    }
}
