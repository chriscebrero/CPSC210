package ca.ubc.cpsc210.tpd.figures;

import javax.json.JsonObject;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;

public class Rectangle extends AbstractFigure {
	// Constructs a rectangle
	// EFFECTS: rectangle has zero width and height and is at position start
	public Rectangle(Point start) {
		super(start);
	}
	
	@Override
	public boolean contains(Point p) {
		return x <= p.x && p.x <= x + width
					&& y <= p.y && p.y <= y + height;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(x, y, x + width, y + height);
	}

    @Override
    public void read(File f) {
        // stub
    }

    @Override
    public void write(File f) {
        // stub
    }
}
