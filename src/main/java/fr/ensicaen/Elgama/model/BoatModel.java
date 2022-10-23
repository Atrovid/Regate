package fr.ensicaen.Elgama.model;

import java.awt.geom.Point2D;


public class BoatModel {
    private double _x = 580;
    private double _y = 480;
    private double _dx = 0;
    private double _dy = 0;
    private int _anglePositive = 0;

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public void rotate(int angle) {
        _anglePositive = (360 + _anglePositive + angle) % 360;
    }

    public double getAngle() {
        return _anglePositive;
    }

    public double getDx() {
        return _dx;
    }

    public double getDy() {
        return _dy;
    }

    public void move() {
        _dx = Math.sin(_anglePositive * Math.PI / 180);

        _dy = -Math.cos(_anglePositive * Math.PI / 180);

        _x += _dx;
        _y += _dy;
    }

    public double scalarProduct(Point2D vector) {
        return vector.getX() * _dx + vector.getY() * _dy;
    }

    public double productBetweenNorm(Point2D vector) {
        return Math.sqrt(vector.getX() * vector.getX() + vector.getY() * vector.getY()) * Math.sqrt(_dx * _dx + _dy * _dy);
    }


    public double angleBetweenWindAndBoat( Point2D wind )
    {
        return Math.PI * Math.acos( scalarProduct( wind ) / productBetweenNorm( wind ) ) / 180;
    }


    public double getBoatSpeed( PolReader speedTable, IWind wind )
    {
        double data[][] = speedTable.loadData();
        double strength = wind.getWindForce();
        double angle = angleBetweenWindAndBoat( wind.getWindDirection() );

        strength = strength / 2 - 1;
        if ( strength > 14 ) {
            strength = 14;
        } else if ( strength < 0 ) {
            strength = 0;
        }
        angle = angle /10;
        if ( angle > 18 ) {
            angle = 18;
        }

        return data[(int)angle][(int)strength];
    }
}
