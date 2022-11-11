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
        return new Point2D(530,530);
    }

    public double getWindAngle() {
        return  _wind.getWindDirectionDouble();
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

    public Shoreline getShoreline() {
        return _shore;
    }

    public Buoy[] getBuoys() {
        return _buoyList;
    }

    public CheckPointIterator getCheckpoints() {
        return new CheckPointIterator(_checkPointList);
    }
}
