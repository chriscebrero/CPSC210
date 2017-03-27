package ca.ubc.cs.cpsc210.moreiterators;

import java.util.Iterator;

/**
 * Return an iterator the produces the elements of the two iterators alternatively.
 */
public class AlternatingIterators<E> implements Iterator<E> {
    private Iterator<E> it1, it2;

    public AlternatingIterators(Iterator<E> it1, Iterator<E> it2) {
        this.it1 = it1; this.it2 = it2;
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }

    @Override
    public E next() {
        E ans = it1.hasNext() ? it1.next() : it2.next();
        Iterator<E> tmp = it1;
        it1 = it2;
        it2 = tmp;
        return ans;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
