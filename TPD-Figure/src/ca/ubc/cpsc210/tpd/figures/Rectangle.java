package ca.ubc.cpsc210.tpd.figures;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Figure{
	
	// EFFECTS: rectangle has zero width and height and is at position start
	public Rectangle(Point start) {
		super(start);
	}

    // REQUIRES: getWidth() > 0 && getHeight() > 0
	// EFFECTS: returns true if rectangle contains given point; false otherwise
	public boolean contains(Point p) {
		return x <= p.x && p.x <= x + width
					&& y <= p.y && p.y <= y + height;
	}
	
	// MODIFIES: g
	// EFFECTS: draws the rectangle on the given graphics object
	public void draw(Graphics g) {
		g.drawRect(x, y, x + width, y + height);
	}
}
