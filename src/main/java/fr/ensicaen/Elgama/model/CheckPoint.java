package fr.ensicaen.Elgama.model;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class CheckPoint implements IMapElement{
    private final Point2D p1, p2;
    private final Line2D line;


    public CheckPoint(Point2D point1, Point2D point2) { // Should create exception if p1 = p2
        p1 = point1;
        p2 = point2;
        line = new Line2D.Double(p1, p2);
    }

    public boolean isColliding(Point2D from, Point2D to){
        Line2D.Double trajectory = new Line2D.Double(from, to);
        return line.intersectsLine(trajectory);
    }
}
