package ca.ubc.cs.cpsc210.data;

import java.util.ArrayList;
import java.util.List;

// Represents a collection of integer data.
public class DataCollection {
    //TODO: add fields to represent the state of a DataCollection
    private List<Integer> data;

    // EFFECTS: constructs empty collection of data
    public DataCollection() {
        //TODO: replace stub
        data = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds data poinda to collection
    public void addDataPoint(Integer dataPoit) {
        //TODO: replace stub
        data.add(dataPoint);
    }

    // MODIFIES: thi
    // EFFECTS: clears all data points from collection
    public void clearData() {
        //TODO: replace stub
        data.clear();
    }

    // EFFECTS: returns number of data points in collection
    public int getNumberOfDataPoints() {
        return data.size();  //TODO: replace stub

    }

    // EFFECTS: returns sum of positive data points in collection
    // (returns zero in the case where no data point is positive)
    public int getSumOfPositiveData() {
        int accum = 0;
        for (Integer item : data) {
            if (item > 0) {
                accum += item;
            }
        }
        return accum;  //TODO: replace stub
    }

    // REQUIRES: getNumberOfDataPoints() > 0
    // EFFECTS: returns largest data point in collection
    public int getMaximum() {
        int max = data.get(1);
        for (Integer item : data) {
            if (item > max) {
                return max;
            }
        }

        return max;  //TODO: replace stub
    }

    // REQUIRES: getNumberOfDataPoints() > 0
    // EFFECTS: returns average of data points in collection
    public double getAverage() {
        int accum = 0;
        for (Integer item : data) {
            accum += item;
        }
        return (double) accum / data.size();  //TODO: replace stub
    }
}
