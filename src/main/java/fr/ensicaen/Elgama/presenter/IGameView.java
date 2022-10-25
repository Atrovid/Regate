package fr.ensicaen.Elgama.presenter;

import fr.ensicaen.Elgama.model.game_board.Board;

import java.awt.geom.Point2D;

public interface IGameView {
    void addBoat( double x, double y );

    void drawWaterBody(Board map);

    void updateBoat(double dx, double dy, double angle ); // FIXME pourquoi un espace avant la parenthèse finale ici et pas ailleurs ?

    void setWind(Point2D direction);
}
