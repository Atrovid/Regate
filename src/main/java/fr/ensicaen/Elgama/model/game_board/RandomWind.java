package fr.ensicaen.Elgama.model.game_board;

// FIXME beaucoup de lignes vides inutiles -> augmentent la longueur du fichier à éditer inutilement
import java.awt.geom.Point2D;

public class RandomWind implements IWind {

    float _force; // FIXME force en anglais ?

    Point2D _dir; // FIXME dir pour directory ou direction ? Un identificateur doit être explicite.

    public RandomWind() {
        _force = (float) (16.0 * Math.random());

        _dir = createWindDirection();
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
        double _x = Math.random(); // FIXME revoir la règle de nommage des variables
        double _y = Math.random();

        // FIXME revoir la règle de nommage des variables
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
