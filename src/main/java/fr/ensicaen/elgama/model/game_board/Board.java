package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;

public class Board {
    private final Wind _wind;
    private final Shoreline _shore;
    private final Buoy[] _buoyList;
    private final CheckPoint[] _checkPointList;

    public Board(Wind wind, Shoreline shore, Buoy[] buoyList, CheckPoint[] checkPointList) {
        _wind = wind;
        _shore = shore;
        _buoyList = buoyList;
        _checkPointList = checkPointList;
    }

    public Point2D getStartingPosition(){
        return new Point2D(580,480);
    }

    public Point2D getBoardSize(){
        return new Point2D(800,600);
    }

    public Point2D getWindDirection() {
        return _wind.getWindDirectionPoint2D();
    }

    public float getWindStrength() { return _wind.getWindStrength(); }

    public boolean isMovePossible(Point2D from, Point2D to) {
        if (_shore.isColliding(from,to) ) {
            return false;
        }
        for (Buoy buoy : _buoyList) {
            if (buoy.isColliding(from, to)) {
                return false;
            }
        }
        return true;
    }

    public CheckPointIterator getCheckpoints() {
        return new CheckPointIterator(_checkPointList);
    }

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
