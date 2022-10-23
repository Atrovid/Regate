package fr.ensicaen.Elgama.presenter;

import fr.ensicaen.Elgama.model.WaterBody;

import java.awt.geom.Point2D;

public interface IGameView {
    void addBoat( double x, double y );

    void drawWaterBody(WaterBody map);

    void updateBoat(double dx, double dy, double angle );

    void setWind(Point2D direction);
}
