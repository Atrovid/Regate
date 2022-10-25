package fr.ensicaen.elgama.model.map;

import fr.ensicaen.elgama.model.game_board.WeatherWind;
import fr.ensicaen.elgama.model.game_board.WeatherWindRequestFailureException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.geom.Point2D;

public class WeatherWindTest {

    //TODO : faire des tests sans utiliser le serveur

    @Test
    void getWindForceTest() {
        Point2D gps = new Point2D.Double(49.283,-0.25);
        WeatherWind wind;
        try {
            wind = new WeatherWind(gps);
        } catch (WeatherWindRequestFailureException ignored) {
            return;
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
        } catch (WeatherWindRequestFailureException ignored) {
            return;
        }
        Point2D windDirection = wind.getWindDirection();
        double norm = windDirection.distance(0,0);
        assertEquals(1, norm, 0.001);
    }
}
