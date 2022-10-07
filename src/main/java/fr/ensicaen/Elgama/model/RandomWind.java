package fr.ensicaen.Elgama.model;


import java.awt.geom.Point2D;

public class RandomWind implements IWind {

    final float _force;

    final Point2D _dir;

    public RandomWind() {
        this._force = (float) (16.0 * Math.random());
        this._dir = createWindDirection();
    }

    @Override
    public float getWindForce() {
        return _force;
    }
    @Override
    public Point2D getWindDirection() {
        return _dir;
    }

    public Point2D createWindDirection() {
        double _x = Math.random();
        double _y = Math.random();
        Point2D WindDir = new Point2D.Double(randomToDirection(_x),
                randomToDirection(_y));
        return normalize(WindDir);
    }

    private double randomToDirection(double rd) {
        if(rd<0.33) {
            return -1;
        }else if(rd>0.67) {
            return 1;
        }else{
            return 0;
        }
    }
    private Point2D normalize(Point2D p){
        double x = p.getX();
        double y = p.getY();
        double norm = p.distance(0,0);
        return new Point2D.Double(x / norm, y / norm);

    }

}
