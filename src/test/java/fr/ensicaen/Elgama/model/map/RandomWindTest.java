package fr.ensicaen.Elgama.model.map;

import fr.ensicaen.Elgama.model.RandomWind;
import fr.ensicaen.Elgama.model.IWind;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RandomWindTest {
    @Test
    void getWindForceTest() {
        IWind wind = new RandomWind();
        float windForce = wind.getWindForce();
        assertTrue((16>windForce));
    }
    @Test
    void getWindDirectionTest() {
        IWind wind = new RandomWind();
        Point2D dir = wind.getWindDirection();
        double norm = dir.distance(0,0);
        assertTrue(norm<1.01 && norm>0.99);
    }

}
