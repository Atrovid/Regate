package fr.ensicaen.Elgama.model.game_board;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class CheckPoint implements IBoardElement {
    private final Point2D p1, p2;
    private final Line2D line;

    public Point2D getP1() {
        return p1;
    }

    public Point2D getP2() {
        return p2;
    }

    public Line2D getLine() {
        return line;
    }

    public CheckPoint(Point2D point1, Point2D point2) {
        p1 = point1;
        p2 = point2;
        line = new Line2D.Double(p1, p2);
    }

    public boolean isColliding(Point2D from, Point2D to){
        Line2D.Double trajectory = new Line2D.Double(from, to);
        return line.intersectsLine(trajectory);
    }

    @Override
    public Object accept(IBoardElementVisitor visitor, Object o) {
        return visitor.visit(this, o);
    }


}
