package ca.ubc.cs.cpsc210.integerset.util;

// Represents a set of integers
public interface IntegerSet {
    // MODIFIES: this
    // EFFECTS: Integer i is added to the IntegerSet if it's not
    // already in the IntegerSet
    void insert(Integer i);

    // REQUIRES: Integer i is an element of the IntegerSet
    // MODIFIES: this
    // EFFECTS: Integer i is removed from the IntegerSet
    void remove(Integer i);

    // EFFECTS: Returns true if Integer i is in the IntegerSet
    // and false otherwise
    boolean contains(Integer i);

    // EFFECTS: Returns the number of items in the set
    int size();

    // EFFECTS: Returns intersection of this and other
    IntegerSet intersection(IntegerSet other);
}
