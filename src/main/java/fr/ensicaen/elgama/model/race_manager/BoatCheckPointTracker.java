package fr.ensicaen.elgama.model.race_manager;

import fr.ensicaen.elgama.model.sailboat.Sailboat;
import fr.ensicaen.elgama.model.game_board.CheckPoint;
import fr.ensicaen.elgama.model.game_board.CheckPointIterator;


import javafx.geometry.Point2D;


public class BoatCheckPointTracker {
    private javafx.geometry.Point2D _lastPos;
    private final CheckPointIterator _cpIterator;
    private CheckPoint _currentCP;

    BoatCheckPointTracker(CheckPoint[] cpList ){
        _cpIterator = new CheckPointIterator(cpList);
        _lastPos = new Point2D(-1.0,-1.0);
    }

    public CheckPoint getNextCheckPoint(){
            return _cpIterator.next();
    }

    public void update(Sailboat boat) {
        javafx.geometry.Point2D boatPos = boat.getPosition();
        if (_currentCP.isColliding(_lastPos, boatPos)) {
            _currentCP = getNextCheckPoint();
        }
        _lastPos = boatPos;
    }

    public boolean isFinished(){
        return !_cpIterator.hasNext();
    }
}
