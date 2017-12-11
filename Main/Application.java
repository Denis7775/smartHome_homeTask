package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.sbt.mipt.oop.SensorEventType.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("C:\\java_examples\\Software_design\\smart-home\\application.xml");
        EventObserver  eventObserver = (EventObserver) ctx.getBean("C:\\java_examples\\Software_design\\smart-home\\eventObserver");
        eventObserver.runEventCycle();
    }

    private static void configureHandlers(EventObserver sensorEventObserver) {
        List<EventHandler> handlers = new ArrayList<>();
        sensorEventObserver.setHandlers(handlers);
        sensorEventObserver.addHandler(new LightEventProcessor());
        sensorEventObserver.addHandler(new DoorEventProcessor());
        sensorEventObserver.addHandler(new HallEventsProcessor());
    }

    static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
