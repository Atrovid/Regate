package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPointTest {
    private final Point2D p1 = new Point2D(100, 100);
    private final Point2D p2 = new Point2D(200, 100);
    private final CheckPoint cp = new CheckPoint(p1, p2);

    Point2D boat_before, boat_after;

    @Test
    public void noCrossing() {
        boat_before = new Point2D(100, 110);
        boat_after = new Point2D(150, 110);
        assertFalse(cp.isColliding(boat_before, boat_after));
    }

    @Test
    public void Crossing() {
        boat_before = new Point2D(100, 110);
        boat_after = new Point2D(150, 90);
        assertTrue(cp.isColliding(boat_before, boat_after));
    }

    @Test
    public void landingOnCheckPoint() {
        boat_before = new Point2D(100, 110);
        boat_after = new Point2D(200, 100);
        assertTrue(cp.isColliding(boat_before, boat_after));
    }

    @Test
    public void TrajectoryInsideCheckPoint() {
        boat_before = new Point2D(110, 100);
        boat_after = new Point2D(190, 100);
        assertTrue(cp.isColliding(boat_before, boat_after));
    }

}
