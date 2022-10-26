package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;

public interface IWind {
    float getWindStrength();
    Point2D getWindDirection();
}
