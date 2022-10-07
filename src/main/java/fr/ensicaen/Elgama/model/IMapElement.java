package fr.ensicaen.Elgama.model;

import java.awt.geom.Point2D;

public interface IMapElement {
    boolean isColliding(Point2D from, Point2D to);
    Object accept(IMapElementVisitor visitor, Object o);

}
