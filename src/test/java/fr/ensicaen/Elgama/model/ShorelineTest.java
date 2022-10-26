package fr.ensicaen.Elgama.model;

import fr.ensicaen.Elgama.model.game_board.Shoreline;
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
        boolean shorelineCreated = true;

        Point2D from = new Point2D.Double(101, 101);
        Point2D to = new Point2D.Double(101, 105);

        try {
            sl = new Shoreline(points);
            assert(!sl.isColliding(from, to));
        } catch (Exception e) {
            shorelineCreated = false;
        }
        assert(shorelineCreated);
    }

    @Test
    public void Collision(){
        Shoreline sl;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(10, 10));
        points.add(new Point2D.Double(100, 10));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(10, 100));
        boolean shorelineCreated = true;

        Point2D from = new Point2D.Double(101, 101);
        Point2D to = new Point2D.Double(99, 95);

        try {
            sl = new Shoreline(points);
            assert(sl.isColliding(from, to));
        } catch (Exception e) {
            shorelineCreated = false;
        }
        assert(shorelineCreated);
    }

    @Test
    public void CollisionLandingOnEdge(){
        Shoreline sl;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(10, 10));
        points.add(new Point2D.Double(100, 10));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(10, 100));
        boolean shorelineCreated = true;

        Point2D from = new Point2D.Double(101, 101);
        Point2D to = new Point2D.Double(100, 95);

        try {
            sl = new Shoreline(points);
            assert(sl.isColliding(from, to));
        } catch (Exception e) {
            shorelineCreated = false;
        }
        assert(shorelineCreated);
    }

    @Test
    public void CollisionRidingAlongEdge(){
        Shoreline sl;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(10, 10));
        points.add(new Point2D.Double(100, 10));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(10, 100));
        boolean shorelineCreated = true;

        Point2D from = new Point2D.Double(99, 100);
        Point2D to = new Point2D.Double(90, 100);

        try {
            sl = new Shoreline(points);
            assert(sl.isColliding(from, to));
        } catch (Exception e) {
            shorelineCreated = false;
        }
        assert(shorelineCreated);
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
        boolean shorelineCreated = true;
        try {
            sl = new Shoreline(points);
            assertArrayEquals(array, sl.getPointsAsDoubleArray());
        } catch (Exception e) {
            shorelineCreated = false;
        }
        assert(shorelineCreated);
    }

    @Test
    public void cannotCreateWrongShoreline(){
        Shoreline sl0;
        Shoreline sl1;
        Shoreline sl2;
        Shoreline sl3;
        boolean Shoreline0Created = true;
        boolean Shoreline1Created = true;
        boolean Shoreline2Created = true;
        boolean Shoreline3Created = true;
        ArrayList<Point2D> points = new ArrayList<>();
        try {
            sl0 = new Shoreline(points);
        } catch (Exception e) {
            Shoreline0Created = false;
        }
        points.add(new Point2D.Double(10, 10));
        try {
            sl1 = new Shoreline(points);
        } catch (Exception e) {
            Shoreline1Created = false;
        }
        points.add(new Point2D.Double(100, 10));
        try {
            sl2 = new Shoreline(points);
        } catch (Exception e) {
            Shoreline2Created = false;
        }
        points.add(new Point2D.Double(100, 100));
        try {
            sl3 = new Shoreline(points);
        } catch (Exception e) {
            Shoreline3Created = false;
        }

        assert(!Shoreline0Created);
        assert(!Shoreline1Created);
        assert(!Shoreline2Created);
        assert(Shoreline3Created);
    }
}
