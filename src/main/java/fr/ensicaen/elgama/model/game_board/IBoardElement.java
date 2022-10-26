package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;

public interface IBoardElement {
    boolean isColliding(Point2D from, Point2D to);

    Object accept(IBoardElementVisitor visitor, Object o);
}
