package ca.ubc.cpsc210.tpd.figuretests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.tpd.figures.Rectangle;


public class RectangleTests extends AbstractFigureTests {

    @Before
	public void runBefore() {
		fig = new Rectangle(new Point(2, 3));
	}

    @Test
	public void testContains() {
		fig.setBounds(10, 5);
		assertTrue(fig.contains(new Point(2, 3)));
		assertTrue(fig.contains(new Point(12, 8)));
		assertTrue(fig.contains(new Point(2, 8)));
		assertTrue(fig.contains(new Point(12, 3)));
		assertTrue(fig.contains(new Point(2 + 10 / 2, 3 + 5 / 2)));
        assertFalse(fig.contains(new Point(1, 2)));
        assertFalse(fig.contains(new Point(1, 9)));
        assertFalse(fig.contains(new Point(13, 9)));
        assertFalse(fig.contains(new Point(13, 2)));
	}

}
