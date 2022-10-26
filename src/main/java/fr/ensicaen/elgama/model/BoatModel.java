package fr.ensicaen.elgama.model;

import fr.ensicaen.elgama.model.game_board.Wind;
import fr.ensicaen.elgama.model.sailboat.PolarReader;

import javafx.geometry.Point2D;


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

    public void move(PolarReader speedTable, Wind wind) {
        Point2D speedDir = angleToVector(_anglePositive);
        Point2D speed = speedDir.multiply(getBoatSpeed(speedTable, wind));
        _dx = speed.getX();
        _dy = speed.getY();
        _x += _dx;
        _y += _dy;
    }

    public Point2D angleToVector(int angle) {
        return new Point2D(Math.sin(angle * Math.PI / 180), -Math.cos(angle * Math.PI / 180));
    }

    public double getBoatSpeed(PolarReader speedTable, Wind wind) {
        float strength = wind.getWindStrength();
        int strengthRounded;
        if (strength > 30) {
            strengthRounded = 30;
        } else if (strength < 4) {
            strengthRounded = 4;
        } else {
            strengthRounded = Math.round(strength / 2) * 2;
        }
        int strengthIndex = strengthRounded / 2 - 2;

        java.awt.geom.Point2D windDir = wind.getWindDirectionPoint2D();
        Point2D boatDir = angleToVector(_anglePositive);
        double diffAngle = 180 - boatDir.angle(windDir.getX(), windDir.getY());
        int angleRounded = (int) Math.round(diffAngle / 10) * 10;
        int angleIndex = angleRounded / 10;

        double[][] data = speedTable.loadData();
        return data[angleIndex][strengthIndex];
    }
}
