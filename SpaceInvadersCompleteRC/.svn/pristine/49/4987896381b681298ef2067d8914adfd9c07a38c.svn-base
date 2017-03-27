package ca.ubc.cpsc210.spaceinvaders.ui;

import ca.ubc.cpsc210.spaceinvaders.model.SIGame;

import javax.swing.*;
import java.awt.*;

/*
 * Represents the main window in which the space invaders
 * game is played
 */
@SuppressWarnings("serial")
public class SpaceInvaders extends JFrame {

	// EFFECTS: sets up window in which Space Invaders game will be played
	public SpaceInvaders() {
		super("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		ScorePanel sp = new ScorePanel();
		GamePanel gp = new GamePanel(sp);
		add(gp);
		add(sp, BorderLayout.NORTH);
		pack();
		centreOnScreen();
		setVisible(true);
	}

	// MODIFIES: this
	// EFFECTS:  location of frame is set so frame is centred on desktop
	private void centreOnScreen() {
		Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
	}

	// Play the game
	public static void main(String[] args) {
		new SpaceInvaders();
	}
}
