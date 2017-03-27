package ca.ubc.cs.cpsc210.microwave.tests;

import ca.ubc.cs.cpsc210.microwave.model.MicrowaveOvenState;
import ca.ubc.cs.cpsc210.microwave.model.MicrowaveOvenStateMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// unit tests for MicrowaveOvenStateMachine
public class MicrowaveOvenStateMachineTest {
    private MicrowaveOvenStateMachine testOven;

    @Before
    public void runBefore() {
        testOven = new MicrowaveOvenStateMachine();
    }

    @Test
    public void testSetTime() {
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
        testOven.setTime(5, 30);
        assertEquals(MicrowaveOvenState.PROGRAMMED, testOven.getCurrentState());
        testOven.setTime(5, 30);
        assertEquals(MicrowaveOvenState.PROGRAMMED, testOven.getCurrentState());
        testOven.cancel();
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
        testOven.setPowerLevel(5);
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
    }

    @Test
    public void testSetPowerLevel() {
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
        testOven.setTime(5, 30);
        assertEquals(MicrowaveOvenState.PROGRAMMED, testOven.getCurrentState());
        testOven.setPowerLevel(5);
        assertEquals(MicrowaveOvenState.PROGRAMMED, testOven.getCurrentState());
        testOven.cancel();
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
    }

    @Test
    public void testCooking() {
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
        testOven.start();
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
        testOven.cancel();
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
        testOven.pause();
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
        testOven.resume();
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
        testOven.setTime(5, 0);
        assertEquals(MicrowaveOvenState.PROGRAMMED, testOven.getCurrentState());
        testOven.setPowerLevel(5);
        assertEquals(MicrowaveOvenState.PROGRAMMED, testOven.getCurrentState());
        testOven.pause();
        assertEquals(MicrowaveOvenState.PROGRAMMED, testOven.getCurrentState());
        testOven.resume();
        assertEquals(MicrowaveOvenState.PROGRAMMED, testOven.getCurrentState());
        testOven.start();
        assertEquals(MicrowaveOvenState.COOKING, testOven.getCurrentState());
        testOven.setTime(5, 50);
        assertEquals(MicrowaveOvenState.COOKING, testOven.getCurrentState());
        testOven.setPowerLevel(5);
        assertEquals(MicrowaveOvenState.COOKING, testOven.getCurrentState());
        testOven.start();
        assertEquals(MicrowaveOvenState.COOKING, testOven.getCurrentState());
        testOven.cancel();
        assertEquals(MicrowaveOvenState.COOKING, testOven.getCurrentState());
        testOven.resume();
        assertEquals(MicrowaveOvenState.COOKING, testOven.getCurrentState());
        testOven.pause();
        assertEquals(MicrowaveOvenState.PAUSED, testOven.getCurrentState());
        testOven.setTime(6, 30);
        assertEquals(MicrowaveOvenState.PAUSED, testOven.getCurrentState());
        testOven.setPowerLevel(10);
        assertEquals(MicrowaveOvenState.PAUSED, testOven.getCurrentState());
        testOven.start();
        assertEquals(MicrowaveOvenState.PAUSED, testOven.getCurrentState());
        testOven.pause();
        assertEquals(MicrowaveOvenState.PAUSED, testOven.getCurrentState());
        testOven.resume();
        assertEquals(MicrowaveOvenState.COOKING, testOven.getCurrentState());
        testOven.pause();
        testOven.cancel();
        assertEquals(MicrowaveOvenState.IDLE, testOven.getCurrentState());
    }
}