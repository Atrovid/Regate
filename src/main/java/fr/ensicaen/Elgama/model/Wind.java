package fr.ensicaen.Elgama.model;

import java.awt.geom.Point2D;

public interface Wind {
    public float getWindForce(Point2D position);
    public Point2D getWindDirection(Point2D position);

}
