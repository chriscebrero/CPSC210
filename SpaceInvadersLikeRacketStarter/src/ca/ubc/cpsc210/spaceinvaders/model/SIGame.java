package ca.ubc.cpsc210.spaceinvaders.model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Represents a space ufos game.
 */
public class SIGame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 500;
    private static final Random RND = new Random();
    private static final int INVASION_PERIOD = 250;   // on average, one invader each 250 updates

    private List<Missile> missiles;
    private List<Ufo> ufos;
    private Tank tank;
    private boolean isGameOver;

    // EFFECTS:  creates empty lists of missiles and ufos, centres tank on screen
    public SIGame() {
        missiles = new ArrayList<Missile>();
        ufos = new ArrayList<Ufo>();
        setUp();
    }

    // MODIFIES: this
    // EFFECTS:  updates tank, missiles and ufos
    public void update() {
        moveMissiles();
        moveInvaders();
        tank.move();

        checkMissiles();
        invade();
        checkCollisions();
        checkGameOver();
    }

    // MODIFIES: this
    // EFFECTS:  turns tank, fires missiles and resets game in response to
    //           given key pressed code
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE)
            fireMissile();
        else if (keyCode == KeyEvent.VK_R && isGameOver)
            setUp();
        else if (keyCode == KeyEvent.VK_X)
            System.exit(0);
        else
            tankControl(keyCode);
    }

    // Exercise: fill in the documentation for this method
    public boolean isOver() {
        return isGameOver;
    }

    public int getNumMissiles() {
        return missiles.size();
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public Tank getTank() {
        return tank;
    }

    // MODIFIES: this
    // EFFECTS:  clears list of missiles and ufos, initializes tank
    private void setUp() {
        ufos.clear();
        missiles.clear();
        tank = new Tank(WIDTH / 2, 2);
        isGameOver = false;
    }

    // MODIFIES: this
    // EFFECTS:  fires a missile if max number of missiles in play has
    //           not been exceeded, otherwise silently returns
    private void fireMissile() {
        Missile m = new Missile(tank.getX(), Tank.Y_POS);
        missiles.add(m);
    }

    // MODIFIES: this
    // EFFECTS: turns tank in response to key code
    private void tankControl(int keyCode) {
        if (keyCode == KeyEvent.VK_KP_LEFT || keyCode == KeyEvent.VK_LEFT)
            tank.faceLeft();
        else if (keyCode == KeyEvent.VK_KP_RIGHT || keyCode == KeyEvent.VK_RIGHT)
            tank.faceRight();
    }

    // MODIFIES: this
    // EFFECTS: moves the missiles
    private void moveMissiles() {
        for (Missile next : missiles ) {
            next.move();
        }
    }

    // MODIFIES: this
    // EFFECTS: moves the ufos
    private void moveInvaders() {
        for (Ufo next : ufos) {
            next.move();
        }
    }

    // MODIFIES: this
    // EFFECTS:  removes any missile that has traveled off top of screen
    private void checkMissiles() {
        List<Missile> missilesToRemove = new ArrayList<Missile>();

        for (Missile next : missiles) {
            if (next.getY() < 0) {
                missilesToRemove.add(next);
            }
        }

        missiles.removeAll(missilesToRemove);
    }

    // Exercise: add the documentation for this method
    private void invade() {
        if (RND.nextInt(INVASION_PERIOD) < 1) {
            Ufo i = new Ufo(RND.nextInt(SIGame.WIDTH), 0, 1);
            ufos.add(i);
        }
    }

    // MODIFIES: this
    // EFFECTS:  removes any invader that has been shot with a missile
    //           and removes corresponding missile from play
    private void checkCollisions() {
        List<Ufo> invadersToRemove = new ArrayList<Ufo>();
        List<Missile> missilesToRemove = new ArrayList<Missile>();

        for (Ufo target : ufos) {
            if (checkInvaderHit(target, missilesToRemove)) {
                invadersToRemove.add(target);
            }
        }

        ufos.removeAll(invadersToRemove);
        missiles.removeAll(missilesToRemove);
    }

    // Exercise:  fill in the documentation for this method
    private boolean checkInvaderHit(Ufo target, List<Missile> missilesToRemove) {
        for (Missile next : missiles) {
            if (target.collidedWith(next)) {
                missilesToRemove.add(next);
                return true;
            }
        }

        return false;
    }

    // MODIFIES: this
    // EFFECTS:  if an invader has landed, game is marked as
    //           over
    private void checkGameOver() {
        for (Ufo next : ufos) {
            if (next.getY() > HEIGHT) {
                isGameOver = true;
            }
        }
    }
}
