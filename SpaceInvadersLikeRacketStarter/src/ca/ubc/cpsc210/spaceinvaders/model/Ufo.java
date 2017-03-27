package ca.ubc.cpsc210.spaceinvaders.model;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * Represents a space invader.
 */
public class Ufo {
	
	public static final int DY = 1;
	public static final Color COLOR = Color.BLUE;
    public static final int SIZE_X_SAUCER = 20;
    public static final int SIZE_Y_SAUCER = 10;
    public static final int SIZE_X_COCKPIT = 10;
    public static final int SIZE_Y_COCKPIT = 15;

    private int x;
	private int y;
    private int dx;

	// EFFECTS: invader is positioned at coordinates (x, y)
	public Ufo(int x, int y, int dx) {
		this.x = x;
		this.y = y;
        this.dx = dx;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

    public int getDx() {
        return dx;
    }

    // MODIFIES: this
	// EFFECTS:  invader is moved down the screen SPEED units and randomly takes
	//           a step of size no greater than JIGGLE_X to the left or right
	public void move() {
		x = x + dx;
		y = y + DY;
		
		handleBoundary();
	}

	// MODIFIES: none
	// EFFECTS:  returns true if this invader has collided with missile m,
	//           false otherwise
	public boolean collidedWith(Missile m) {
		Rectangle invaderBoundingRect = new Rectangle(getX() - SIZE_X_SAUCER / 2, getY() - SIZE_Y_SAUCER / 2, SIZE_X_SAUCER, SIZE_Y_SAUCER);
		Rectangle missileBoundingRect = new Rectangle(m.getX() - Missile.SIZE_X / 2, m.getY() - Missile.SIZE_Y/ 2,
				Missile.SIZE_X, Missile.SIZE_Y);
		return invaderBoundingRect.intersects(missileBoundingRect);
	}

	// MODIFIES: this
	// EFFECTS: tank is constrained to remain within horizontal boundaries of game
	private void handleBoundary() {
		if (x < 0) {
            x = 0;
            dx = -dx;
        } else if (x > SIGame.WIDTH) {
            x = SIGame.WIDTH;
            dx = -dx;
        }
	}
}
