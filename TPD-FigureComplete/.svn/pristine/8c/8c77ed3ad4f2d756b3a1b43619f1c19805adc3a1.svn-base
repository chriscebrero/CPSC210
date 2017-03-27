package ca.ubc.cpsc210.tpd.app;


import ca.ubc.cpsc210.tpd.figures.*;
import ca.ubc.cpsc210.tpd.figures.Rectangle;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // simple app to illustrate use of Figure hierarchy
    public static void main(String[] args) {
        List<AbstractFigure> figures = new ArrayList<>();

        Oval o = new Oval(new Point(-1, -3));
        o.setBounds(5, 6);

        Rectangle r = new Rectangle(new Point(-2, -1));
        r.setBounds(7, 4);

        figures.add(o);
        figures.add(r);

        Point origin = new Point(0, 0);
        int numFiguresContainingOrigin = getNumFiguresContainingPoint(figures, origin);
        System.out.println("Number of figures containing origin: " + numFiguresContainingOrigin);

        writeFigures(figures);
    }

    // EFFECTS: gets number of figures in given list that contain given point
    // DO NOT concern yourselves with <? extends Figure> - this syntax is non-examinable
    private static int getNumFiguresContainingPoint(List<? extends Figure> figures, Point p) {
        int numFiguresContainingPoint = 0;

        // Note that for each object in the list, we can invoke methods specified in Figure, but
        // not those specified in Storable
        for (Figure next : figures) {
            if (next.contains(p)) {
                numFiguresContainingPoint++;
            }
        }

        return numFiguresContainingPoint;
    }

    // EFFECTS: write figures to file (NOTE: implementation not complete)
    // DO NOT concern yourselves with <? extends Storable> - this syntax is non-examinable
    private static void writeFigures(List<? extends Storable> storables) {

        // Note that for each object in the list, we can invoke methods specified in Storable, but
        // not those specified in Figure
        for (Storable next : storables) {
            File fileToWriteTo = null;
            next.write(fileToWriteTo);
            next.read(fileToWriteTo);
        }
    }
}
