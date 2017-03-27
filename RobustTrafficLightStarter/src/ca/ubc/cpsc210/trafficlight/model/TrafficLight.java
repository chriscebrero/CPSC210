package ca.ubc.cpsc210.trafficlight.model;

import ca.ubc.cpsc210.trafficlight.model.exceptions.ColourException;
import ca.ubc.cpsc210.trafficlight.model.exceptions.SequenceException;
import ca.ubc.cpsc210.trafficlight.model.exceptions.TrafficLightException;

/*
 * Represents a traffic light.
 * 
 * @author Gail Murphy
 *         - modified by Paul Carter, Jan 2011
 *         
 * invariant
 *    (lastColour is "yellow" AND getColour().equals("red"))
 * OR
 *    (lastColour is "red" AND getColour().equals("green"))
 * OR
 *    (lastColour is "green" AND getColour().equals("yellow"))
 *    
 */
public class TrafficLight {

	private String lightColour;
	private String lastColour;
	

	// Constructor
	public TrafficLight() {
		lightColour = "red";
		lastColour = "yellow";
		hasValidState();
	}

	/*
	 * Set the current colour of the traffic light
	 * 
	 * REQUIRES:
	 * MODIFIES: this 
	 * EFFECTS: traffic light has given colour and previous colour is stored
	 * (colour.equals("red") or colour.equals("yellow") or colour.equals("green"))
	 *           AND
	 *           ( (getColour().equals(colour)) do nothing
	 *             OR
	 *             Otherwise
	 *             ( - if getColour().equals("red") then colour.equals("green") throw SquenceException
	 *               - if getColour().equals("yellow") then colour.equals("red")
	 *               - if getColour().equals("green") then colour.equals("yellow") ) )
	 */
	public void setColour(String colour) throws ColourException, SequenceException{
		hasValidState();

        if (!rightColour()) {
            throw new ColourException("");
        }


        if (!lightColour.equals(colour)) {
                lastColour = lightColour;
                lightColour = colour;
        }
		hasValidState();
	}

	public boolean rightColour() {
        return lightColour.equals("red") || lightColour.equals("yellow") || lightColour.equals("green");
    }


	/*
	 * Advance the traffic light to the next colour
	 * 
	 * MODIFIES: this 
	 * EFFECTS: if traffic light was red, now is green; 
	 * 			otherwise if traffic light was green, now is yellow; 
	 *          otherwise if traffic light was yellow, now is red
	 */
	public void advance() {
		hasValidState();
		if (lightColour.equals("red")) {
			setColour("green");
		} else if (lightColour.equals("green")) {
			setColour("yellow");
		} else if (lightColour.equals("yellow")){
			setColour("red");
		}
		hasValidState();
	}
	
	/*
	 * Resets light to default safe state.
	 * MODIFIES: this
	 * EFFECTS: getColour.equals("red") and last colour is yellow
	 */
	public void reset() {
		hasValidState();
		lightColour = "red";
		lastColour = "yellow";
		hasValidState();
	}
	
	/*
	 * Provide the current colour of the traffic light
	 * 
	 * EFFECTS: Returns one of "red", "yellow" or "green"
	 */
	public String getColour() {
		return lightColour;
	}
	
	/*
	 * Check invariants. 
	 */
	private void hasValidState() {
		assert (lastColour.equals("red") && lightColour.equals("green")) ||
		(lastColour.equals("green") && lightColour.equals("yellow")) ||
		(lastColour.equals("yellow") && lightColour.equals("red"));
	}
}
