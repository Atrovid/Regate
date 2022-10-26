package fr.ensicaen.elgama.model.map;

import fr.ensicaen.elgama.model.game_board.RandomWind;
import fr.ensicaen.elgama.model.game_board.Wind;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;


public class RandomWindTest {
    @Test
    void getWindStrengthTest() {
        Wind wind = new RandomWind();
        float windStrength = wind.getWindStrength();
        assertTrue((16>windStrength));
    }
    @Test
    void getWindDirectionTest() {
        Wind wind = new RandomWind();
        Point2D dir = wind.getWindDirectionPoint2D();
        double norm = dir.distance(0,0);
        assertTrue(norm<1.01 && norm>0.99);
    }

}
