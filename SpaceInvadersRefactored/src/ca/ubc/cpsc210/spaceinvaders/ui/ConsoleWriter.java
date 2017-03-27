package ca.ubc.cpsc210.spaceinvaders.ui;

import ca.ubc.cpsc210.spaceinvaders.model.SIGame;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dante on 2016-12-09.
 */
public class ConsoleWriter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (SIGame.EVENT_INVADER_HIT.equals(arg)) {
            System.out.println("Ouch: Invader hit!");
        }
    }
}
