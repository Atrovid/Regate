package fr.ensicaen.Elgama.model;

import fr.ensicaen.Elgama.model.game_board.Buoy;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

public class BuoyTest {

    private Point2D boat_before;
    private Point2D boat_after;
    Buoy buoy = new Buoy(new Point2D.Float(200, 200), 5);

    @Test
    public void isPointColliding_noCollision(){
        boat_before = new Point2D.Double(200, 190);
        assert(!buoy.isPointColliding(boat_before));
    }

    @Test
    public void isPointColliding_Collision(){
        boat_after = new Point2D.Double(200, 198);
        assert(buoy.isPointColliding(boat_after));
    }

    @Test
    public void isColliding_noCollision(){
        boat_before = new Point2D.Double(194, 190);
        boat_after = new Point2D.Double(194, 210);
        assert(!buoy.isColliding(boat_before,boat_after));
    }

    @Test
    public void isColliding_Collision(){
        boat_before = new Point2D.Double(196, 190);
        boat_after = new Point2D.Double(196, 210);
        assert(buoy.isColliding(boat_before,boat_after));
    }

    @Test
    public void isColliding_Collision_noDeplacement(){
        boat_before = new Point2D.Double(196, 200);
        boat_after = new Point2D.Double(196,200);
        assert(buoy.isColliding(boat_before,boat_after));
        boat_after = new Point2D.Double(197, 200);
        assert(buoy.isColliding(boat_before,boat_after));
    }
}
