package ca.ubc.cpsc210.tpd.figuretests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.tpd.figures.Oval;


public class OvalTests extends FigureTests {
	
	@Before
	public void runBefore() {
		fig = new Oval(new Point(2, 3));
	}

	@Test
	public void testContains() {
		fig.setBounds(10, 4);
		assertTrue(fig.contains(new Point(7, 3)));
		assertTrue(fig.contains(new Point(7, 5)));
		assertTrue(fig.contains(new Point(2, 5)));
		assertTrue(fig.contains(new Point(12, 5)));
		assertTrue(fig.contains(new Point(2 + 10 / 2, 3 + 4 / 2)));
		assertFalse(fig.contains(new Point(2, 3)));
		assertFalse(fig.contains(new Point(12, 3)));
		assertFalse(fig.contains(new Point(2, 8)));
		assertFalse(fig.contains(new Point(12, 8)));
	}
}
