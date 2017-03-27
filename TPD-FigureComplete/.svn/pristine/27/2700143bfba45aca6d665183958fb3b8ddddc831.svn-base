package ca.ubc.cpsc210.tpd.figures;

import java.awt.Point;

public abstract class AbstractFigure implements Figure, Storable {

	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public AbstractFigure(Point start) {
		super();
        x = start.x;
        y = start.y;
        width = 0;
        height = 0;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setBounds(int w, int h) {
		width = w;
		height = h;
	}
	
	@Override
	public void setBounds(Point bottomRight) {
		width = bottomRight.x - x;
		height = bottomRight.y - y;
	}

	@Override
	public void translate(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}
}