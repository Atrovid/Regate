package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ShorelineTest {
    private static Shoreline _shoreline;

    @BeforeAll
    static void beforeAll() {
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D(10, 10));
        points.add(new Point2D(100, 10));
        points.add(new Point2D(100, 100));
        points.add(new Point2D(10, 100));
        _shoreline = new Shoreline(points);
    }

    @Test
    public void noCollision() {
        Point2D from = new Point2D(101, 101);
        Point2D to = new Point2D(101, 105);
        assertFalse(_shoreline.isColliding(from, to));
    }

    @Test
    public void Collision() {
        Point2D from = new Point2D(101, 101);
        Point2D to = new Point2D(99, 95);
        assertTrue(_shoreline.isColliding(from, to));
    }

    @Test
    public void CollisionLandingOnEdge() {
        Point2D from = new Point2D(101, 101);
        Point2D to = new Point2D(100, 95);
        assertTrue(_shoreline.isColliding(from, to));
    }

    @Test
    public void CollisionRidingAlongEdge() {
        Point2D from = new Point2D(99, 100);
        Point2D to = new Point2D(90, 100);
        assertTrue(_shoreline.isColliding(from, to));
    }

    @Test
    public void getPointsAsDoubleArray() {
        double[] array = {10, 10, 100, 10, 100, 100, 10, 100};
        assertArrayEquals(array, _shoreline.getPointsAsDoubleArray());
    }
}
