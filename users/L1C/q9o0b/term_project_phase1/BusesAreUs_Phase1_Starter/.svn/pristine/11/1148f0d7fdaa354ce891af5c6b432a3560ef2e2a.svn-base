package ca.ubc.cs.cpsc210.translink.tests.model;

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.RoutePattern;
import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test the RouteManager
 */
public class TestRouteManager {

    @Before
    public void setup() {
        RouteManager.getInstance().clearRoutes();
    }

    @Test
    public void testBoring() {
        LatLon l1 = new LatLon(45, 45);
        Route r43 = new Route("43");
        Route r44 = new Route("44");
        Stop fstop = new Stop(1, "first stop", l1);
        Route r = RouteManager.getInstance().getRouteWithNumber("43");
        assertEquals("43", r43.getNumber());
        r43.setName("flash");
        assertEquals("flash", r43.getName());
        r43.addStop(fstop);
        List<Stop> stops;
        stops = new LinkedList<>();
        stops.add(fstop);
        assertEquals(stops, r43.getStops());
        assertEquals(r43, r);
        Stop sstop = new Stop(2, "second stop", l1);
        stops.add(sstop);
        r43.addStop(sstop);
        assertEquals(stops, r43.getStops());
        assertTrue(r43.hasStop(fstop));
        r43.removeStop(sstop);
        assertFalse(r43.hasStop(sstop));
        RoutePattern routePattern1 = new RoutePattern("lightning", "start", "end", r44);
        r43.addPattern(routePattern1);
        assertEquals("lightning", routePattern1.getName());
        assertEquals("end", routePattern1.getDirection());
        assertEquals("start", routePattern1.getDestination());
        List<RoutePattern> routePatterns;
        routePatterns = new LinkedList<>();
        routePatterns.add(routePattern1);
        assertEquals(routePatterns, r43.getPatterns());
        assertEquals(routePattern1, r43.getPattern("lightning"));
        RoutePattern routePattern2 = new RoutePattern("lightning2", "", "", r43);
        assertEquals(routePattern2, r43.getPattern("lightning2"));
        assertEquals(routePattern1, r43.getPattern("lightning", "start", "end"));
        RoutePattern routePattern3 = new RoutePattern("lightning3", "start", "end", r43);
        assertEquals(routePattern3, r43.getPattern("lightning3", "start", "end"));
        List<LatLon> ls;
        ls = new LinkedList<>();
        ls.add(l1);
        routePattern1.setPath(ls);
        assertEquals(ls, routePattern1.getPath());
        routePattern1.setDestination("maybe");
        assertEquals("maybe", routePattern1.getDestination());
        routePattern1.setDirection("ofcourse");
        assertEquals("ofcourse", routePattern1.getDirection());
    }

    @Test
    public void testgetRoutewithNumber() {
        Route r1 = new Route("1");
        assertEquals(r1, RouteManager.getInstance().getRouteWithNumber("1"));
        assertEquals(1, RouteManager.getInstance().getNumRoutes());
        assertEquals(r1, RouteManager.getInstance().getRouteWithNumber("1"));
        assertEquals(1, RouteManager.getInstance().getNumRoutes());
        Route r2 = new Route("2");
        r2.setName("flash");
        assertEquals(r2, RouteManager.getInstance().getRouteWithNumber("2", "flash"));
        assertEquals(2, RouteManager.getInstance().getNumRoutes());
        assertEquals(r2, RouteManager.getInstance().getRouteWithNumber("2"));
        assertEquals(2, RouteManager.getInstance().getNumRoutes());
        assertEquals(r2, RouteManager.getInstance().getRouteWithNumber("2", "flash"));
        assertEquals(2, RouteManager.getInstance().getNumRoutes());
    }

    @Test
    public void testgetRoutewithNumber1() {
        Route r2 = new Route("2");
        r2.setName("flash");
        assertEquals(r2, RouteManager.getInstance().getRouteWithNumber("2", "flash"));
    }
}
