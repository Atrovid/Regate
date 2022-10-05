package fr.ensicaen.Elgama.model;

import java.awt.geom.Point2D;

public class Buoy implements IMapElement {
    private final Point2D pos;
    private final int radius;

    public Buoy(Point2D pos, int radius) {
        this.pos = pos;
        this.radius = radius;
    }

    @Override
    public boolean isColliding(Point2D from, Point2D to){
        double dist = (int)from.distance(to);

        if (dist == 0){
            return isPointColliding(from);
        }
        double incrementX = (to.getX() - from.getX()) / dist;
        double incrementY = (to.getY() - from.getY()) / dist;
        Point2D p = from;

        for(int i=0 ; i<dist ; i++){
            double x = p.getX() + incrementX;
            double y = p.getY() + incrementY;
            p.setLocation((int)x, (int)y);
            if(isPointColliding(p)){
                return true;
            }
        }
        return false;
    }

    public boolean isPointColliding(Point2D point) {
        return (point.distance(pos) <= radius);
    }
}
