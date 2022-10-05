package fr.ensicaen.Elgama.model;

import java.awt.geom.Point2D;

public interface IWind {
    float getWindForce();
    Point2D getWindDirection();
}
