package fr.ensicaen.elgama.presenter;

import javafx.geometry.Point2D;

public interface IGameView {
    void addBoat(Point2D boatPosition);

    void drawShoreline(double[] polygonVertices);

    void drawBuoy(Point2D center, int radius);

    void drawCheckPoint(Point2D p1, Point2D p2);

    void removeAllCheckPoints();

    void updateBoat(double dx, double dy, double angle);

    void updateTimer(String minutes, String seconds, String milliseconds);

    void setWind(double direction, float strength);

    void close();
}
