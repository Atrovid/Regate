package fr.ensicaen.Elgama.model;

import com.sun.javafx.geom.Point2D;

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

    public double scalar(Point2D vector) {
        return vector.x * _dx + vector.y * _dy;
    }

    public double vectorialBetweenVectors(Point2D vector) {
        return Math.sqrt(vector.x * vector.x + vector.y + vector.y) * Math.sqrt(_dx * _dx + _dy + _dy);
    }




}


/* Creer une méthode qui prend un argument à partir d'une classe vent :point2D, angle du bateau et modifier la vitesse
    du bateau selon le vent

    PolReader
 */
