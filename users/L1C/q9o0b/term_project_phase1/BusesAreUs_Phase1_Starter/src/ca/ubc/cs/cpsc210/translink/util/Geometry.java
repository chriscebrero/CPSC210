package ca.ubc.cs.cpsc210.translink.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Compute relationships between points, lines, and rectangles represented by LatLon objects
 */
public class Geometry {
    /**
     * Return true if the point is inside of, or on the boundary of, the rectangle formed by northWest and southeast
     * @param northWest         the coordinate of the north west corner of the rectangle
     * @param southEast         the coordinate of the south east corner of the rectangle
     * @param point             the point in question
     * @return                  true if the point is on the boundary or inside the rectangle
     */
    public static boolean rectangleContainsPoint(LatLon northWest, LatLon southEast, LatLon point) {
        // TODO: Task 5: Implement this method
        List<Boolean> booleans = new ArrayList<>();
        Boolean answer = true;
        double lat1 = northWest.getLatitude();
        double lat2 = southEast.getLatitude();
        double lon1 = northWest.getLongitude();
        double lon2 = southEast.getLongitude();
        double lat = point.getLatitude();
        double lon = point.getLongitude();

        if (lat1 >= lat2) {
            booleans.add(between(lat2, lat1, lat));
        } else {
            booleans.add(between(lat1, lat2, lat));
        }

        if (lon1 >= lon2) {
            booleans.add(between(lon2, lon1, lon));
        } else  {
            booleans.add(between(lon1, lon2, lon));
        }

        for (Boolean b : booleans) {
            if (!b) {
                answer = false;
            }
        }
        return answer;
    }

    /**
     * Return true if the rectangle intersects the line
     * @param northWest         the coordinate of the north west corner of the rectangle
     * @param southEast         the coordinate of the south east corner of the rectangle
     * @param src               one end of the line in question
     * @param dst               the other end of the line in question
     * @return                  true if any point on the line is on the boundary or inside the rectangle
     */
    public static boolean rectangleIntersectsLine(LatLon northWest, LatLon southEast, LatLon src, LatLon dst) {
        double lat1 = src.getLatitude();
        double lat2 = dst.getLatitude();
        double lon1 = src.getLongitude();
        double lon2 = dst.getLongitude();
        if (lat1 >= lat2 && lon1 >= lon2) {
            for ()
        }
        return true;
    }

    /**
     * A utility method that you might find helpful in implementing the two previous methods
     * Return true if x is >= lwb and <= upb
     * @param lwb      the lower boundary
     * @param upb      the upper boundary
     * @param x         the value in question
     * @return          true if x is >= lwb and <= upb
     */
    private static boolean between(double lwb, double upb, double x) {
        return lwb <= x && x <= upb;
    }
}
