package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.Main;
import fr.ensicaen.elgama.model.PlayerModel;
import fr.ensicaen.elgama.model.game_board.*;
import fr.ensicaen.elgama.model.sailboat.PolarReader;
import fr.ensicaen.elgama.model.sailboat.Sailboat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.Optional;

public class GamePresenter {
    private final PlayerModel _playerModel; // TODO remove player model
    private final Wind _wind;
    private final Sailboat _sailboat;
    private IGameView _gameView;
    private boolean _started = false;
    private final Board _board;
    private Timer _timer;

    public GamePresenter(String nickName) {
        _playerModel = new PlayerModel();
        _playerModel.setNickname(nickName);
        Wind wind1;
        try {
            WeatherProxy proxy = new WeatherProxy(new Point2D(49.283,-0.25));
            wind1 = new WeatherWind(proxy);
        } catch (Exception e) {
            wind1 = new RandomWind();
        }
        _wind = wind1;
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D(0, 0));
        points.add(new Point2D(200, 0));
        points.add(new Point2D(200, 100));
        points.add(new Point2D(100, 100));
        points.add(new Point2D(100, 200));
        points.add(new Point2D(100, 400));
        points.add(new Point2D(250, 600));
        points.add(new Point2D(0, 600));
        Buoy[] buoyList = {new Buoy(new Point2D(500, 100), 20)};
        CheckPoint[] cpList = {};
        _board = new Board(new RandomWind(), new Shoreline(points), buoyList, cpList);
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
        //TODO check is possible
        _sailboat.move();
        _timer.updateTimer();
    }

    //TODO don't forget to delete the angle (refactor)
    private void render() {
        _gameView.updateBoat( _sailboat.getSpeed().getX(), _sailboat.getSpeed().getY(), _sailboat.getAngle());
        _gameView.updateTimer(String.format("%02d",_timer.getMinute()),String.format("%02d",_timer.getSecond()),String.format("%03d",_timer.getMilliSecond()));
    }


    private void endGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Main.getMessageBundle().getString("game.endTitle"));
        alert.setHeaderText(Main.getMessageBundle().getString("game.endHeader"));
        alert.setContentText(Main.getMessageBundle().getString("game.endContent"));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isEmpty() || result.get() == ButtonType.OK){
            _gameView.close();
        }
    }
}
