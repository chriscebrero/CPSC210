package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// unit tests for Car class
public class CarTest {
    private static final double TOL = 1.0e-12;
    private Car testCar;

    @Before
    public void runBefore() {
        testCar = new Car();
    }

    @Test
    public void testConstructor() {
        assertEquals(0.0, testCar.getGasInTank(), TOL);
        assertEquals(0, testCar.getTotalDistanceTravelled());
        assertEquals(0, testCar.getTripDistance());
    }

    @Test
    public void testAddGasToTank() {
        testCar.addGasToTank(Car.TANK_CAPACITY / 2.0);
        assertEquals(Car.TANK_CAPACITY / 2, testCar.getGasInTank(), TOL);

        // top up to max capacity of tank
        testCar.addGasToTank(Car.TANK_CAPACITY / 2.0);
        assertEquals(Car.TANK_CAPACITY, testCar.getGasInTank(), TOL);

        // overfill the tank
        testCar.addGasToTank(10.0);
        assertEquals(Car.TANK_CAPACITY, testCar.getGasInTank(), TOL);
    }

    @Test
    public void testResetTripDistance() {
        testCar.addGasToTank(Car.LITRES_PER_100KM);  // enough to drive 100km
        testCar.drive(10);
        assertEquals(10, testCar.getTripDistance());
        testCar.resetTripDistance();
        assertEquals(0, testCar.getTripDistance());
        assertEquals(10, testCar.getTotalDistanceTravelled());
    }

    @Test
    public void testGetDistanceUntilEmpty() {
        assertEquals(0, testCar.getDistanceUntilEmpty());

        testCar.addGasToTank(Car.LITRES_PER_100KM);
        assertEquals(100, testCar.getDistanceUntilEmpty());

        for(int i = 0; i < 100; i++) {
            testCar.drive(1);
            assertEquals(99 - i, testCar.getDistanceUntilEmpty());
        }
    }

    @Test
    public void testDrive() {
        double initialGas = Car.LITRES_PER_100KM;    // enough to drive 100km
        testCar.addGasToTank(initialGas);

        testCar.drive(20);
        assertEquals(20, testCar.getTripDistance());
        assertEquals(20, testCar.getTotalDistanceTravelled());
        assertEquals(initialGas - 20 / 100.0 * Car.LITRES_PER_100KM, testCar.getGasInTank(), TOL);

        testCar.drive(50);
        assertEquals(70, testCar.getTripDistance());
        assertEquals(70, testCar.getTotalDistanceTravelled());
        assertEquals(initialGas - (20 + 50) / 100.0 * Car.LITRES_PER_100KM, testCar.getGasInTank(), TOL);
    }
}