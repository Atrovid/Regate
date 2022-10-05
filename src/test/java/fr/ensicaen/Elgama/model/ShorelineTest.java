package fr.ensicaen.Elgama.model;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

public class ShorelineTest {
    Shoreline slW = new Shoreline(500, 'w');
    Shoreline slE = new Shoreline(500, 'e');
    Shoreline slN = new Shoreline(500, 'n');
    Shoreline slS = new Shoreline(500, 's');
    Point2D boat_before;
    Point2D boat_after;


    // No collision
    @Test
    public void noCollisionW_Point(){
        boat_before = new Point2D.Double(501, 400);
        boat_after = new Point2D.Double(501, 600);
        assert(!slW.isPointColling(boat_before));
        assert(!slW.isPointColling(boat_after));
        assert(!slW.isColliding(boat_before, boat_after));
    }

    @Test
    public void noCollisionE_Point(){
        boat_before = new Point2D.Double(499, 400);
        boat_after = new Point2D.Double(499, 600);
        assert(!slE.isPointColling(boat_before));
        assert(!slE.isPointColling(boat_after));
        assert(!slE.isColliding(boat_before, boat_after));
    }

    @Test
    public void noCollisionN_Point(){
        boat_before = new Point2D.Double(400, 501);
        boat_after = new Point2D.Double(600, 501);
        assert(!slN.isPointColling(boat_before));
        assert(!slN.isPointColling(boat_after));
        assert(!slN.isColliding(boat_before, boat_after));
    }

    @Test
    public void noCollisionS_Point(){
        boat_before = new Point2D.Double(400, 499);
        boat_after = new Point2D.Double(600, 499);
        assert(!slS.isPointColling(boat_before));
        assert(!slS.isPointColling(boat_after));
        assert(!slS.isColliding(boat_before, boat_after));
    }

    // Collision

    @Test
    public void CollisionW_Point(){
        boat_before = new Point2D.Double(499, 400);
        boat_after = new Point2D.Double(499, 600);
        assert(slW.isPointColling(boat_before));
        assert(slW.isPointColling(boat_after));
        assert(slW.isColliding(boat_before, boat_after));
    }

    @Test
    public void CollisionE_Point(){
        boat_before = new Point2D.Double(501, 400);
        boat_after = new Point2D.Double(501, 600);
        assert(slE.isPointColling(boat_before));
        assert(slE.isPointColling(boat_after));
        assert(slE.isColliding(boat_before, boat_after));
    }

    @Test
    public void CollisionN_Point(){
        boat_before = new Point2D.Double(400, 499);
        boat_after = new Point2D.Double(600, 499);
        assert(slN.isPointColling(boat_before));
        assert(slN.isPointColling(boat_after));
        assert(slN.isColliding(boat_before, boat_after));
    }

    @Test
    public void CollisionS_Point(){
        boat_before = new Point2D.Double(400, 501);
        boat_after = new Point2D.Double(600, 501);
        assert(slS.isPointColling(boat_before));
        assert(slS.isPointColling(boat_after));
        assert(slS.isColliding(boat_before, boat_after));
    }
}
