package ca.ubc.cpsc210.booleancollection.tests;

import ca.ubc.cpsc210.booleancollection.model.BooleanCollection;

import com.sun.tools.javac.util.List;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;



public class TestBooleanCollection {
    private BooleanCollection bc;

    @Before
    public void setup() {
        bc = new BooleanCollection();
    }

    @Test
    public void testConstrcutor() {
        assertEquals(0, bc.getNumberOfItems());
    }

    @Test
    public void testAdd() {
        bc.add(true);
        bc.add(false);
        bc.add(false);
        bc.add(true);
        assertTrue(bc.get(0));
        assertEquals(4, bc.getNumberOfItems());
        assertFalse(bc.areAllTrue());
        assertEquals(2, bc.countTrue());
        assertFalse(bc.areAllTrueRecursively());
    }

    @Test
    public void testAdd3() {
        assertEquals(0, bc.getNumberOfItems());
        assertTrue(bc.areAllTrue());
        assertEquals(0, bc.countTrue());
        assertTrue(bc.areAllTrueRecursively());
    }
}
