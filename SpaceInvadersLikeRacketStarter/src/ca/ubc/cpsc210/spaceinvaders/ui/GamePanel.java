package ca.ubc.cpsc210.spaceinvaders.ui;

import java.awt.*;

import javax.swing.JPanel;

import ca.ubc.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cpsc210.spaceinvaders.model.Ufo;
import ca.ubc.cpsc210.spaceinvaders.model.Missile;
import ca.ubc.cpsc210.spaceinvaders.model.Tank;

/*
 * The panel in which the game is rendered.
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private SIGame game;

	// EFFECTS:  sets size and background colour of panel,
	//           updates this with the game to be displayed
	public GamePanel(SIGame g) {
		setPreferredSize(new Dimension(SIGame.WIDTH, SIGame.HEIGHT));
        setSize(new Dimension(SIGame.WIDTH, SIGame.HEIGHT));
		setBackground(Color.WHITE);
		this.game = g;
	}
	
	@Override
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		drawGame(g);
    }

	// MODIFIES: g
	// EFFECTS:  draws the game onto g
	private void drawGame(Graphics g) {
		drawTank(g);
		drawInvaders(g);
		drawMissiles(g);
	}

    // MODIFIES: g
    // EFFECTS:  draws the tank onto g
    private void drawTank(Graphics g) {
        Tank t = game.getTank();
        Color savedCol = g.getColor();
        g.setColor(Tank.BODYCOLOR);
        g.fillRect(t.getX() - Tank.BODY_SIZE_X / 2, Tank.Y_POS - Tank.BODY_SIZE_Y, Tank.BODY_SIZE_X, Tank.BODY_SIZE_Y);
        g.fillRect(t.getX() - Tank.GUN_SIZE_X / 2, Tank.Y_POS - Tank.BODY_SIZE_Y - Tank.GUN_SIZE_Y, Tank.GUN_SIZE_X, Tank.GUN_SIZE_Y);
        g.fillOval(t.getX() - Tank.SIZE_X / 2, Tank.Y_POS - Tank.SIZE_Y / 2, Tank.SIZE_X, Tank.SIZE_Y);
        g.setColor(Tank.TREADCOLOR);
        g.drawOval(t.getX() - Tank.SIZE_X / 2, Tank.Y_POS - Tank.SIZE_Y / 2, Tank.SIZE_X, Tank.SIZE_Y);
        g.setColor(savedCol);
    }

	// MODIFIES: g
	// EFFECTS:  draws the invaders onto g
	private void drawInvaders(Graphics g) {
		for(Ufo next : game.getUfos()) {
			drawInvader(g, next);
		}
	}

	// MODIFIES: g
	// EFFECTS:  draws the invader i onto g
	private void drawInvader(Graphics g, Ufo i) {
		Color savedCol = g.getColor();
		g.setColor(Ufo.COLOR);
		g.fillOval(i.getX() - Ufo.SIZE_X_SAUCER/ 2, i.getY() - Ufo.SIZE_Y_SAUCER, Ufo.SIZE_X_SAUCER, Ufo.SIZE_Y_SAUCER);
        g.drawOval(i.getX() - Ufo.SIZE_X_COCKPIT / 2, i.getY() - 16, Ufo.SIZE_X_COCKPIT, Ufo.SIZE_Y_COCKPIT);
		g.setColor(savedCol);
	}

	// MODIFIES: g
	// EFFECTS:  draws the missiles onto g
	private void drawMissiles(Graphics g) {
		for(Missile next : game.getMissiles()) {
			drawMissile(g, next);
		}
	}

	// MODIFIES: g
	// EFFECTS:  draws the missile m onto g
	private void drawMissile(Graphics g, Missile m) {
		Color savedCol = g.getColor();
		g.setColor(Missile.COLOR);
		g.fillOval(m.getX() - Missile.SIZE_X / 2, m.getY() - Missile.SIZE_Y / 2, Missile.SIZE_X, Missile.SIZE_Y);
		g.setColor(savedCol);
	}
}
