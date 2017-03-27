package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.data.DataCollection;
import com.sun.tools.javac.util.List;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

// Unit tests for DataCollection class
public class DataCollectionTest {
    //TODO: design tests for the DataCollection class
    private DataCollection dc;
    private final static double TOL = 1e-12;


    @Before
    public void setup() {
        dc = new DataCollection();
    }

    @Test
    public void testConstrcutor() {
        assertEquals (0, dc.getNumberOfDataPoints());
    }

    @Test
    public void testAdd() {
        dc.addDataPoint(4);
        dc.addDataPoint(7);
        assertEquals(2, dc.getNumberOfDataPoints());
        assertEquals(5.5, dc.getAverage(), TOL);
        assertEquals(7, dc.getMaximum());
        assertEquals(11, dc.getSumOfPositiveData());
    }
}