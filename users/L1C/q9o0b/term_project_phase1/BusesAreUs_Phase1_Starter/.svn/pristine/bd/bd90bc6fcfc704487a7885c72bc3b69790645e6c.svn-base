package ca.ubc.cs.cpsc210.translink.parsers;

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.RoutePattern;
import ca.ubc.cs.cpsc210.translink.parsers.exception.RouteDataMissingException;
import ca.ubc.cs.cpsc210.translink.providers.DataProvider;
import ca.ubc.cs.cpsc210.translink.providers.FileDataProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Parse route information in JSON format.
 */
public class RouteParser {
    private String filename;

    public RouteParser(String filename) {
        this.filename = filename;
    }

    private String name;
    private String RouteNumber;
    private String Destination;
    private String Direction;
    private String PatternNumber;
    private Route r;


    /**
     * Parse route data from the file and add all route to the route manager.
     *
     */
    public void parse() throws IOException, RouteDataMissingException, JSONException{
        DataProvider dataProvider = new FileDataProvider(filename);

        parseRoutes(dataProvider.dataSourceToString());
    }
    /**
     * Parse route information from JSON response produced by Translink.
     * Stores all routes and route patterns found in the RouteManager.
     *
     * @param  jsonResponse    string encoding JSON data to be parsed
     * @throws JSONException   when JSON data does not have expected format
     * @throws RouteDataMissingException when
     * <ul>
     *  <li> JSON data is not an array </li>
     *  <li> JSON data is missing Name, StopNo, Routes or location elements for any stop</li>
     * </ul>
     */

    public void parseRoutes(String jsonResponse)
            throws JSONException, RouteDataMissingException {
        JSONArray Route = new JSONArray(jsonResponse);

        for (int index = 0; index < Route.length(); index++) {
            JSONObject route = Route.getJSONObject(index);
            parseRoute(route);
        }
    }

    public void parseRoute(JSONObject route) throws JSONException, RouteDataMissingException {
        if (!(route.has("RouteNo") && route.has("Name") && route.has("Patterns"))) {
            throw new RouteDataMissingException();
        }

        RouteNumber = route.getString("RouteNo");
            name = route.getString("Name");

            r = new Route(RouteNumber);
            r.setName(name);

            Route currentRoute = RouteManager.getInstance().getRouteWithNumber(RouteNumber, name);


            JSONArray Patterns = route.getJSONArray("Patterns");

            for (int index = 0; index < Patterns.length(); index++) {
                JSONObject patterns = Patterns.getJSONObject(index);
                if (!(patterns.has("Destination") && patterns.has("Direction") && patterns.has("PatternNo"))) {
                    throw new RouteDataMissingException();
                }
                Destination = patterns.getString("Destination");
                Direction = patterns.getString("Direction");
                PatternNumber = patterns.getString("PatternNo");

                RoutePattern rp = currentRoute.getPattern(PatternNumber, Destination, Direction);
            }
    }
}
