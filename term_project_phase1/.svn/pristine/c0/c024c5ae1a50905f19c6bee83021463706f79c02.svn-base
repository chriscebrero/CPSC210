package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.parsers.RouteParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.RouteDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the RouteParser
 */
// TODO: Write more tests

public class TestRouteParser {
    @Before
    public void setup() {

    }

    @Test
    public void testRouteParserNormal() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("allroutes.json");
        p.parse();
        assertEquals(230, RouteManager.getInstance().getNumRoutes());
    }
}
