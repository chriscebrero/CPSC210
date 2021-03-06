package ca.ubc.cpsc210.tpd.figures;

import java.awt.*;

/**
 * Created by Dante on 2016-10-03.
 */
public abstract class Figure {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Figure(Point start) {
        width = 0;
        height = 0;
        x = start.x;
        y = start.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // REQUIRES: w >= 0, h >= 0
    // MODIFIES: this
    // EFFECTS: sets width to w and height to h
    public void setBounds(int w, int h) {
        width = w;
        height = h;
    }

    // REQUIRES: bottomRight.x >= getX(), bottomRight.y >= getY()
    // MODIFIES: this
    // EFFECTS: sets width to (bottomRight.x - getX())
    //          and height to (bottomRight.y - getY())
    public void setBounds(Point bottomRight) {
        width = bottomRight.x - x;
        height = bottomRight.y - y;
    }

    // MODIFIES: this
    // EFFECTS: oval is shifted dx units horizontally and dy units vertically
    public void translate(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    abstract public void draw(Graphics g);
    abstract public boolean contains(Point p);
}
