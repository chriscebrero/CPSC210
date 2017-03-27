package ca.ubc.cs.cpsc210.machine.test;

import ca.ubc.cs.cpsc210.machine.model.Coin;
import ca.ubc.cs.cpsc210.machine.model.PaymentUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import static junit.framework.TestCase.assertEquals;

public class PaymentUnitTest {
    private PaymentUnit paymentUnit;
    private List<Coin> Comparision;

    @Before
    public void setUp() {
        paymentUnit = new PaymentUnit();
    }

    @Test
    public void testPayment1() {
        paymentUnit.addCoinsToBanked(Coin.LOONIE, 5);
        paymentUnit.addCoinsToBanked(Coin.QUARTER, 3);
        paymentUnit.addCoinsToBanked(Coin.DIME, 8);
        paymentUnit.addCoinsToBanked(Coin.NICKEL, 1);
        assertEquals(5, paymentUnit.getNumberOfCoinsBankedOfType(Coin.LOONIE));
        assertEquals(3, paymentUnit.getNumberOfCoinsBankedOfType(Coin.QUARTER));
        assertEquals(8, paymentUnit.getNumberOfCoinsBankedOfType(Coin.DIME));
        assertEquals(1, paymentUnit.getNumberOfCoinsBankedOfType(Coin.NICKEL));
        assertEquals(660, paymentUnit.getValueOfCoinsBanked());
        paymentUnit.clearCoinsBanked();
        assertEquals(0, paymentUnit.getNumberOfCoinsBankedOfType(Coin.LOONIE));
        assertEquals(0, paymentUnit.getNumberOfCoinsBankedOfType(Coin.QUARTER));
        assertEquals(0, paymentUnit.getNumberOfCoinsBankedOfType(Coin.DIME));
        assertEquals(0, paymentUnit.getNumberOfCoinsBankedOfType(Coin.NICKEL));
    }

    @Test
    public void testPayment2() {
        paymentUnit.addCoinsToBanked(Coin.LOONIE, 100);
        paymentUnit.addCoinsToBanked(Coin.QUARTER, 100);
        paymentUnit.addCoinsToBanked(Coin.DIME, 100);
        paymentUnit.addCoinsToBanked(Coin.NICKEL, 100);
        assertEquals(100, paymentUnit.getNumberOfCoinsBankedOfType(Coin.LOONIE));
        assertEquals(100, paymentUnit.getNumberOfCoinsBankedOfType(Coin.QUARTER));
        assertEquals(100, paymentUnit.getNumberOfCoinsBankedOfType(Coin.DIME));
        assertEquals(100, paymentUnit.getNumberOfCoinsBankedOfType(Coin.NICKEL));
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.DIME);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.QUARTER);
        paymentUnit.insertCoin(Coin.NICKEL);
        assertEquals(240, paymentUnit.getValueOfCoinsInserted());
        Comparision = new ArrayList<>();
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.DIME);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.QUARTER);
        Comparision.add(Coin.NICKEL);
        assertEquals(Comparision, paymentUnit.cancelTransaction());
    }

    @Test
    public void testPayment3() {
        paymentUnit.addCoinsToBanked(Coin.LOONIE, 100);
        paymentUnit.addCoinsToBanked(Coin.QUARTER, 100);
        paymentUnit.addCoinsToBanked(Coin.DIME, 100);
        paymentUnit.addCoinsToBanked(Coin.NICKEL, 100);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.DIME);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.QUARTER);
        paymentUnit.insertCoin(Coin.NICKEL);
        assertEquals(240, paymentUnit.getValueOfCoinsInserted());
        Comparision = new ArrayList<>();
        Comparision.add(Coin.LOONIE);
        assertEquals(Comparision, paymentUnit.makePurchase(140));

    }

    @Test
    public void testPayment4() {
        paymentUnit.addCoinsToBanked(Coin.LOONIE, 1);
        paymentUnit.addCoinsToBanked(Coin.QUARTER, 1);
        paymentUnit.addCoinsToBanked(Coin.DIME, 1);
        paymentUnit.addCoinsToBanked(Coin.NICKEL, 100);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.DIME);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.QUARTER);
        paymentUnit.insertCoin(Coin.NICKEL);
        assertEquals(240, paymentUnit.getValueOfCoinsInserted());
        Comparision = new ArrayList<>();
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.QUARTER);
        Comparision.add(Coin.QUARTER);
        assertEquals(Comparision, paymentUnit.makePurchase(90));
        assertEquals(0, paymentUnit.getValueOfCoinsInserted());
    }

    @Test
    public void testPayment5() {
        paymentUnit.addCoinsToBanked(Coin.LOONIE, 1);
        paymentUnit.addCoinsToBanked(Coin.QUARTER, 1);
        paymentUnit.addCoinsToBanked(Coin.DIME, 100);
        paymentUnit.addCoinsToBanked(Coin.NICKEL, 0);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.DIME);
        paymentUnit.insertCoin(Coin.QUARTER);
        paymentUnit.insertCoin(Coin.NICKEL);
        assertEquals(140, paymentUnit.getValueOfCoinsInserted());
        Comparision = new ArrayList<>();
        Comparision.add(Coin.DIME);
        Comparision.add(Coin.NICKEL);
        assertEquals(Comparision, paymentUnit.makePurchase(125));
        assertEquals(0, paymentUnit.getValueOfCoinsInserted());
    }

    @Test
    public void testPayment6() {
        paymentUnit.addCoinsToBanked(Coin.LOONIE, 1);
        paymentUnit.addCoinsToBanked(Coin.QUARTER, 1);
        paymentUnit.addCoinsToBanked(Coin.DIME, 100);
        paymentUnit.addCoinsToBanked(Coin.NICKEL, 0);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.DIME);
        paymentUnit.insertCoin(Coin.QUARTER);
        paymentUnit.insertCoin(Coin.NICKEL);
        assertEquals(140, paymentUnit.getValueOfCoinsInserted());
        Comparision = new ArrayList<>();
        assertEquals(Comparision, paymentUnit.makePurchase(140));
        assertEquals(0, paymentUnit.getValueOfCoinsInserted());
    }

    @Test
    public void testPayment7() {
        paymentUnit.addCoinsToBanked(Coin.LOONIE, 0);
        paymentUnit.addCoinsToBanked(Coin.QUARTER, 10);
        paymentUnit.addCoinsToBanked(Coin.DIME, 100);
        paymentUnit.addCoinsToBanked(Coin.NICKEL, 0);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.DIME);
        paymentUnit.insertCoin(Coin.QUARTER);
        paymentUnit.insertCoin(Coin.NICKEL);
        assertEquals(140, paymentUnit.getValueOfCoinsInserted());
        Comparision = new ArrayList<>();
        Comparision.add(Coin.LOONIE);
        assertEquals(Comparision, paymentUnit.makePurchase(40));
        assertEquals(0, paymentUnit.getValueOfCoinsInserted());
    }

    @Test
    public void testPayment8() {
        paymentUnit.addCoinsToBanked(Coin.LOONIE, 100);
        paymentUnit.addCoinsToBanked(Coin.QUARTER, 10);
        paymentUnit.addCoinsToBanked(Coin.DIME, 100);
        paymentUnit.addCoinsToBanked(Coin.NICKEL, 0);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.DIME);
        paymentUnit.insertCoin(Coin.QUARTER);
        paymentUnit.insertCoin(Coin.NICKEL);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.LOONIE);
        paymentUnit.insertCoin(Coin.LOONIE);
        assertEquals(1040, paymentUnit.getValueOfCoinsInserted());
        Comparision = new ArrayList<>();
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        Comparision.add(Coin.LOONIE);
        assertEquals(Comparision, paymentUnit.makePurchase(40));
        assertEquals(0, paymentUnit.getValueOfCoinsInserted());
    }
}
