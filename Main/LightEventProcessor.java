package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventHandler {


/*
    @Override
    public void handle(SmartHome smartHome, SensorEvent event){

        if (event.getType() != LIGHT_ON || event.getType() != LIGHT_OFF)
            return;
        else{
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(event.getObjectId())) {
                        if (event.getType() == LIGHT_ON) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                        } else {
                            light.setOn(false);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                        }
                    }
                }
            }
        }
    }
}
*/

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != LIGHT_ON || event.getType() != LIGHT_OFF) {
            return;
        }

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    switchLight(event, room, light);
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