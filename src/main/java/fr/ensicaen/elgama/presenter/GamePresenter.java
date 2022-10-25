package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.model.BoatModel;
import fr.ensicaen.elgama.model.PlayerModel;
import fr.ensicaen.elgama.model.game_board.*;
import fr.ensicaen.elgama.model.sailboat.PolarReader;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.awt.geom.Point2D;

public class GamePresenter {
    private final PlayerModel _playerModel;
    private final PolarReader _speedTable;
    private final IWind _wind;
    private BoatModel _boatModel;
    private IGameView _gameView;
    private boolean _started = false;
    private Timeline _timeline;

    public GamePresenter(String nickName) {
        _playerModel = new PlayerModel();
        _playerModel.setNickname(nickName);
        _wind = new RandomWind();
        _speedTable = new PolarReader();
        initGame();
    }

    public void setGameView(IGameView gameView) {
        _gameView = gameView;
        _gameView.addBoat(_boatModel.getX(), _boatModel.getY());

        Buoy[] buoyList = {new Buoy(new Point2D.Double(500, 100), 20)};
        CheckPoint[] cpList = {};
        _gameView.drawWaterBody(new Board(new RandomWind(), new Shoreline(100, 'w'), buoyList, cpList));
        _gameView.setWind(_wind.getWindDirection());
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
            _boatModel.rotate(-2);
        } else if (action == UserAction.RIGHT) {
            _boatModel.rotate(+2);
        }
    }

    private void initGame() {
        _boatModel = new BoatModel();
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
        _boatModel.move(_speedTable, _wind);
    }

    private void render() {
        _gameView.updateBoat(_boatModel.getDx(), _boatModel.getDy(), _boatModel.getAngle());
    }
}
