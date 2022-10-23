package fr.ensicaen.Elgama.model;

public interface IMapElementVisitor {
    Object visit(Buoy buoy, Object o);
    Object visit(Shoreline sl, Object o);
    Object visit(CheckPoint cp, Object o);
}
