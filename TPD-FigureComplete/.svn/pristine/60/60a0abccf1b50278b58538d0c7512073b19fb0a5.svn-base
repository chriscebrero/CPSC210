package ca.ubc.cpsc210.tpd.figuretests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.ubc.cpsc210.tpd.figures.Figure;

import java.awt.*;

public abstract class FigureTests {

	protected Figure fig;

    @Test
    public void testConstructor() {
        assertEquals(0, fig.getWidth());
        assertEquals(0, fig.getHeight());
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

	@Test
	public void testSetBounds() {
		fig.setBounds(10, 5);
		assertEquals(10, fig.getWidth());
		assertEquals(5, fig.getHeight());
	}

    @Test
    public void testSetBoundsBottomRight() {
        fig.setBounds(new Point(12, 10));
        assertEquals(10, fig.getWidth());
        assertEquals(7, fig.getHeight());
        assertEquals(2, fig.getX());
        assertEquals(3, fig.getY());
    }
}