package fr.ensicaen.elgama.model;

import fr.ensicaen.elgama.model.game_board.Board;
import fr.ensicaen.elgama.model.game_board.IWind;
import fr.ensicaen.elgama.model.sailboat.PolarReader;

import java.awt.geom.Point2D;


public class BoatModel {
    private double _x = 580;
    private double _y = 480;
    private double _dx = 0;
    private double _dy = 0;
    private int _anglePositive = 0;
    private Board _board; // FIXME donnée membre jamais utilisée.

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

    public void move() { // FIXME supprimer ces lignes vides qui ne font qu'augmenter la taille du fichier sans rien apporter
        _dx = Math.sin(_anglePositive * Math.PI / 180);

        _dy = -Math.cos(_anglePositive * Math.PI / 180);

        _x += _dx;
        _y += _dy;
    }

    public void move( PolarReader speedTable, IWind wind) {

        if ( Math.abs( _dx ) < getBoatSpeed( speedTable, wind) ) {
            _dx += getBoatSpeed( speedTable, wind)*Math.sin(_anglePositive * Math.PI / 180);
        } else {
            _dx = Math.sin(_anglePositive * Math.PI / 180);
        }
        if ( Math.abs( _dy ) < getBoatSpeed( speedTable, wind) ) {
            _dy += getBoatSpeed( speedTable, wind)*Math.cos(_anglePositive * Math.PI / 180);
        } else {
            _dy = Math.cos(_anglePositive * Math.PI / 180);
        }

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

    // FIXME qu'est-ce que ce formatage non Java (l'accolade doit être à la fin de la déclaration)
    public double getBoatSpeed(PolarReader speedTable, IWind wind)
    {
        double data[][] = speedTable.loadData();
        float strength = wind.getWindForce();
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
