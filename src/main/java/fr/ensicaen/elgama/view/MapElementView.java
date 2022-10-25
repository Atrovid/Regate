package fr.ensicaen.elgama.view;

// FIXME HORREUR !!!! IL y a un couplage entre la vue et le modèle
import fr.ensicaen.elgama.model.game_board.Buoy;
import fr.ensicaen.elgama.model.game_board.CheckPoint;
import fr.ensicaen.elgama.model.game_board.IBoardElementVisitor;
import fr.ensicaen.elgama.model.game_board.Shoreline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

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
    public Object visit(Shoreline sl, Object o) { //Replace 5000 by else (FIXME c'est quoi ce message en commentaire ?)
        // FIXME : il ne faut mettre aucune logique dans une vue.
        Rectangle rect = new Rectangle();
        if (sl.isVertical()){
            rect.setY(0.0);
            if(sl.isSuperior()){//East (FIXME ce commentaire rend compte d'un manque de proprété du code -> refondre ce code).
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
