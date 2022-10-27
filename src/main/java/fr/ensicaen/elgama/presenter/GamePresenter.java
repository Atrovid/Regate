package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.model.PlayerModel;
import fr.ensicaen.elgama.model.game_board.*;
import fr.ensicaen.elgama.model.sailboat.PolarReader;
import fr.ensicaen.elgama.model.sailboat.Sailboat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.awt.geom.Point2D;

public class GamePresenter {
    private final PlayerModel _playerModel; // TODO remove player model
    private final Wind _wind;
    private final Sailboat _sailboat;
    private IGameView _gameView;
    private boolean _started = false;
    private final Board _board;

    public GamePresenter(String nickName) {
        _playerModel = new PlayerModel();
        _playerModel.setNickname(nickName);
        _wind = new RandomWind();
        Buoy[] buoyList = {new Buoy(new Point2D.Double(500, 100), 20)};
        CheckPoint[] cpList = {};
        _board = new Board(new RandomWind(), new Shoreline(100, 'w'), buoyList, cpList);
        _sailboat = new Sailboat(_board, PolarReader.PolarType.Figaro);
    }

    public void setGameView(IGameView gameView) {
        _gameView = gameView;
        _gameView.addBoat(_sailboat.getPosition().getX(), _sailboat.getPosition().getY());

        _gameView.drawWaterBody(_board);
        _gameView.setWind(_wind.getWindDirectionDouble(), _wind.getWindStrength());
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
        Timeline _timeline = new Timeline(new KeyFrame(Duration.millis(50), onFinished -> {
            update();
            render();
        }));
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();
    }

    private void update() {
        _sailboat.move();
    }

    //TODO don't forget to delete the angle (refactor)
    private void render() {
        _gameView.updateBoat( _sailboat.getSpeed().getX(), _sailboat.getSpeed().getY(), _sailboat.getAngle());
    }
}
