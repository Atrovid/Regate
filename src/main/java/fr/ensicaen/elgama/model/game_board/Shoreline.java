package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Shoreline implements IBoardElement {
    private final ArrayList<Point2D> _points;
    private final ArrayList<Line2D> _lines = new ArrayList<>();

    public Shoreline(ArrayList<Point2D> points) {
        _points = new ArrayList<>(points);
        for(int i = 0 ; i < points.size() - 1 ; i++){
            _lines.add(new Line2D.Double(_points.get(i), _points.get(i+1)));
        }
        _lines.add(new Line2D.Double(_points.get(0), _points.get(_points.size()-1)));
    }

    @Override
    public boolean isColliding(Point2D from, Point2D to) {
        Line2D trajectory = new Line2D.Double(from, to);
        for (Line2D line : _lines) {
            if (isCrossingLine(trajectory, line)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCrossingLine(Line2D trajectory, Line2D line){
        return trajectory.intersectsLine(line);
    }

    public double[] getPointsAsDoubleArray(){
        double[] array = new double[2 * _points.size()];
        for(int i = 0 ; i < _points.size() ; i++){
            array[2 * i] = _points.get(i).getX();
            array[2 * i + 1] = _points.get(i).getY();
        }
        return array;
    }

    @Override
    public Object accept(IBoardElementVisitor visitor, Object o) {
        return visitor.visit(this, o);
    }

}
