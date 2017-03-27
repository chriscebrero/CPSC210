package ca.ubc.cpsc210.spaceinvaders.model;

import java.awt.Color;

/**
 * Represents a tank
 */
public class Tank {
	
	public static final int SIZE_X = 30;
	public static final int SIZE_Y = 10;
    public static final int BODY_SIZE_X = 20;
    public static final int BODY_SIZE_Y = 10;
    public static final int GUN_SIZE_X = 5;
    public static final int GUN_SIZE_Y = 10;
	public static final int Y_POS = SIGame.HEIGHT - SIZE_Y / 2;
	public static final Color BODYCOLOR = Color.BLACK;
    public static final Color TREADCOLOR = new Color(0, 160, 51);

    // TODO: add variables to hold the tank state

	// EFFECTS: places tank at position (x, Y_POS) moving according to dx.
	public Tank(int x, int dx) {
	    // stub
	}
	
	public int getX() {
		return 0;  // stub
	}

    public int getDx() {
        return 0;  // stub
    }

    // EFFECTS: returns true if tank is facing right, false otherwise
    public boolean isFacingRight() {
        return false;  // stub
    }

	// MODIFIES: this
	// EFFECTS: tank is facing right
	public void faceRight() {
		// stub
	}

	// MODIFIES: this
	// EFFECTS: tank is facing left
	public void faceLeft() {
		// stub
	}

	// MODIFIES: this
	// EFFECTS:  tank is moved DX units in whatever direction it is facing and is
	//           constrained to remain within vertical boundaries of game
    public void move() {
		// stub
	}

	// MODIFIES: this
	// EFFECTS: tank is constrained to remain within vertical boundaries of game
	private void handleBoundary() {
		// stub
	}
}
