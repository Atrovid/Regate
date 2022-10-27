package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomWind extends Wind {

    final private float _strength;

    final private Point2D _direction;

    public RandomWind() {
        _strength = (float) Math.round((16.0 * Math.random()) * 100) / 100;
        _direction = createWindDirection();
    }

    @Override
    public float getWindStrength() {
        return _strength;
    }

    @Override
    public Point2D getWindDirectionPoint2D() {
        return _direction;
    }

    @Override
    public double getWindDirectionDouble() {
        return Wind.windDirectionAngle(_direction);
    }

    public Point2D createWindDirection() {
        Point2D E = new Point2D.Double(1.0,0.0);
        Point2D NE = new Point2D.Double(1.0,1.0);
        Point2D N = new Point2D.Double(0.0,1.0);
        Point2D NO = new Point2D.Double(-1.0,1.0);
        Point2D O = new Point2D.Double(-1.0,0.0);
        Point2D SO = new Point2D.Double(-1.0,-1.0);
        Point2D S = new Point2D.Double(0.0,-1.0);
        Point2D SE = new Point2D.Double(1.0,-1.0);

        List<Point2D> listOfPoints = new ArrayList<>();
        Collections.addAll(listOfPoints, E, NE, N, NO, O, SO, S, SE);

        int randomChoice = (int) (7 * Math.random());
        return normalize(listOfPoints.get(randomChoice));
    }

    private Point2D normalize(Point2D p){
        double x = p.getX();
        double y = p.getY();
        double norm = p.distance(0, 0);
        return new Point2D.Double(x / norm, y / norm);
    }

}
