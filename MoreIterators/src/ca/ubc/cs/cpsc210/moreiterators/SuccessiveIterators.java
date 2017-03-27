package ca.ubc.cs.cpsc210.moreiterators;

import java.util.Iterator;

/**
 * Created by Dante on 2016-12-09.
 */
public class SuccessiveIterators<E> implements Iterator<E> {
    private Iterator<E> it1, it2;

    public SuccessiveIterators(Iterator<E> it1, Iterator<E> it2) {
        this.it1 = it1;
        this.it2 = it2;
    }

    public boolean hasNext() {
        return (it1.hasNext() || it2.hasNext());
    }

    @Override
    public E next() {
        return it1.hasNext() ? it1.next() : it2.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
