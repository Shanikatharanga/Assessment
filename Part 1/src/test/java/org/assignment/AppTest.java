package org.assignment;


import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class AppTest
{
    @Test
    public void testAutonomousCar() {
        App car = new App(1, 2, 'N');
        car.executeCommands("FFRFFFRRLF", 10, 10);
        assertEquals("4 3 S", car.getPosition());
    }
}
