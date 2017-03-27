package ca.ubc.cs.cpsc210.servicecard.tests;

import ca.ubc.cs.cpsc210.servicecard.model.FoodServicesCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// Unit tests for FoodServiceCard class
public class FoodServicesCardTest {
    public static final int INITIAL_BALANCE = 10000;
    private FoodServicesCard testCard;

    @Before
    public void setUp() throws Exception {
        testCard = new FoodServicesCard(INITIAL_BALANCE);
    }

    @Test
    public void testAdd() {
        testCard.reload(500);
        assertEquals(10500, testCard.getBalance());
        assertEquals(0, testCard.getRewardPoints());
        assertFalse(testCard.makePurchase(20000));
        assertTrue(testCard.makePurchase(500));
        assertTrue(testCard.makePurchase(10000));
        assertEquals(50, testCard.getBalance());
        assertEquals(500, testCard.getRewardPoints());
        // template for unit tests
    }

    @Test
    public void testAdd2() {
        testCard.reload(0);
        assertEquals(10000, testCard.getBalance());
        assertEquals(0, testCard.getRewardPoints());
        assertFalse(testCard.makePurchase(100000));
        assertTrue(testCard.makePurchase(3500));
        assertEquals(6510, testCard.getBalance());
        assertEquals(1500, testCard.getRewardPoints());
    }

}