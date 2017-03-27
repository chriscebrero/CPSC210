package ca.ubc.cs.cpsc210.translink.tests.Util;

import ca.ubc.cs.cpsc210.translink.util.Geometry;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dante on 2016-11-14.
 */
public class TestGeometry {

    @Before
    public void setup() {
    }

    @Test
    public void testpoint() {
        assertTrue(Geometry.rectangleContainsPoint(new LatLon(0, 10), new LatLon(7, 0), new LatLon(5, 5)));
        assertTrue(Geometry.rectangleContainsPoint(new LatLon(0, 0), new LatLon(7, 7), new LatLon(5, 5)));
        assertFalse(Geometry.rectangleContainsPoint(new LatLon(0, 0), new LatLon(3, 3), new LatLon(5, 5)));
        assertFalse(Geometry.rectangleContainsPoint(new LatLon(9, 0), new LatLon(3, 3), new LatLon(5, 5)));
    }
}
