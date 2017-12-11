package ru.sbt.mipt.oop;

public class AlarmSystemOn implements AlarmSystem{

    private AlarmSystemImplementation alarmSystemImplementation;

    public AlarmSystemOn(AlarmSystemImplementation alarmSystemImplementation) {
        this.alarmSystemImplementation = alarmSystemImplementation;
    }

    @Override
    public AlarmSystemType getStateType() {
        return AlarmSystemType.ON;
    }

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystemImplementation.setAlarmSystem(new AlarmSystemWaitForPassword(alarmSystemImplementation));
    }

    @Override
    public void enterPassword(double password) {
        return;
    }

    @Override
    public void turnOff() {
        return;
    }
}
