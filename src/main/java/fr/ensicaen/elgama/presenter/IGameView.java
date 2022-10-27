package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.model.game_board.Board;

import java.awt.geom.Point2D;

public interface IGameView {
    void addBoat(double x, double y);

    void drawWaterBody(Board map);

    void updateBoat(double dx, double dy, double angle);
    void updateTimer(String minutes, String seconds, String milliseconds);

    void setWind(double direction, float strength);

    void close();
}
