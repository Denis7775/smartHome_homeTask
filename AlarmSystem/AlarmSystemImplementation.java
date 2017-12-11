package ru.sbt.mipt.oop;

public class AlarmSystemImplementation implements AlarmSystem {

    private AlarmSystem alarmSystem;
    private double password;

    public AlarmSystemImplementation(double password){
        alarmSystem = new AlarmSystemOff(this);
        this.password = password;
    }

     public void setAlarmSystem(AlarmSystem nextAlarmSystem){
        alarmSystem = nextAlarmSystem;
     }

    @Override
    public AlarmSystemType getStateType() {
        return alarmSystem.getStateType();
    }

    @Override
    public void turnOn(){
        alarmSystem.turnOn();
    }

    @Override
    public void enterPassword(double password){
        alarmSystem.enterPassword(password);
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent){
        alarmSystem.onSensorEvent(sensorEvent);
    }

    @Override
    public void turnOff(){
        alarmSystem.turnOff();
    }

}
