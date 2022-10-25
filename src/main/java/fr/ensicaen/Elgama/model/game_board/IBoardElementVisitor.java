package fr.ensicaen.Elgama.model.game_board;
// FIXME import non utilisés
import fr.ensicaen.Elgama.model.game_board.Buoy;
import fr.ensicaen.Elgama.model.game_board.CheckPoint;
import fr.ensicaen.Elgama.model.game_board.Shoreline;

public interface IBoardElementVisitor {
    Object visit(Buoy buoy, Object o);
    Object visit(Shoreline sl, Object o);
    Object visit(CheckPoint cp, Object o);
}
