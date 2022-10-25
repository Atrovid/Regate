package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;

public class Buoy implements IBoardElement {
    private final Point2D _pos;
    private final int _radius;

    public Point2D getPos() {
        return _pos;
    }

    public int getRadius() {
        return _radius;
    }

    public Buoy(Point2D pos, int radius) {
        _pos = pos;
        _radius = radius;
    }

    @Override
    public boolean isColliding(Point2D from, Point2D to) {
        double dist = (int) from.distance(to);

        if (dist == 0) {
            return isPointColliding(from);
        }
        double incrementX = (to.getX() - from.getX()) / dist;
        double incrementY = (to.getY() - from.getY()) / dist;

        for (int i = 0; i < dist; i++) {
            double x = from.getX() + incrementX;
            double y = from.getY() + incrementY;
            from.setLocation((int) x, (int) y);
            if (isPointColliding(from)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointColliding(Point2D point) {
        return (point.distance(_pos) <= _radius);
    }

    @Override
    public Object accept(IBoardElementVisitor visitor, Object o) {
        return visitor.visit(this, o);
    }

}
