package ca.ubc.cpsc210.tpd.figures;

import java.awt.Graphics;
import java.awt.Point;

// Represents a 2-dimensional figure
public interface Figure {

	int getX();

	int getY();

	int getWidth();

	int getHeight();

	// REQUIRES: w >= 0, h >= 0
	// MODIFIES: this
	// EFFECTS: sets width to w and height to h
	void setBounds(int w, int h);
	
	// REQUIRES: bottomRight.x >= getX(), bottomRight.y >= getY()
	// MODIFIES: this
	// EFFECTS: sets width to (bottomRight.x - getX()) 
	//          and height to (bottomRight.y - getY())
	void setBounds(Point bottomRight);

	// MODIFIES: this
	// EFFECTS: figure is shifted dx units horizontally and dy units vertically
	void translate(int dx, int dy);

    // REQUIRES: getWidth() > 0 && getHeight() > 0
	// EFFECTS: returns true if the figure contains given point; false otherwise
	boolean contains(Point p);
    
	// MODIFIES: g
	// EFFECTS: draws the figure on the given graphics object
	void draw(Graphics g);

}