package fr.ensicaen.Elgama.model;


import java.awt.geom.Point2D;

public class RandomWind implements Wind {
    @Override
    public float getWindForce() {
        float _force;
        _force = (float) (16.0 * Math.random());
        return _force;
    }

    @Override
    public Point2D getWindDirection() {
        double _x = Math.random();
        double _y = Math.random();

        return new Point2D.Double(RandomToDirection(_x),
                RandomToDirection(_y));
    }

    private double RandomToDirection(double rd) {
        if(rd<0.33) {
            return -1;
        }else if(rd>0.67) {
            return 1;
        }else{
            return 0;
        }
    }

}
