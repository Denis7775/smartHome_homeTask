package Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class EventObserverTest {

    @Test
    public void checkObservber(){

        List<Light> lights = new ArrayList<>();
        Light light;

        for (int i = 0; i < 9; i++) {
            light = new Light("" + i, false);
            lights.add(light);
        }

        Door door = new Door(false, "1");
        List<Door> doorrList = new ArrayList<>();
        doorrList.add(door);


        Room room = new Room(lights, doorrList, "kitchen");
        List<Room> roomas = new ArrayList<>();
        roomas.add(room);

        SmartHome smartHome = new SmartHome(roomas);
        EventObserver observer = new EventObserver(smartHome);

        SensorEvent sensorEvent = new SensorEvent(SensorEventType.LIGHT_ON, "1");

        LightEventProcessor lightEventProcessor = new LightEventProcessor();
        List<EventObserver> event = new ArrayList<>();
        event.add(observer);

        lightEventProcessor.handle(smartHome, sensorEvent);

        for (Room roomi : smartHome.getRooms()) {
            for (Light lighti : room.getLights()) {
                if (lighti.getId().equals(sensorEvent.getObjectId())) {
                    switchLight(sensorEvent, roomi, lighti);
                }
            }
        }

        for (Room roomi : smartHome.getRooms()) {
            for (Light lighti : room.getLights()) {
                if (lighti.getId().equals("1")) {
                    assertTrue(lighti.isOn());
                }
            }
        }
    }

    private void switchLight(SensorEvent event, Room room, Light light) {
        if (event.getType() == LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
        } else if (event.getType() == LIGHT_OFF) {
            light.setOn(false);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
        }
    }


}
