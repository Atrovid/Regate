package fr.ensicaen.Elgama.model.map;

import java.awt.geom.Point2D;

public interface Wind {
    public float getWindForce();
    public Point2D getWindDirection();

}
