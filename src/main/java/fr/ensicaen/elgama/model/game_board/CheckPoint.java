package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Line2D;
import javafx.geometry.Point2D;

public class CheckPoint implements IBoardElement {
    private final Line2D line;

    public CheckPoint(Point2D point1, Point2D point2) {
        line = new Line2D.Double(new java.awt.geom.Point2D.Double(point1.getX(),point1.getY()),
                new java.awt.geom.Point2D.Double(point2.getX(),point2.getY()));
    }

    public boolean isColliding(Point2D from, Point2D to) {
        Line2D.Double trajectory = new Line2D.Double(new java.awt.geom.Point2D.Double(from.getX(),from.getY()),
                new java.awt.geom.Point2D.Double(to.getX(),to.getY()));
        return line.intersectsLine(trajectory);
    }

    @Override
    public Object accept(IBoardElementVisitor visitor, Object o) {
        return visitor.visit(this, o);
    }


}
