package ca.ubc.cpsc210.spaceinvaders.ui;

import ca.ubc.cpsc210.spaceinvaders.model.SIGame;

import javax.swing.*;
import java.awt.*;

/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class ScorePanel extends JPanel {
	private static final String INVADERS_TXT = "Invaders shot down: ";
	private static final String MISSILES_TXT = "Missiles remaining: ";
	private static final int LBL_WIDTH = 200;
	private static final int LBL_HEIGHT = 30;
	private JLabel invadersLbl;
	private JLabel missilesLbl;

	// EFFECTS: sets the background colour and draws the initial labels;
	//          updates this with the game whose score is to be displayed
	public ScorePanel() {
		setBackground(new Color(180, 180, 180));
		invadersLbl = new JLabel(INVADERS_TXT + 0);
		invadersLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
		missilesLbl = new JLabel(MISSILES_TXT + SIGame.MAX_MISSILES);
		missilesLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
		add(invadersLbl);
		add(Box.createHorizontalStrut(10));
		add(missilesLbl);
	}

	// MODIFIES: this
	// EFFECTS:  updates number of invaders shot and number of missiles
	//           remaining to reflect current state of game
	public void update(int numInvadersDestroyed, int numInvadersRemaining) {
		invadersLbl.setText(INVADERS_TXT + numInvadersDestroyed);
		missilesLbl.setText(MISSILES_TXT + numInvadersRemaining);
		repaint();
	}
}
