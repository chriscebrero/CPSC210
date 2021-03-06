package ca.ubc.cs.cpsc210.translink.parsers;

import ca.ubc.cs.cpsc210.translink.model.Arrival;
import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.parsers.exception.ArrivalsDataMissingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A parser for the data returned by the Translink arrivals at a stop query
 */
public class ArrivalsParser {

    /**
     * Parse arrivals from JSON response produced by TransLink query.  All parsed arrivals are
     * added to the given stop assuming that corresponding JSON object has a RouteNo: and an
     * array of Schedules:
     * Each schedule must have an ExpectedCountdown, ScheduleStatus, and Destination.  If
     * any of the aforementioned elements is missing, the arrival is not added to the stop.
     *
     * @param stop         stop to which parsed arrivals are to be added
     * @param jsonResponse the JSON response produced by Translink
     * @throws JSONException                when JSON response does not have expected format
     * @throws ArrivalsDataMissingException when no arrivals are found in the reply
     */
    public static void parseArrivals(Stop stop, String jsonResponse)
            throws JSONException, ArrivalsDataMissingException {
        List<Arrival> ArrivalList = new ArrayList<>();
        JSONArray Arrivals = new JSONArray(jsonResponse);

        for (int index = 0; index < Arrivals.length(); index++) {
            JSONObject Arrival = Arrivals.getJSONObject(index);
            parseArrival(stop, Arrival, ArrivalList);
        }

        if (ArrivalList.size() == 0) {
            throw new ArrivalsDataMissingException();
        }
    }

    public static void parseArrival(Stop stop, JSONObject Arrival, List<Arrival> ArrivalList) throws JSONException, ArrivalsDataMissingException {
        if ((Arrival.has("RouteNo") && Arrival.has("RouteName") && Arrival.has("Schedules"))) {
            String RouteNo = Arrival.getString("RouteNo");
            String RouteName = Arrival.getString("RouteName");
            Route r = RouteManager.getInstance().getRouteWithNumber(RouteNo, RouteName);

            JSONArray Schedules = Arrival.getJSONArray("Schedules");

            List<Arrival> arrivalList2;
            arrivalList2 = parseListOfArrivals(r, Schedules);

            for (Arrival a : arrivalList2) {
                stop.addArrival(a);
                ArrivalList.add(a);
            }
        }
    }

    public static List<Arrival> parseListOfArrivals(Route route, JSONArray Schedule) throws JSONException, ArrivalsDataMissingException{
        List<Arrival> arrivalList = new ArrayList<>();

        for (int index = 0; index < Schedule.length(); index++) {
            JSONObject Schedules = Schedule.getJSONObject(index);
            if (! (parseSchedule(route, Schedules) == null)) {
                arrivalList.add(parseSchedule(route, Schedules));
            }
        }
        return arrivalList;
    }

    public static Arrival parseSchedule(Route route, JSONObject Schedule) throws JSONException, ArrivalsDataMissingException {
        if (!(Schedule.has("Destination") && Schedule.has("ExpectedCountdown") && Schedule.has("ScheduleStatus"))) {
            throw new ArrivalsDataMissingException();
        }
        String Destination = Schedule.getString("Destination");
        int ExpectedCountDown = Schedule.getInt("ExpectedCountdown");
        String ScheduleStatus = Schedule.getString("ScheduleStatus");

        Arrival a = new Arrival(ExpectedCountDown, Destination, route);
        a.setStatus(ScheduleStatus);
        return a;
    }
}
