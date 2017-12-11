package ru.sbt.mipt.oop;

public class AlarmSystemAlarm implements AlarmSystem{
    AlarmSystemImplementation alarmSystemImplementation;

    public AlarmSystemAlarm(AlarmSystemImplementation alarmSystemImplementation){
        this.alarmSystemImplementation = alarmSystemImplementation;
    }


    @Override
    public AlarmSystemType getStateType() {
        return AlarmSystemType.ALARM;
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
        return;
    }

    @Override
    public void turnOff() {
        alarmSystemImplementation.setAlarmSystem(new AlarmSystemOff(alarmSystemImplementation));
    }

}
