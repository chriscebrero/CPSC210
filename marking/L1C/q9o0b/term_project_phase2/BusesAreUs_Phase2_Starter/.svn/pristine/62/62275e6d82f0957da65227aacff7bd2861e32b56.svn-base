package ca.ubc.cs.cpsc210.translink.util;

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
        Boolean answer;
        double lat1 = northWest.getLatitude();
        double lat2 = southEast.getLatitude();
        double lon1 = northWest.getLongitude();
        double lon2 = southEast.getLongitude();
        double lat = point.getLatitude();
        double lon = point.getLongitude();

        if (lat1 >= lat2) {
            answer = between(lat2, lat1, lat);
        } else {
            answer = between(lat1, lat2, lat);
        }

        if (lon1 >= lon2) {
            answer = between(lon2, lon1, lon);
        } else  {
            answer = between(lon1, lon2, lon);
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
        boolean output = false;
        if (!(((GetLat(northWest, src, dst) <= northWest.getLongitude()) && (GetLat(southEast, src, dst) <= southEast.getLongitude())) ||
                ((GetLat(southEast, src, dst) >= southEast.getLongitude()) && (GetLat(northWest, src, dst) >= northWest.getLongitude())))){
            output = true;
        }
        if (rectangleContainsPoint(northWest, southEast, src) || (rectangleContainsPoint(northWest, southEast, dst))) {
            output = true;
        }
        return output;
    }

    private static double GetLat(LatLon point, LatLon src, LatLon dst){
        double slope = (src.getLatitude() - dst.getLongitude()) / (src.getLongitude() - dst.getLongitude());
        double newLat = ((point.getLatitude() - src.getLatitude()) / slope) + src.getLatitude();

        return newLat;
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
