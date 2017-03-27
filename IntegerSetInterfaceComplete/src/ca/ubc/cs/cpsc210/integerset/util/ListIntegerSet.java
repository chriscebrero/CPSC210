package ca.ubc.cs.cpsc210.integerset.util;

import java.util.LinkedList;
import java.util.List;

// Represents a set of integers
public class ListIntegerSet implements IntegerSet {
    private List<Integer> data;

    // EFFECTS: set is empty
    public ListIntegerSet() {
        data = new LinkedList<Integer>();
    }

    // MODIFIES: this
    // EFFECTS: Integer i is added to the IntegerSet if it's not
    // already in the IntegerSet
    @Override
    public void insert(Integer i) {
        if (!contains(i))
            data.add(i);
    }

    // REQUIRES: Integer i is an element of the IntegerSet
    // MODIFIES: this
    // EFFECTS: Integer i is removed from the IntegerSet
    @Override
    public void remove(Integer i) {
        data.remove(i);
    }

    // EFFECTS: Returns true if Integer i is in the IntegerSet
    // and false otherwise
    @Override
    public boolean contains(Integer i) {
        return data.contains(i);
    }

    // EFFECTS: Returns the number of items in the set
    @Override
    public int size() {
        return data.size();
    }

    // EFFECTS: Returns intersection of this and other
    @Override
    public IntegerSet intersection(IntegerSet other) {
		IntegerSet intersection = new ListIntegerSet();
		
		for (Integer i : data) {
			if (other.contains(i))
				intersection.insert(i);
		}
		
		return intersection;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;

        IntegerSet that = (IntegerSet) o;

        if (size() != that.size()) return false;

        for (Integer i : data) {
            if (!that.contains(i))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
