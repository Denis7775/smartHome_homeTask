package ru.sbt.mipt.oop;

public class AlarmSystemOff implements AlarmSystem{

    private AlarmSystemImplementation alarmSystemImplementation;

    public AlarmSystemOff(AlarmSystemImplementation alarmSystemImplementation) {
        this.alarmSystemImplementation = alarmSystemImplementation;
    }

    @Override
    public AlarmSystemType getStateType() {
        return AlarmSystemType.OFF;
    }

    @Override
    public void turnOn() {
        alarmSystemImplementation.setAlarmSystem(new AlarmSystemOn(alarmSystemImplementation));
    }

    @Override
    public void enterPassword(double password) {
        return;
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        return;
    }

    @Override
    public void turnOff() {
        return;
    }

}
