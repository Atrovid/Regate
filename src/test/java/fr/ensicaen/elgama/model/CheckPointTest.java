package fr.ensicaen.elgama.model;

import fr.ensicaen.elgama.model.game_board.CheckPoint;
import org.junit.jupiter.api.Test;

import javafx.geometry.Point2D;

public class CheckPointTest {
    private Point2D p1 = new Point2D(100, 100);
    private Point2D p2 = new Point2D(200, 100);
    private CheckPoint cp = new CheckPoint(p1, p2);

    Point2D boat_before, boat_after;

    @Test
    public void noCrossing(){
        boat_before = new Point2D(100, 110);
        boat_after = new Point2D(150, 110);
        assert(!cp.isColliding(boat_before, boat_after));
    }

    @Test
    public void Crossing(){
        boat_before = new Point2D(100, 110);
        boat_after = new Point2D(150, 90);
        assert(cp.isColliding(boat_before, boat_after));
    }

    @Test
    public void landingOnCheckPoint(){
        boat_before = new Point2D(100, 110);
        boat_after = new Point2D(200,100);
        assert(cp.isColliding(boat_before, boat_after));
    }

    @Test
    public void TrajectoryInsideCheckPoint(){
        CheckPoint cp2 = new CheckPoint(new Point2D(100,100), new Point2D(150,100));
        boat_before = new Point2D(110, 100);
        boat_after = new Point2D(190, 100);
        assert(cp.isColliding(boat_before, boat_after));
    }

}
