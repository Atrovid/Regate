package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.model.game_board.*;
import fr.ensicaen.elgama.model.sailboat.PolarReader;
import fr.ensicaen.elgama.model.sailboat.Sailboat;
import fr.ensicaen.elgama.view.ConfigView;
import fr.ensicaen.elgama.view.GameView;
import javafx.geometry.Point2D;

import java.io.IOException;
import java.util.ArrayList;

public final class ConfigPresenter {
    private IConfigView _configView;
    private PolarReader.PolarType _polarType = PolarReader.PolarType.Figaro;

    public void setConfigView(ConfigView configView) {
        _configView = configView;
    }

    private Board createBoard() {
        ArrayList<Point2D> shorelinePoints = new ArrayList<>();
        shorelinePoints.add(new Point2D(800, 0));
        shorelinePoints.add(new Point2D(650, 0));
        shorelinePoints.add(new Point2D(646, 20));
        shorelinePoints.add(new Point2D(633, 40));
        shorelinePoints.add(new Point2D(622, 70));
        shorelinePoints.add(new Point2D(600, 103));
        shorelinePoints.add(new Point2D(630, 130));
        shorelinePoints.add(new Point2D(645, 155));
        shorelinePoints.add(new Point2D(672, 180));
        shorelinePoints.add(new Point2D(651, 204));
        shorelinePoints.add(new Point2D(630, 220));
        shorelinePoints.add(new Point2D(635, 233));
        shorelinePoints.add(new Point2D(640, 255));
        shorelinePoints.add(new Point2D(658, 255));
        shorelinePoints.add(new Point2D(672, 285));
        shorelinePoints.add(new Point2D(702, 305));
        shorelinePoints.add(new Point2D(709, 405));
        shorelinePoints.add(new Point2D(659, 405));
        shorelinePoints.add(new Point2D(635, 385));
        shorelinePoints.add(new Point2D(647, 367));
        shorelinePoints.add(new Point2D(643, 360));
        shorelinePoints.add(new Point2D(628, 362));
        shorelinePoints.add(new Point2D(606, 377));
        shorelinePoints.add(new Point2D(638, 429));
        shorelinePoints.add(new Point2D(678, 464));
        shorelinePoints.add(new Point2D(701, 500));
        shorelinePoints.add(new Point2D(711, 525));
        shorelinePoints.add(new Point2D(718, 550));
        shorelinePoints.add(new Point2D(718, 575));
        shorelinePoints.add(new Point2D(724, 600));
        shorelinePoints.add(new Point2D(800, 600));
        Buoy[] buoyList = {new Buoy(new Point2D(450, 100), 20), // top
                new Buoy(new Point2D(450, 500), 20), // bottom
                new Buoy(new Point2D(150, 300), 20), // left
        };
        CheckPoint[] cpList = { // top -> left -> bottom -> top
                new CheckPoint(new Point2D(450, 100), new Point2D(800, 100)), // top
                new CheckPoint(new Point2D(150, 300), new Point2D(-300, 300)), // left
                new CheckPoint(new Point2D(450, 500), new Point2D(800, 500)), // bottom
                new CheckPoint(new Point2D(450, 100), new Point2D(800, 100)), // top
        };
        return new Board(createWind(), new Shoreline(shorelinePoints), buoyList, cpList);
    }

    private Wind createWind() {
        try {
            WeatherProxy proxy = new WeatherProxy(new Point2D(49.283, -0.25));
            return new WeatherWind(proxy);
        } catch (Exception e) {
            return new RandomWind();
        }
    }

    public void launchGame() {
        Board board = createBoard();
        Sailboat sailboat = new Sailboat(board, _polarType);
        try {
            GameView view = GameView.GameViewFactory.createView();
            GamePresenter gamePresenter = new GamePresenter(board, sailboat);
            view.setGamePresenter(gamePresenter);
            gamePresenter.setGameView(view);
            view.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        _configView.close();
    }

    public void setFigaroPolar() {
        _polarType = PolarReader.PolarType.Figaro;
    }

    public void setOceanisPolar() {
        _polarType = PolarReader.PolarType.Oceanis;
    }
}
