package ru.sbt.mipt.oop;

public class AlarmSystemWaitForPassword implements AlarmSystem{
    AlarmSystemImplementation alarmSystemImplementation;

    public AlarmSystemWaitForPassword(AlarmSystemImplementation alarmSystemImplementation){
        this.alarmSystemImplementation = alarmSystemImplementation;
    }

    @Override
    public AlarmSystemType getStateType() {
        return AlarmSystemType.WAIT_FOR_PASSWORD;
    }

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        return;
    }

    @Override
    public void enterPassword(double password) {
        alarmSystemImplementation.setAlarmSystem(new AlarmSystemAlarm(alarmSystemImplementation));
    }

    @Override
    public void turnOff() {
        return;
    }

}
