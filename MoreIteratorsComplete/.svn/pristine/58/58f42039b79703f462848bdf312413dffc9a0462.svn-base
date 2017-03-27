package ca.ubc.cs.cpsc210.moreiterators;

import java.util.Iterator;

/**
 * Return an iterator that gives all combinations of the first iterator and the second iterable.
 * I need an iterable for the second because I need to get the iterator multiple times.
 */
public class CartesianIterators implements Iterator<Integer> {
    private Iterator<Integer> it1, it2;
    private Iterable<Integer> ia2;
    private Integer e1;
    
    public CartesianIterators(Iterator<Integer> it1, Iterable<Integer> ia2) {
        this.it1 = it1; this.ia2 = ia2;
        it2 = ia2.iterator(); e1 = it1.hasNext() ? it1.next() : null;
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }

    @Override
    public Integer next() {
        Integer ans = e1 * it2.next();
        if (!it2.hasNext()) {
            e1 = it1.hasNext() ? it1.next() : null;
            if (e1 != null) it2 = ia2.iterator();
        }
        return ans;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
