package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallEventsProcessor implements EventHandler {
    // закрыта дверь в холле => выключаем свет во всем доме


    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if ((event.getType() != DOOR_OPEN) ||  (event.getType() != DOOR_CLOSED)) {
            return;
        }

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (!(event.getType() == DOOR_CLOSED)) {
                        return;
                    }
                    if (!(room.getName().equals("hall"))) {
                        return;
                    }
                    switchOffLightInSmartHome(smartHome, room);
                }
            }
        }
    }

    private void switchOffLightInSmartHome(SmartHome smartHome, Room room) {
        if (room.getName().equals("hall")) {
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    Application.sendCommand(command);
                }
            }
        }
        System.out.println("Light turned off.");
    }

    private void turnLightInSmartHome(SmartHome smartHome) {
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(false);
            }
        });
    }
}