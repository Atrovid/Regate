package fr.ensicaen.Elgama.model.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;
import java.io.IOException;

public class WeatherWindTest {

    @Test
    void getWindForceTest() {
        Point2D gps = new Point2D.Float(3,3);
        WeatherWind wind = null;
        try {
            wind = new WeatherWind(gps);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        float windForce = wind.getWindForce();
        assertEquals(0, windForce);
    }
}
