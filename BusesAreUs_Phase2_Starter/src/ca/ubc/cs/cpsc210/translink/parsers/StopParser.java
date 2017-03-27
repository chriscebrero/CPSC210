package ca.ubc.cs.cpsc210.translink.parsers;

import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.parsers.exception.StopDataMissingException;
import ca.ubc.cs.cpsc210.translink.providers.DataProvider;
import ca.ubc.cs.cpsc210.translink.providers.FileDataProvider;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * A parser for the data returned by Translink stops query
 */
public class StopParser {

    private String filename;

    public StopParser(String filename) {
        this.filename = filename;
    }
    /**
     * Parse stop data from the file and add all stops to stop manager.
     *
     */
    public void parse() throws IOException, StopDataMissingException, JSONException{
        DataProvider dataProvider = new FileDataProvider(filename);

        parseStops(dataProvider.dataSourceToString());
    }
    /**
     * Parse stop information from JSON response produced by Translink.
     * Stores all stops and routes found in the StopManager and RouteManager.
     *
     * @param  jsonResponse    string encoding JSON data to be parsed
     * @throws JSONException   when JSON data does not have expected format
     * @throws StopDataMissingException when
     * <ul>
     *  <li> JSON data is not an array </li>
     *  <li> JSON data is missing Name, StopNo, Routes or location (Latitude or Longitude) elements for any stop</li>
     * </ul>
     */

    public void parseStops(String jsonResponse)
            throws JSONException, StopDataMissingException {
        JSONArray Stop = new JSONArray(jsonResponse);

        for (int index = 0; index < Stop.length(); index++) {
            JSONObject stop = Stop.getJSONObject(index);
            parseStop(stop);
        }
    }

    public void parseStop(JSONObject stop) throws JSONException, StopDataMissingException {
        if (stop.has("StopNo") && stop.has("Name") && stop.has("Latitude") && stop.has("Longitude") && stop.has("Routes")) {
            Integer StopNumber = stop.getInt("StopNo");
            String name = stop.getString("Name");
            Double lat = stop.getDouble("Latitude");
            Double lon = stop.getDouble("Longitude");
            LatLon latlon = new LatLon(lat, lon);
            String[] routes = stop.getString("Routes").split(", ");
            Stop s = StopManager.getInstance().getStopWithId(StopNumber, name, new LatLon(lat, lon));
            for (String r : routes) {
                s.addRoute(RouteManager.getInstance().getRouteWithNumber(r));
            }
        } else {
            throw new StopDataMissingException();
        }
    }
}
