package fr.ensicaen.elgama.model.sailboat;

import fr.ensicaen.elgama.model.game_board.Board;
import javafx.geometry.Point2D;

public class Sailboat  {
    private Board _board;
    private SailboatPolar _sailboatPolar;
    private SailboatNavigation _sailboatNavigation;

    public Sailboat( Board board, PolarReader.PolarType polarType ) {
        _board = board;
        _sailboatPolar = new SailboatPolar( polarType );
        _sailboatNavigation = new SailboatNavigation( board, polarType );
    }

//    public void setDirection(Point2D direction ) {
//        _sailboatNavigation.setDirection( direction );
//    }


}
