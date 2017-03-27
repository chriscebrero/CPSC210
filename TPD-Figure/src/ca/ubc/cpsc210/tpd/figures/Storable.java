package ca.ubc.cpsc210.tpd.figures;

import com.sun.java.browser.plugin2.DOM;

import javax.xml.transform.dom.DOMSource;

/**
 * Created by Dante on 2016-10-05.
 */
public interface Storable {
    public void read(File f);
    public void write(File f);
}
