package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;

public interface IBoardElement {
    boolean isColliding(Point2D from, Point2D to);
}
