package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class CheckPoint implements IBoardElement {
    private final Line2D line;

    public CheckPoint(Point2D point1, Point2D point2) {
        line = new Line2D.Double(point1, point2);
    }

    public boolean isColliding(Point2D from, Point2D to) {
        Line2D.Double trajectory = new Line2D.Double(from, to);
        return line.intersectsLine(trajectory);
    }

    @Override
    public Object accept(IBoardElementVisitor visitor, Object o) {
        return visitor.visit(this, o);
    }


}
