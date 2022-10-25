package fr.ensicaen.elgama.model.game_board;

public interface IBoardElementVisitor {
    Object visit(Buoy buoy, Object o);

    Object visit(Shoreline sl, Object o);

    Object visit(CheckPoint cp, Object o);
}
