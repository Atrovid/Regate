package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;

public class RandomWind implements IWind {

    float _strength;
    Point2D _direction;

    public RandomWind() {
        _strength = (float) (16.0 * Math.random());
        _direction = createWindDirection();
    }

    @Override
    public float getWindForce() {
        return _strength;
    }

    @Override
    public Point2D getWindDirection() {
        return _direction;
    }

    public Point2D createWindDirection() {
        double x = Math.random();
        double y = Math.random();
        Point2D WindDirection = new Point2D.Double(randomToDirection(x),
                randomToDirection(y));
        return normalize(WindDirection);
    }

    private double randomToDirection(double rd) {
        if (rd < 0.33) {
            return -1;
        } else if (rd > 0.67) {
            return 1;
        } else {
            return 0;
        }
    }

    private Point2D normalize(Point2D p) {
        double x = p.getX();
        double y = p.getY();
        double norm = p.distance(0, 0);
        return new Point2D.Double(x / norm, y / norm);
    }

}
