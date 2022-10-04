package fr.ensicaen.Elgama.model;

import java.awt.geom.Point2D;

public interface MapElement {
    boolean isColliding(Point2D from, Point2D to);
}
