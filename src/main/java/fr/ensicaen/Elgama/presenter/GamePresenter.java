package fr.ensicaen.Elgama.presenter;

import fr.ensicaen.Elgama.model.BoatModel;

// Remarque : l'animation n'est pas considérée comme étant du graphisme à proprement parlé.
//            On peut la considérer comme une bibliothèque tiers de gestion de threading.
//            On peut donc l'utiliser dans le presenter.
import fr.ensicaen.Elgama.model.IWind;
import fr.ensicaen.Elgama.model.PlayerModel;
import fr.ensicaen.Elgama.model.RandomWind;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.awt.geom.Point2D;

public class GamePresenter {
    private final PlayerModel _playerModel;
    private BoatModel _boatModel;
    private Point2D _windDir;
    private IGameView _gameView;
    private boolean _started = false;
    private Timeline _timeline;

    public GamePresenter( String nickName ) {
        _playerModel = new PlayerModel();
        _playerModel.setNickname(nickName);
        setWindDir(new RandomWind()); //creer un deuxième constructeur pour modifier les types de vent
        initGame();
    }

    public void setGameView( IGameView gameView ) {
        _gameView = gameView;
        _gameView.addBoat(_boatModel.getX(), _boatModel.getY());
        _gameView.addBuoy(10,10);
        _gameView.setWind(_windDir);
    }

    public void handleUserAction( UserAction code ) {
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

    private void changeDirection( UserAction action ) {
        if (action == UserAction.LEFT) {
            _boatModel.rotate(-2);
        } else if (action == UserAction.RIGHT) {
            _boatModel.rotate(+2);
        }
    }

    private void initGame() {
        _boatModel = new BoatModel();
    }

    private void setWindDir(IWind wind){
        _windDir = wind.getWindDirection();
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
        _boatModel.move();
    }

    private void render() {
        _gameView.updateBoat(_boatModel.getDx(), _boatModel.getDy(), _boatModel.getAngle());
    }
}
