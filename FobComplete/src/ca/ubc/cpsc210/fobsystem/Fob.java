package ca.ubc.cpsc210.fobsystem;

/**
 * A fob used to grant access to locked resources, such as doors in a building.
 * A fob includes a small LCD that can display a twelve digit alphanumeric
 * sequence. The alphanumeric sequence can be set by a user at a special kiosk.
 * One use of the LCD is to load and display a phone number of the owner of the
 * fob so the owner can be contacted if the fob is lost.
 * 
 * @author Gail Murphy
 * 
 */

public class Fob {

	// invariant:
	// displaySequence == null ||
	// (displaySequence != null && displaySequence.length() <= MAX_LENGTH_OF_DISPLAY_SEQUENCE)
	// &&
	// uniqueId > 0

	// Each fob has a unique identifier assigned to it.
	private int uniqueId;

	// The alphanumeric sequence that can be loaded onto the
	// fob and displayed through the fob's LCD. 
	private String displaySequence;
	
	// Maximum length of displaySequence
	private final int MAX_LENGTH_OF_DISPLAY_SEQUENCE = 12;
	
	/**
	 * Constructor
	 * @param id is identifier of fob
	 * 
	 * Requires: id > 0
	 */
	public Fob(int id) {
		uniqueId = id;
	}
	
	/**
	 * Set the alphanumeric character sequence
	 * @param s The string to set the alphanumeric sequence for display
	 */
	public void setDisplaySequence(String s) {
		if ( (s != null) && ( s.length() <= MAX_LENGTH_OF_DISPLAY_SEQUENCE )) {
			displaySequence = s;
		}
		else if ( s != null ) {
			displaySequence = s.substring(0, MAX_LENGTH_OF_DISPLAY_SEQUENCE);
		}
	}
	
	/**
	 * Get the current alphanumeric character sequence
	 * @return The alphanumeric character sequence.	
	 */
	public String getDisplaySequence() {
		return displaySequence;
	}
	

	/**
	 * Format a string with the most important information about a fob
	 * @return String formatted with fob information
	 */
	public String getReportString() {
		return new String("==Fob: <" + uniqueId + "> with LCD <" + displaySequence + ">\n");
	}

	/*
	 * NOTE TO CPSC 210 STUDENTS
	 * Here's the change made to the code - we have overridden equals and hashCode
	 * for Fob.  In particular, note that two Fob objects are considered equal if
	 * they have the same id - we don't require the display sequences to be equal as,
	 * for a given fob object, we know that the display sequence can be changed over time.
	 * It's the fob's id that we want to use to determine whether or not the fob gives
	 * access to a resource - we don't care about the display sequence.
	 */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fob fob = (Fob) o;

        if (uniqueId != fob.uniqueId) return false;

        return uniqueId.equals(fob.uniqueId);

        return true;
    }

    @Override
    public int hashCode() {
        return uniqueId;
    }
}
