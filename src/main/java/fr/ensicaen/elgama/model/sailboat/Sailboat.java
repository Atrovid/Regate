package fr.ensicaen.elgama.model.sailboat;

import fr.ensicaen.elgama.model.game_board.Board;
import javafx.geometry.Point2D;

public class Sailboat  {
    private final SailboatNavigation _sailboatNavigation;

    public Sailboat( Board board, PolarReader.PolarType polarType ) {
//        _board = board;
//        _sailboatPolar = new SailboatPolar( polarType );
        _sailboatNavigation = new SailboatNavigation( board, polarType );
    }

    public void move() {
        _sailboatNavigation.moveForward();
    }

    public Point2D getPosition() {
        return _sailboatNavigation.getPosition();
    }

    public Point2D getDirection() {
        return _sailboatNavigation.getDirection();
    }
    public void setDirection( double angle ) {
        _sailboatNavigation.setDirection( angle );
    }


}
