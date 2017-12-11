package ru.sbt.mipt.oop;

public interface AlarmSystem {

    AlarmSystemType getStateType();

    void turnOn();

    void onSensorEvent(SensorEvent sensorEvent);

    void enterPassword(double password);

    void turnOff();

}
