package fr.ensicaen.elgama.model.race_manager;

import fr.ensicaen.elgama.model.game_board.CheckPoint;
import fr.ensicaen.elgama.model.game_board.CheckPointIterator;
import fr.ensicaen.elgama.model.sailboat.ISailboatObserver;
import fr.ensicaen.elgama.model.sailboat.Sailboat;
import javafx.geometry.Point2D;

public class BoatCheckPointTracker implements ISailboatObserver {
    private final CheckPointIterator _checkPointIterator;
    private Point2D _boatLastPosition;
    private CheckPoint _currentCheckPoint;
    private boolean _finished;

    public BoatCheckPointTracker(Sailboat sailboatTracked, CheckPointIterator checkPointIterator) {
        _checkPointIterator = checkPointIterator;
        _currentCheckPoint = _checkPointIterator.next();
        sailboatTracked.observe(this);
        _boatLastPosition = sailboatTracked.getPosition();
        _finished = false;
    }

    @Override
    public void update(Sailboat boat) {
        if (_finished) {
            return;
        }
        Point2D newBoatPosition = boat.getPosition();
        if (_currentCheckPoint.isColliding(_boatLastPosition, newBoatPosition)) {
            if (_checkPointIterator.hasNext()) {
                _currentCheckPoint = _checkPointIterator.next();
            } else {
                _finished = true;
            }
        }
        _boatLastPosition = newBoatPosition;
    }

    public boolean isFinished() {
        return _finished;
    }

    public CheckPoint getNextCheckPoint() {
        return _currentCheckPoint;
    }
}
