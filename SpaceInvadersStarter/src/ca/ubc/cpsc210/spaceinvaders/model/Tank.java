package ca.ubc.cpsc210.spaceinvaders.model;

import java.awt.Color;
import java.awt.image.PackedColorModel;

/**
 * Represents a tank
 */
public class Tank {
	
	public static final int SIZE_X = 15;
	public static final int SIZE_Y = 8;
	public static final int DX = 2;
	public static final int Y_POS = SIGame.HEIGHT - 40;
	public static final Color COLOR = new Color(250, 128, 20);

    private int position;
    private boolean facingRight;


	// EFFECTS: places tank at position (x, Y_POS) moving right.
	public Tank(int x) {
        position = x;
        facingRight = true;
		// stub
	}
	
	public int getX() {
		return position;  // stub
	}

    // EFFECTS: returns true if tank is facing right, false otherwise
    public boolean isFacingRight() {
        return facingRight;// stub
    }

	// MODIFIES: this
	// EFFECTS: tank is facing right
	public void faceRight() {
        facingRight = true;

		// stub
	}

	// MODIFIES: this
	// EFFECTS: tank is facing left
	public void faceLeft() {
        facingRight = false;
		// stub
	}

	// MODIFIES: this
	// EFFECTS:  tank is moved DX units in whatever direction it is facing and is
	//           constrained to remain within vertical boundaries of game
    public void move() {
        if (facingRight) {
            position += DX;
        } else {
            position -= DX;
        }
		handleBoundary();
	}

	// MODIFIES: this
	// EFFECTS: tank is constrained to remain within vertical boundaries of game
	private void handleBoundary() {
		if (position > SIGame.WIDTH) {
            position = SIGame.WIDTH;
        } else if (position < 0) {
            position = 0;
        }
;	}
}
