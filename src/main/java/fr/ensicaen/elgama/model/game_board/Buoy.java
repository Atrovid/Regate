package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;

public class Buoy implements IBoardElement {
    private final Point2D _pos;
    private final int _radius;

    public Buoy(Point2D pos, int radius) {
        _pos = pos;
        _radius = radius;
    }

    public Point2D getPos() {
        return _pos;
    }

    public int getRadius() {
        return _radius;
    }

    @Override
    public boolean isColliding(Point2D from, Point2D to) {
        double dist = (int) from.distance(to);
        if (dist == 0) {
            return isPointColliding(from);
        }
        Point2D tempFrom = new Point2D(from.getX(),from.getY());
        double incrementX = (to.getX() - from.getX()) / dist;
        double incrementY = (to.getY() - from.getY()) / dist;
        for (int i = 0; i < dist; i++) {
            double x = tempFrom.getX() + incrementX;
            double y = tempFrom.getY() + incrementY;
            tempFrom = new Point2D(x,y);
            if (isPointColliding(tempFrom)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointColliding(Point2D point) {
        return (point.distance(_pos) <= _radius);
    }
}
