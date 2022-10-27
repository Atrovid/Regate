package fr.ensicaen.elgama.model;

import fr.ensicaen.elgama.model.game_board.Shoreline;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ShorelineTest {
    @Test
    public void noCollision(){
        Shoreline sl;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(10, 10));
        points.add(new Point2D.Double(100, 10));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(10, 100));
        Point2D from = new Point2D.Double(101, 101);
        Point2D to = new Point2D.Double(101, 105);
        sl = new Shoreline(points);
        assert(!sl.isColliding(from, to));
    }

    @Test
    public void Collision(){
        Shoreline sl;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(10, 10));
        points.add(new Point2D.Double(100, 10));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(10, 100));
        Point2D from = new Point2D.Double(101, 101);
        Point2D to = new Point2D.Double(99, 95);
        sl = new Shoreline(points);
        assert(sl.isColliding(from, to));
    }

    @Test
    public void CollisionLandingOnEdge(){
        Shoreline sl;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(10, 10));
        points.add(new Point2D.Double(100, 10));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(10, 100));
        Point2D from = new Point2D.Double(101, 101);
        Point2D to = new Point2D.Double(100, 95);
        sl = new Shoreline(points);
        assert(sl.isColliding(from, to));
    }

    @Test
    public void CollisionRidingAlongEdge(){
        Shoreline sl;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(10, 10));
        points.add(new Point2D.Double(100, 10));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(10, 100));
        Point2D from = new Point2D.Double(99, 100);
        Point2D to = new Point2D.Double(90, 100);
        sl = new Shoreline(points);
        assert(sl.isColliding(from, to));
    }

    @Test
    public void getPointsAsDoubleArray(){
        Shoreline sl;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(10, 10));
        points.add(new Point2D.Double(100, 10));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(10, 100));
        double[] array = {10, 10, 100, 10, 100, 100, 10, 100};
        sl = new Shoreline(points);
        assertArrayEquals(array, sl.getPointsAsDoubleArray());
    }
}
