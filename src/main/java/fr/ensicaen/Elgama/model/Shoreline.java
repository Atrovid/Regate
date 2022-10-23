package fr.ensicaen.Elgama.model;

import java.awt.geom.Point2D;

public class Shoreline implements IMapElement {
    private final int pos;
    private final boolean vertical;
    private final boolean superior;

    public int getPos() {
        return pos;
    }

    public boolean isVertical() {
        return vertical;
    }

    public boolean isSuperior() {
        return superior;
    }

    public Shoreline(int position, char direction){
        pos = position;
        switch (direction) {
            case 'n' -> {
                vertical = false;
                superior = false;
            }
            case 's' -> {
                vertical = false;
                superior = true;
            }
            case 'e' -> {
                vertical = true;
                superior = true;
            }
            default -> { // 'w'
                vertical = true;
                superior = false;
            }
        }
    }

    @Override
    public boolean isColliding(Point2D from, Point2D to) {
        return(isPointColling(from) || isPointColling(to));
    }

    public boolean isPointColling(Point2D p){
        if(vertical){
            if(superior){
                return p.getX() > pos; // East
            }else{
                return p.getX() < pos; // West
            }
        }else{
            if(superior){
                return p.getY() > pos; // South
            }else{
                return p.getY() < pos; // North
            }
        }
    }

    @Override
    public Object accept(IMapElementVisitor visitor, Object o) {
        return visitor.visit(this, o);
    }

}
