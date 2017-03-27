package ca.ubc.cpsc210.spaceinvaders.test;

import static org.junit.Assert.*;

import ca.ubc.cpsc210.spaceinvaders.model.Ufo;
import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.spaceinvaders.model.Missile;
import ca.ubc.cpsc210.spaceinvaders.model.SIGame;

/*
 * Unit tests for the Ufo class.
 */
public class UfoTest {
	private static final int XLOC = SIGame.WIDTH / 2;
	private static final int YLOC = 50;
    private static final int DX = 1;
	private Ufo ufo;
	
	@Before
	public void runBefore() {
		ufo = new Ufo(XLOC, YLOC, DX);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(XLOC, ufo.getX());
        assertEquals(YLOC, ufo.getY());
	}
	
	@Test
	public void testUpdate() {
		final int NUM_UPDATES = 8;
		
		ufo.move();
		assertEquals(YLOC + Ufo.DY, ufo.getY());
        assertEquals(XLOC + ufo.getDx(), ufo.getX());

		for(int count = 1; count < NUM_UPDATES; count++) {
			ufo.move();
		}
		
		assertEquals(YLOC + NUM_UPDATES * Ufo.DY, ufo.getY());
        assertEquals(XLOC + NUM_UPDATES * ufo.getDx(), ufo.getX());
	}
	
	@Test 
	public void testCollideWith() {
		Missile m = new Missile(0, 0);
		assertFalse(ufo.collidedWith(m));
		
		m = new Missile(ufo.getX(), ufo.getY());
		assertTrue(ufo.collidedWith(m));
		
		m = new Missile(ufo.getX() + Ufo.SIZE_X_SAUCER / 2 + Missile.SIZE_X / 2 - 1, ufo.getY());
		assertTrue(ufo.collidedWith(m));
		
		m = new Missile(ufo.getX() + Ufo.SIZE_X_SAUCER / 2 + Missile.SIZE_X / 2 + 1, ufo.getY());
		assertFalse(ufo.collidedWith(m));
		
		m = new Missile(ufo.getX() - Ufo.SIZE_X_SAUCER / 2 - Missile.SIZE_X / 2 + 1, ufo.getY());
		assertTrue(ufo.collidedWith(m));
		
		m = new Missile(ufo.getX() - Ufo.SIZE_X_SAUCER / 2 - Missile.SIZE_X / 2 - 1, ufo.getY());
		assertFalse(ufo.collidedWith(m));
		
		m = new Missile(ufo.getX(), ufo.getY() + Ufo.SIZE_Y_SAUCER / 2 + Missile.SIZE_Y / 2 - 1);
		assertTrue(ufo.collidedWith(m));

		m = new Missile(ufo.getX(), ufo.getY() + Ufo.SIZE_Y_SAUCER / 2 + Missile.SIZE_Y / 2 + 1);
		assertFalse(ufo.collidedWith(m));
	}
	
}
