package fr.ensicaen.elgama.model.sailboat;

import fr.ensicaen.elgama.model.game_board.Board;
import javafx.geometry.Point2D;

import javax.swing.*;

public class SailboatNavigation {
    private Point2D _position = new Point2D( 580, 480);
    private Point2D _direction = new Point2D( 0, 0);
    private Board _board;
    private PolarReader.PolarType _polarType;
    private SailboatPolar _sailboatPolar;

    public SailboatNavigation( Board board, PolarReader.PolarType polarType ) {
        _board = board;
        _polarType = polarType;
        _sailboatPolar = new SailboatPolar( polarType );
    }

    public void setDirection( double angle ) {
        _direction = new Point2D(Math.sin(angle * Math.PI / 180), -Math.cos(angle * Math.PI / 180));
    }

    public Point2D getPosition() {return _position;}

    public Point2D getDirection() {return _direction;}



}
