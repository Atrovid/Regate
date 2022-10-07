package fr.ensicaen.Elgama.view;

import fr.ensicaen.Elgama.model.Buoy;
import fr.ensicaen.Elgama.model.CheckPoint;
import fr.ensicaen.Elgama.model.IMapElementVisitor;
import fr.ensicaen.Elgama.model.Shoreline;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class MapElementView implements IMapElementVisitor {
    private final AnchorPane _base;

    public MapElementView(AnchorPane base) {
        _base = base;
    }

    @Override
    public Object visit(Buoy buoy, Object o) {
        Ellipse ellipse = new Ellipse(buoy.getPos().getX(), buoy.getPos().getY(), buoy.getRadius(), buoy.getRadius());
        ellipse.setFill(Color.ORANGE);
        _base.getChildren().add(ellipse);
        return null;
    }

    @Override
    public Object visit(Shoreline sl, Object o) { //Replace 5000 by else
        Rectangle rect = new Rectangle();
        if (sl.isVertical()){
            rect.setY(0.0);
            if(sl.isSuperior()){//East
                rect.setX(sl.getPos());
                rect.setWidth(5000);
                rect.setHeight(5000);
            }else{//West
                rect.setX(0.0);
                rect.setWidth(sl.getPos());
                rect.setHeight(5000);
            }
        }else{
            rect.setX(0.0);
            if(sl.isSuperior()){//South
                rect.setY(sl.getPos());
                rect.setHeight(5000);
                rect.setWidth(5000);
            }else{//North
                rect.setY(0.0);
                rect.setHeight(sl.getPos());
                rect.setWidth(5000);
            }
        }
        rect.setFill(Color.YELLOW);
        _base.getChildren().add(rect);
        return null;
    }

    @Override
    public Object visit(CheckPoint cp, Object o) {
        return null;
    }
}
