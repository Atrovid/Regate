package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuoyTest {
    final Buoy buoy = new Buoy(new Point2D(200, 200), 5);
    private Point2D boat_before;
    private Point2D boat_after;

    @Test
    public void isColliding_noCollision() {
        boat_before = new Point2D(194, 190);
        boat_after = new Point2D(194, 210);
        assertFalse(buoy.isColliding(boat_before, boat_after));
    }

    @Test
    public void isColliding_Collision() {
        boat_before = new Point2D(196, 190);
        boat_after = new Point2D(196, 210);
        assertTrue(buoy.isColliding(boat_before, boat_after));
    }

    @Test
    public void isColliding_Collision_noMovement() {
        boat_before = new Point2D(196, 200);
        boat_after = new Point2D(196, 200);
        assertTrue(buoy.isColliding(boat_before, boat_after));
        boat_after = new Point2D(197, 200);
        assertTrue(buoy.isColliding(boat_before, boat_after));
    }
}
