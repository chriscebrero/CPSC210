package ca.ubc.cpsc210.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.bank.RobustAccount;
import ca.ubc.cpsc210.bank.exceptions.IllegalValueException;
import ca.ubc.cpsc210.bank.exceptions.NotEnoughMoneyException;

/*
 * NOTE: this is not a complete test suite.  It serves
 * only to illustrate how to test that a method
 * throws an exception of a particular type and how
 * to design test methods that catch exceptions.
 */
public class RobustAccountTests {
	private static final double DELTA = 0.00001;
	private RobustAccount a;
	
	@Before
	public void beforeEachTest() throws IllegalValueException {
		a = new RobustAccount("Joe", 100.0);
	}
	
	@Test (expected = IllegalValueException.class)
	public void testBadNew() throws IllegalValueException {
		RobustAccount ra = new RobustAccount("", 0.0);
	}
	
	@Test
	public void testGoodNew() throws IllegalValueException {
		RobustAccount ra = new RobustAccount("a", 0.0);
		assertNotNull(ra);
	}
	
	@Test (expected = NotEnoughMoneyException.class)
	public void withdrawTooMuchMoney() 
			throws IllegalValueException, NotEnoughMoneyException {
		a.withdraw(101.50);
	}
	
	@Test (expected = IllegalValueException.class)
	public void withdrawNegativeAmount() 
			throws IllegalValueException, NotEnoughMoneyException {
		a.withdraw(-100.0);
	}

    @Test
    public void testValidWithdraw() throws IllegalValueException, NotEnoughMoneyException {
        assertEquals(90.0, a.withdraw(10.0), DELTA);
    }
	
    @Test
    public void callWithdrawMoney() {
        try {
            withdrawMoney(101.50);
            System.out.println("Yay, I withdrew too much money and got away with it!");
            fail("Shouldn't have got to this point!");
        } catch (IllegalValueException e) {
            System.out.println("IllegalValueException:  " + e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println("NotEnoughMoneyException:  " + e.getMessage());
        } finally {
            System.out.println("callWithdrawMoney:  Should print EVERY time, no matter what!");
        }
    }
    
    public void withdrawMoney(double amount) throws IllegalValueException, NotEnoughMoneyException {
        try {
            a.withdraw(amount);
        } finally {
            System.out.println("withdrawMoney:  Should print EVERY time, no matter what!");
        }
    }
}
