package ca.ubc.cs.cpsc210.integerset.model;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;

/*
 * Represents a set of integers
 */
public class IntegerSet {
    private List<Integer> data;

    // EFFECTS: make an empty set
    public IntegerSet() {
        data = new ArrayList<>();

    }

    // EFFECTS: return the number of integers in the set
    public int size () {
        return data.size();

    }

    // EFFECTS: return true if anInteger is in the set, false otherwise
    public boolean contains (Integer anInteger) {
        return data.contains(anInteger);
    }

    // MODIFIES: this
    // EFFECTS: insert anInteger into the set, if it is not already there
    public void insert(Integer anInteger) {
        data.add(anInteger);
    }

    // REQUIRES: anInteger is in the set (contains(anInteger) is true)
    // MODIFIES: this
    // EFFECTS: remove anInteger from the set
    public void remove(Integer anInteger) {
        data.remove(anInteger);
    }
}
