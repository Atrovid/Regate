package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;

import java.awt.geom.Line2D;

public class CheckPoint implements IBoardElement {
    private final Point2D _point1;
    private final Point2D _point2;
    private final Line2D line;

    public CheckPoint(Point2D point1, Point2D point2) {
        _point1 = point1;
        _point2 = point2;
        line = new Line2D.Double(new java.awt.geom.Point2D.Double(point1.getX(), point1.getY()),
                new java.awt.geom.Point2D.Double(point2.getX(), point2.getY()));
    }

    public Point2D getPoint1() {
        return _point1;
    }

    public Point2D getPoint2() {
        return _point2;
    }

    public boolean isColliding(Point2D from, Point2D to) {
        Line2D.Double trajectory = new Line2D.Double(new java.awt.geom.Point2D.Double(from.getX(), from.getY()),
                new java.awt.geom.Point2D.Double(to.getX(), to.getY()));
        return line.intersectsLine(trajectory);
    }
}
