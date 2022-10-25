package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;

public interface IWind {
    float getWindForce();
    Point2D getWindDirection();
}
