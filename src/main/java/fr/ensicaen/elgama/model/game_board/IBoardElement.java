package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;

public interface IBoardElement {
    boolean isColliding(javafx.geometry.Point2D from, javafx.geometry.Point2D to);

    Object accept(IBoardElementVisitor visitor, Object o);
}
