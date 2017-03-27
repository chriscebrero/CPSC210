package ca.ubc.cs.cpsc210.integerset.test;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Unit tests for IntegerSet class
 */
public class IntegerSetTest {
    private static final int NUMITEMS = 5000;
    private IntegerSetTest IST;

    @Before
    public void setup() {
        IST = new integerSet();
    };
}