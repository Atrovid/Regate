package fr.ensicaen.Elgama.model.map;

import fr.ensicaen.Elgama.model.WeatherWind;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;
import java.io.IOException;

public class WeatherWindTest {

    @Test
    void getWindForceTest() {
        Point2D gps = new Point2D.Double(49.283,-0.25);
        WeatherWind wind;
        try {
            wind = new WeatherWind(gps);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        float windForce = wind.getWindForce();
        assertTrue(windForce >= 0);
    }

    @Test
    void getWindDirectionTest() {
        Point2D gps = new Point2D.Double(49.283,-0.25);
        WeatherWind wind;
        try {
            wind = new WeatherWind(gps);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Point2D windDirection = wind.getWindDirection();
        double norm = windDirection.distance(0,0);
        assertEquals(1, norm, 0.001);
    }
}
