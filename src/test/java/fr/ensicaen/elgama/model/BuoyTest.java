package fr.ensicaen.elgama.model;

import fr.ensicaen.elgama.model.game_board.Buoy;
import org.junit.jupiter.api.Test;

import javafx.geometry.Point2D;

public class BuoyTest {

    private Point2D boat_before;
    private Point2D boat_after;
    Buoy buoy = new Buoy(new Point2D(200, 200), 5);

    @Test
    public void isPointColliding_noCollision(){
        boat_before = new Point2D(200, 190);
        assert(!buoy.isPointColliding(boat_before));
    }

    @Test
    public void isPointColliding_Collision(){
        boat_after = new Point2D(200, 198);
        assert(buoy.isPointColliding(boat_after));
    }

    @Test
    public void isColliding_noCollision(){
        boat_before = new Point2D(194, 190);
        boat_after = new Point2D(194, 210);
        assert(!buoy.isColliding(boat_before,boat_after));
    }

    @Test
    public void isColliding_Collision(){
        boat_before = new Point2D(196, 190);
        boat_after = new Point2D(196, 210);
        assert(buoy.isColliding(boat_before,boat_after));
    }

    @Test
    public void isColliding_Collision_noDeplacement(){
        boat_before = new Point2D(196, 200);
        boat_after = new Point2D(196,200);
        assert(buoy.isColliding(boat_before,boat_after));
        boat_after = new Point2D(197, 200);
        assert(buoy.isColliding(boat_before,boat_after));
    }
}
