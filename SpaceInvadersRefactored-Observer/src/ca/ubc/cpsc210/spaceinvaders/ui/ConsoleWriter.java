package ca.ubc.cpsc210.spaceinvaders.ui;

import ca.ubc.cpsc210.spaceinvaders.model.SIGame;

import java.util.Observable;
import java.util.Observer;

// CPSC 210: Observer Lecture/Lab: Add a kind of Observer, there could be others added too

public class ConsoleWriter implements Observer {

    @Override
    public void update(Observable subject, Object event) {
        if (SIGame.EVENT_INVADER_HIT.equals(event))
            System.out.println("Ouch: Invader hit!");
    }
}
