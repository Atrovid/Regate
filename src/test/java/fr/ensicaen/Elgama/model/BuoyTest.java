package fr.ensicaen.Elgama.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.awt.geom.Point2D;

public class BuoyTest {

    private Point2D boat_before = new Point2D.Float(200,190);
    private Point2D boat_after = new Point2D.Float(200, 198);
    Buoy buoy = new Buoy(new Point2D.Float(200, 200), 5);

    @Test
    public void isPointColliding_noCollision(){
        assert(!buoy.isPointColliding(boat_before));
    }

    @Test
    public void isPointColliding_Collision(){
        assert(buoy.isPointColliding(boat_after));
    }

    @Test
    public void isColliding_noCollision(){
        boat_before.setLocation(194, 190);
        boat_after.setLocation(194, 210);
        assert(!buoy.isColliding(boat_before,boat_after));
    }

    @Test
    public void isColliding_Collision(){
        boat_before.setLocation(196, 190);
        boat_after.setLocation(196, 210);
        assert(buoy.isColliding(boat_before,boat_after));
    }

    @Test
    public void isColliding_Collision_noDeplacement(){
        boat_before.setLocation(196, 200);
        boat_after.setLocation(boat_before);
        assert(buoy.isColliding(boat_before,boat_after));
        boat_after.setLocation(197, 200);
        assert(buoy.isColliding(boat_before,boat_after));
    }
}
