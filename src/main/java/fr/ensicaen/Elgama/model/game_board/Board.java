package fr.ensicaen.Elgama.model.game_board;

import java.awt.geom.Point2D;

public class Board {

    IWind _wind;
    Shoreline _shore;
    Buoy[] _buoyList;
    CheckPoint[] _checkPointList;

    public Board(IWind wind, Shoreline shore, Buoy[] buoyList, CheckPoint[] checkPointList) {
        _wind = wind;
        _shore = shore;
        _buoyList = buoyList;
        _checkPointList = checkPointList;
    }



    public Point2D getWindDirection() {
        return _wind.getWindDirection();
    }

    public float getWindForce() { return _wind.getWindForce(); }

    public Object accept(IBoardElementVisitor visitor, Object o) {
        Object result = _shore.accept(visitor, o);
        for (Buoy b : _buoyList) {
            result = b.accept(visitor, result);
        }
        for (CheckPoint cp : _checkPointList) {
            result = cp.accept(visitor, result);
        }
        return result;
    }
}
