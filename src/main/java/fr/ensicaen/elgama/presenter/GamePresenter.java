package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.Main;
import fr.ensicaen.elgama.model.game_board.Board;
import fr.ensicaen.elgama.model.game_board.Buoy;
import fr.ensicaen.elgama.model.game_board.CheckPoint;
import fr.ensicaen.elgama.model.game_board.Shoreline;
import fr.ensicaen.elgama.model.race_manager.BoatCheckPointTracker;
import fr.ensicaen.elgama.model.race_manager.Timer;
import fr.ensicaen.elgama.model.sailboat.Sailboat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class GamePresenter {
    private final Sailboat _sailboat;
    private final Board _board;
    private final BoatCheckPointTracker _boatCheckPointTracker;
    private IGameView _gameView;
    private boolean _started = false;
    private Timer _timer;
    private Timeline _timeline;

    public GamePresenter(Board board, Sailboat sailboat) {
        _board = board;
        _sailboat = sailboat;
        _boatCheckPointTracker = new BoatCheckPointTracker(_sailboat, _board.getCheckpoints());
    }

    public void setGameView(IGameView gameView) {
        _gameView = gameView;
        displayBoard();
        _gameView.addBoat(_sailboat.getPosition());
        _gameView.setWind(_board.getWindAngle(), _board.getWindStrength());
    }

    private void displayBoard() {
        drawShoreline(_board.getShoreline());
        for (Buoy buoy : _board.getBuoys()) {
            drawBuoy(buoy);
        }
        drawNextCheckPoint();
    }

    public void drawBuoy(Buoy buoy) {
        _gameView.drawBuoy(buoy.getPos(), buoy.getRadius());
    }

    public void drawShoreline(Shoreline shoreline) {
        _gameView.drawShoreline(shoreline.getPointsAsDoubleArray());
    }

    public void drawNextCheckPoint() {
        _gameView.removeAllCheckPoints();
        CheckPoint nextCheckPoint = _boatCheckPointTracker.getNextCheckPoint();
        _gameView.drawCheckPoint(nextCheckPoint.getPoint1(), nextCheckPoint.getPoint2());
    }

    public void handleUserAction(UserAction code) {
        if (code == UserAction.START) {
            startGame();
        } else {
            changeDirection(code);
        }
    }

    private void startGame() {
        if (!_started) {
            _started = true;
            _timer = new Timer();
            runGameLoop();
        }
    }

    private void changeDirection(UserAction action) {
        if (action == UserAction.LEFT) {
            _sailboat.changeDirection(-2 * Math.PI / 180);
        } else if (action == UserAction.RIGHT) {
            _sailboat.changeDirection(2 * Math.PI / 180);
        }
    }

    private void runGameLoop() {
        _timeline = new Timeline(new KeyFrame(Duration.millis(50), onFinished -> {
            update();
            render();
        }));
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();
    }

    private void update() {
        _sailboat.move();
        _timer.updateTimer();
        if (_boatCheckPointTracker.isFinished()) {
            _timeline.stop();
            endGame();
        } else {
            drawNextCheckPoint();
        }
    }

    private void render() {
        _gameView.updateBoat(_sailboat.getSpeed().getX(), _sailboat.getSpeed().getY(), _sailboat.getAngle());
        _gameView.updateTimer(
                String.format("%02d", _timer.getMinute()),
                String.format("%02d", _timer.getSecond()),
                String.format("%03d", _timer.getMilliSecond()));
    }

    private void endGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Main.getMessageBundle().getString("game.endTitle"));
        alert.setHeaderText(Main.getMessageBundle().getString("game.endHeader"));
        String time = "%02d:%02d:%03d".formatted(_timer.getMinute(), _timer.getSecond(), _timer.getMilliSecond());
        alert.setContentText(Main.getMessageBundle().getString("game.endContent") + time);
        alert.setOnCloseRequest(event -> _gameView.close());
        alert.show();
    }
}
