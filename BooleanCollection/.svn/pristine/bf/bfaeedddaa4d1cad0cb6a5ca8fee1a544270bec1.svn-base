package ca.ubc.cpsc210.booleancollection.model;

import java.util.ArrayList;
import java.util.List;


// Represents a collection of boolean data.
public class BooleanCollection {
    private List<Boolean> data;


    // EFFECTS: constructs empty collection of Boolean
    public BooleanCollection() {
        data = new ArrayList<>();
    }

    // EFFECTS: adds boolean to collection
    public void add(boolean bl) {
        data.add(bl);
    }

    // MODIFIES: this
    // REQUIRES: the index must be greater or equal to zero and less than the number of items in the collection
    // EFFECTS: the value of the item in the collection at the given index
    public Boolean get(int i) {
        return data.get(i);
    }

    // EFFECTS: the number of booleans in the collection
    public int getNumberOfItems() {
        int accum = 0;
        for (boolean item : data) {
            accum++;
        }
        return accum;
    }

    // EFFECTS: true if all the booleans in the collection are true, false otherwise
    public Boolean areAllTrue() {
        for (boolean item : data) {
            if (! item) {
                return false;
            }
        }
        return true;
    }

    // EFFECTS: count the number of booleans in the collection that are true
    public int countTrue() {
        int accum = 0;
        for (boolean item : data) {
            if (item) {
                accum++;
            }
        }
        return accum;
    }

    private boolean empty(List<Boolean> list) {
        return list.size() == 0;
    }

    private boolean first(List<Boolean> list) {
        return list.get(0);
    }

    private List<Boolean> rest(List<Boolean> list) {
        return list.subList(1, list.size());
    }

    public boolean areAllTrueRecursively() {
        return areAllTrueRecursivelyHelper(data);
    }

    private boolean areAllTrueRecursivelyHelper(List<Boolean> list) {
        if (empty(list))
            return true;
        else if (first(list))
            return areAllTrueRecursivelyHelper(rest(list));
        else
            return false;
    }
}