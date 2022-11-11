package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.Main;
import fr.ensicaen.elgama.model.game_board.*;
import fr.ensicaen.elgama.model.sailboat.Sailboat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import java.util.Optional;

public class GamePresenter {
    private final Sailboat _sailboat;
    private IGameView _gameView;
    private boolean _started = false;
    private final Board _board;
    private Timer _timer;

    public GamePresenter(Board board, Sailboat sailboat) {
        _board = board;
        _sailboat = sailboat;
    }

    public void setGameView(IGameView gameView) {
        _gameView = gameView;
        _gameView.addBoat(_sailboat.getPosition().getX(), _sailboat.getPosition().getY());
        _gameView.drawBoard(_board);
        _gameView.setWind(_board.getWindAngle(), _board.getWindStrength());
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
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), onFinished -> {
            update();
            render();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void update() {
        _sailboat.move();
        _timer.updateTimer();
    }

    private void render() {
        _gameView.updateBoat(_sailboat.getSpeed().getX(), _sailboat.getSpeed().getY(), _sailboat.getAngle());
        _gameView.updateTimer(String.format("%02d", _timer.getMinute()), String.format("%02d", _timer.getSecond()), String.format("%03d", _timer.getMilliSecond()));
    }

    private void endGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Main.getMessageBundle().getString("game.endTitle"));
        alert.setHeaderText(Main.getMessageBundle().getString("game.endHeader"));
        alert.setContentText(Main.getMessageBundle().getString("game.endContent"));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isEmpty() || result.get() == ButtonType.OK) {
            _gameView.close();
        }
    }
}
