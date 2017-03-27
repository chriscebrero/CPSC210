package ca.ubc.cpsc210.tpd.figures;

import java.awt.Point;

// NOTE to CPSC 210 Students:  this is an example
// of what NOT to do!
public class Square extends Rectangle {

	public Square(Point start) {
		super(start);
	}

	// NOTE to CPSC 210 Students: here's where things go wrong.
	// We restrict the behaviour of the supertype.  We cannot
	// substitute a Square for a Rectangle.  Square is therefore
	// not a subtype of Rectangle.  In the method that follows,
	// we've strengthened the precondition specified on the
	// setBounds method inherited from a superclass.
	
	// set bounds of figure
	// REQUIRES: w >= 0, h >= 0, w == h
	// MODIFIES: this
	// EFFECTS: sets width to w and height to h
	// NOTE: REALLY BAD: violates LSP, precondition is STRENGTHENED
	@Override
	public void setBounds(int w, int h) {
		super.setBounds(w, h);
	}
}
