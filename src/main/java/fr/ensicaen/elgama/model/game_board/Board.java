package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;

public class Board {
    private final IWind _wind;
    private final Shoreline _shore;
    private final Buoy[] _buoyList;
    private final CheckPoint[] _checkPointList;

    public Board(IWind wind, Shoreline shore, Buoy[] buoyList, CheckPoint[] checkPointList) {
        _wind = wind;
        _shore = shore;
        _buoyList = buoyList;
        _checkPointList = checkPointList;
    }

    public Point2D getWindDirection() {
        return _wind.getWindDirection();
    }

    public float getWindForce() { return _wind.getWindStrength(); }

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
