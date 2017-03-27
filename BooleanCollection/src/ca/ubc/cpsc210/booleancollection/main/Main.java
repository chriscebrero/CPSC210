package ca.ubc.cpsc210.booleancollection.main;
import java.util.Scanner;

import ca.ubc.cpsc210.booleancollection.model.BooleanCollection;

/**
 * An essentially useless Main class, that just prints a boring message
 */
public class Main {
    public static void main(String[] args) {

        double range;
        double initialVelocity;
        double angleOfElevation;
        double GRAV_ACCEL = 9.81;

        Scanner dante = new Scanner(System.in);

        System.out.println("Enter Initial Velocity");
        initialVelocity = dante.nextDouble();

        System.out.println("Enter angle of elevation");
        angleOfElevation = dante.nextDouble();

        range = (initialVelocity * initialVelocity) / GRAV_ACCEL * Math.sin(2 * angleOfElevation);

        System.out.println("Range:" + range + "metres/n");

    }
}
