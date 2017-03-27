package ca.ubc.cpsc210.tpd.figures;

import java.io.File;

public interface Storable {
	// read from and write to file

	public void read(File f);
    public void write(File f);
}
