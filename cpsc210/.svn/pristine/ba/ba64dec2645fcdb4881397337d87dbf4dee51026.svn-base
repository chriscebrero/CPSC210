package ca.ubc.cs.cpsc210.application;

import ca.ubc.cs.cpsc210.model.Car;

// simple application class
public class Main {

    public static void main(String[] args) {
        Car newCar = new Car();
        System.out.println("Gas in tank: " + newCar.getGasInTank() + " litres");


        newCar.addGasToTank(10.0);
        System.out.println("Gas in tank: " + newCar.getGasInTank() + " litres");
        System.out.println("Distance car can be driven: " + newCar.getDistanceUntilEmpty() + "kms");


        newCar.drive(50);
        System.out.println("Gas remaining in tank: " + newCar.getGasInTank() + " litres");
        System.out.println("Total distance driven: " + newCar.getTotalDistanceTravelled() + "kms");

        Car otherCar = new Car();		// same class but another car object!
        otherCar.addGasToTank(10.0);

        newCar.drive(5);				// which car are we driving?
        otherCar.drive(10);			    // which car are we driving?
    }
}
