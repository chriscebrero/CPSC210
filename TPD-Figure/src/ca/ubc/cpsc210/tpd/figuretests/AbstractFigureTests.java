package ca.ubc.cpsc210.tpd.figuretests;

import ca.ubc.cpsc210.tpd.figures.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dante on 2016-10-05.
 */
public abstract class AbstractFigureTests {
    protected Figure fig;

    @Test
    public void testConstructor() {
        assertEquals(0, fig.getWidth());
        assertEquals(0, fig.getHeight());
        assertEquals(2, fig.getX());
        assertEquals(3, fig.getY());
    }

    @Test
    public void testSetBounds() {
        fig.setBounds(10, 7);
        assertEquals(10, fig.getWidth());
        assertEquals(7, fig.getHeight());
        assertEquals(2, fig.getX());
        assertEquals(3, fig.getY());
    }

    @Test
public void testSetBoundsBottomRight() {
        fig.setBounds(new Point(12, 10));
assertEquals(10, fig.getWidth());
assertEquals(7, fig.getHeight());
assertEquals(2, fig.getX());
assertEquals(3, fig.getY());
}

    @Test
    public void testTranslate() {
        fig.setBounds(10, 5);
        fig.translate(4, -2);
        assertEquals(10, fig.getWidth());
        assertEquals(5, fig.getHeight());
        assertEquals(6, fig.getX());
        assertEquals(1, fig.getY());
    }
}
