package fr.ensicaen.elgama.model.sailboat;

import fr.ensicaen.elgama.model.game_board.Board;
import javafx.geometry.Point2D;

public class SailboatNavigation {
    private final Board _board;
    private final SailboatPolar _sailboatPolar;
    private Point2D _position;
    private Point2D _direction = new Point2D(0, -1);
    private Point2D _speed = new Point2D(0, -1);

    public SailboatNavigation(Board board, PolarReader.PolarType polarType) {
        _board = board;
        _sailboatPolar = new SailboatPolar(polarType);
        _position = new Point2D(board.getStartingPosition().getX(), board.getStartingPosition().getY());
    }

    public Point2D getPosition() {
        return _position;
    }

    public Point2D getSpeed() {
        return _speed;
    }

    public double getAngle() {
        Point2D initialDirection = new Point2D(0, -1);
        double sign = Math.signum(_direction.crossProduct(initialDirection).getZ());
        double angle = -Math.copySign(initialDirection.angle(_direction), sign);
        return (angle + 360) % 360;
    }

    public void changeDirection(double angleOffset) {
        _direction = new Point2D(_direction.getX() * Math.cos(angleOffset) - _direction.getY() * Math.sin(angleOffset), _direction.getX() * Math.sin(angleOffset) + _direction.getY() * Math.cos(angleOffset));
    }

    public void moveForward() {
        Point2D windDir = _board.getWindDirection();
        double angle = _direction.angle(windDir.getX(), windDir.getY());
        double diffAngle = 180 - angle;
        _speed = _direction.multiply(_sailboatPolar.getMaxSpeed(diffAngle, _board.getWindStrength()));
        Point2D futurePos = _position.add(_speed);
        if (_board.isMovePossible(_position, futurePos)) {
            _position = futurePos;
        } else {
            _speed = _speed.multiply(0);
        }
    }
}
