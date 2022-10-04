package fr.ensicaen.Elgama.model.map;

import fr.ensicaen.Elgama.model.RandomWind;
import fr.ensicaen.Elgama.model.Wind;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RandomWindTest {
    @Test
    void getWindForceTest() {
        Wind wind = new RandomWind();
        float windForce = wind.getWindForce();
        assertTrue((windForce>0));
    }
    @Test
    void getWindDirectionTest() {
        Wind wind = new RandomWind();
        Point2D dir = wind.getWindDirection();
        List<Integer> integers = Arrays.asList(-1, 0, 1);
        int x = (int) dir.getX();
        boolean integerXExists = integers.contains(x);
        int y = (int) dir.getY();
        boolean integerYExists = integers.contains(y);
        assertTrue(integerXExists);
        assertTrue(integerYExists);
    }
}
