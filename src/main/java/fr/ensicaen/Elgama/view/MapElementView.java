package fr.ensicaen.Elgama.view;

import fr.ensicaen.Elgama.model.game_board.Buoy;
import fr.ensicaen.Elgama.model.game_board.CheckPoint;
import fr.ensicaen.Elgama.model.game_board.IBoardElementVisitor;
import fr.ensicaen.Elgama.model.game_board.Shoreline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;

public class MapElementView implements IBoardElementVisitor {
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
        Polygon polygon = new Polygon(sl.getPointsAsDoubleArray());
        polygon.setFill(Color.YELLOW);
        _base.getChildren().add(polygon);
        return null;
    }

    @Override
    public Object visit(CheckPoint cp, Object o) {
        return null;
    }
}
