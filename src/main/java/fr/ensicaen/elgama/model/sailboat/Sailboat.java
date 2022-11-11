package fr.ensicaen.elgama.model.sailboat;

import fr.ensicaen.elgama.model.game_board.Board;
import javafx.geometry.Point2D;
import java.util.ArrayList;

public class Sailboat  {
    private final SailboatNavigation _sailboatNavigation;
    private final ArrayList<ISailboatObserver> _observers = new ArrayList<>();

    public Sailboat( Board board, PolarReader.PolarType polarType ) {
        _sailboatNavigation = new SailboatNavigation( board, polarType );
    }

    public void move() {
        _sailboatNavigation.moveForward();
        notifyObservers();
    }

    public void observe(ISailboatObserver observer) {
        _observers.add(observer);
    }

    private void notifyObservers() {
        for (ISailboatObserver observer: _observers) {
            observer.update(this);
        }
    }

    public Point2D getPosition() {
        return _sailboatNavigation.getPosition();
    }

    public Point2D getSpeed() {
        return _sailboatNavigation.getSpeed();
    }

    public double getAngle() {return _sailboatNavigation.getAngle();}

    public void changeDirection( double angle ) {
        _sailboatNavigation.changeDirection( angle );
    }


}
