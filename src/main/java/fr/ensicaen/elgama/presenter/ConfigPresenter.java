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
        return new Board(createWind(), new Shoreline(points), buoyList, cpList);
    }

    private Wind createWind() {
        try {
            WeatherProxy proxy = new WeatherProxy(new Point2D(49.283,-0.25));
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
