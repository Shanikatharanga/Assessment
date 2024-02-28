package org.example;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class AppTest
{
    @Test
    public void testAutonomousCars() {
        Map<String, App> cars = new HashMap<>();
        cars.put("A", new App(1, 2, 'N'));
        cars.put("B", new App(7, 8, 'W'));

        cars.get("A").executeCommands("FFRFFFFRRL", 10, 10);
        cars.get("B").executeCommands("FFLFFFFFFF", 10, 10);

        String result = checkCollisions(cars);
        assertEquals("no collision", result);
    }

    private String checkCollisions(Map<String, App> cars) {
        for (int step = 1; ; step++) {
            Map<String, String> positions = new HashMap<>();
            boolean collision = false;

            for (Map.Entry<String, App> entry : cars.entrySet()) {
                entry.getValue().executeCommands("F", 10, 10);
                String position = entry.getValue().getPosition();

                if (positions.containsValue(position)) {
                    collision = true;
                    return entry.getKey() + " " + positions.entrySet().stream()
                            .filter(e -> e.getValue().equals(position))
                            .findFirst().orElseThrow(() -> new NoSuchElementException("No value present")).getKey() +
                            "\n" + position + "\n" + step;
                }

                positions.put(entry.getKey(), position);
            }

            if (!collision) {
                return "no collision";
            }
        }
    }
}
