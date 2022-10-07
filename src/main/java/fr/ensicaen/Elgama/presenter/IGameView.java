package fr.ensicaen.Elgama.presenter;

import java.awt.geom.Point2D;

public interface IGameView {
    void addBoat( double x, double y );

    void addBuoy( double x, double y );

    void updateBoat(double dx, double dy, double angle );

    void setWind(Point2D direction);
}
