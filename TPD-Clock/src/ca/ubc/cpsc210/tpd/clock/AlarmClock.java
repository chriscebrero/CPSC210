package ca.ubc.cpsc210.tpd.clock;

// represents an alarm clock
public class AlarmClock extends Clock {

    private int alarmhours;
    private int alarmminutes;
    private boolean isOn, isSounding;

    // EFFECTS: time has been set to 00:00:00,
    // alarm time is 00:00, alarm is off and is not sounding
    public AlarmClock() {
        alarmhours = 0;
        alarmminutes = 0;
        isOn = false;
        isSounding = false;
    }


    public int getAlarmHrs() {
        return alarmhours;
    }

    public int getAlarmMins() {
        return alarmminutes;
    }

    // REQUIRES: 0 <= hrs < 24, 0 <= mins < 60; time is in 24hr format
    // MODIFIES: this
    // EFFECTS: alarm has been set to given time and alarm is on
    public void setAlarmTime(int hrs, int mins) {
        alarmhours = hrs;
        alarmminutes = mins;
        isOn = true;
    }

    // MODIFIES: this
    // EFFECTS: if isOn is true, alarm is on; otherwise alarm is off and alarm is not sounding
    public void setAlarm(boolean isOn) {
        this.isOn = isOn;
        checkSounding();
    }

    // EFFECTS: returns true if alarm is on, false otherwise
    public boolean isAlarmOn() {
        return isOn;
    }

    // EFFECTS: returns true if alarm is sounding, false otherwise
    public boolean isSounding() {
        return isSounding;
    }

    private void checkSounding() {
        isSounding = isOn && alarmhours == getHours() && alarmminutes = getMinutes();
    }

    @Override
    public void tick() {
        super.tick();
    }
}
