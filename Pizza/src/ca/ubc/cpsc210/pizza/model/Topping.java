package ca.ubc.cpsc210.pizza.model;

// represents a topping on a pizza
public abstract class Topping extends Ingredient implements Surchargeable{
    private int surcharge;

    // EFFECTS: topping has given name, cost and the surcharge is zero
    public Topping(int start) {
        super(start);
    }

    @Override
    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }
    // TODO: override getCost so that surcharge is added to basic cost
}
