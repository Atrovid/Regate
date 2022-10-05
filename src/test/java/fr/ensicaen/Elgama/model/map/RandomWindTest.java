package fr.ensicaen.Elgama.model.map;

import fr.ensicaen.Elgama.model.RandomWind;
import fr.ensicaen.Elgama.model.IWind;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;


public class RandomWindTest {
    @Test
    void getWindForceTest() {
        IWind wind = new RandomWind();
        float windForce = wind.getWindForce();
        assertTrue((0<=windForce));
    }
    @Test
    void getWindDirectionTest() {
        IWind wind = new RandomWind();
        Point2D dir = wind.getWindDirection();
        double norm = dir.distance(0,0);
        assertEquals(1, norm, 0.001);
    }

}
