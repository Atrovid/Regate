package fr.ensicaen.elgama.view;

import fr.ensicaen.elgama.presenter.GamePresenter;
import fr.ensicaen.elgama.presenter.IGameView;
import fr.ensicaen.elgama.presenter.UserAction;
import fr.ensicaen.elgama.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class GameView implements IGameView {
    private static Stage _stage;
    public Text _strength;
    public Text _minutes;
    public Text _seconds;
    public Text _milliseconds;
    private GamePresenter _gamePresenter;
    private Ellipse _boat;
    private final ArrayList<Node> _checkPoints = new ArrayList<>();
    @FXML
    private AnchorPane _base;
    @FXML
    private ImageView _windImage;

    public void setGamePresenter( GamePresenter gamePresenter ) {
        _gamePresenter = gamePresenter;
    }

    public void rotateBoat(Ellipse boat, double val ) {
        boat.setRotate(val);
    }

    public Ellipse drawBoat( double x, double y, double rx, double ry ) {
        Ellipse boat = new Ellipse(x, y, rx, ry);
        boat.setFill(Color.BLACK);
        _base.getChildren().add(boat);
        return boat;
    }

    @Override
    public void drawShoreline(double[] polygonVertices) {
        Polygon polygon = new Polygon(polygonVertices);
        polygon.setFill(Color.YELLOW);
        _base.getChildren().add(polygon);
        polygon.toBack();
    }

    @Override
    public void drawBuoy(javafx.geometry.Point2D center, int radius) {
        Ellipse ellipse = new Ellipse(center.getX(), center.getY(), radius, radius);
        ellipse.setFill(Color.ORANGE);
        _base.getChildren().add(ellipse);
        ellipse.toBack();
    }

    @Override
    public void drawCheckPoint(javafx.geometry.Point2D p1, Point2D p2) {
        Line line = new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        line.setFill(Color.GRAY);
        _base.getChildren().add(line);
        line.toBack();
        _checkPoints.add(line);
    }

    @Override
    public void removeAllCheckPoints() {
        _base.getChildren().removeAll(_checkPoints);
        _checkPoints.clear();
    }

    public void move( Ellipse boat, double dx, double dy ) {
        boat.setLayoutX(boat.getLayoutX() + dx);
        boat.setLayoutY(boat.getLayoutY() + dy);
    }

    public void updateBoat(double dx, double dy, double angle ) {
        rotateBoat(_boat, angle);
        move(_boat, dx, dy);
    }

    public void updateTimer(String minutes, String seconds, String milliseconds ) {
        _minutes.setText(minutes);
        _seconds.setText(seconds);
        _milliseconds.setText(milliseconds);
    }

    @Override
    public void setWind(double windDirection, float strength) {
        _windImage.setRotate(windDirection);
        _strength.setText(String.valueOf(strength));
    }

    public void show() {
        _stage.show();
    }

    public void addBoat( Point2D boatPosition ) {
        _boat = drawBoat(boatPosition.getX(), boatPosition.getY(), 6, 16);
    }

    private void handleKeyPressed( KeyCode code ) {
        if (code == KeyCode.SPACE) {
            _gamePresenter.handleUserAction(UserAction.START);
        } else if (code == KeyCode.LEFT) {
            _gamePresenter.handleUserAction(UserAction.LEFT);
        } else if (code == KeyCode.RIGHT) {
            _gamePresenter.handleUserAction(UserAction.RIGHT);
        }
    }

    public void close(){
        _stage.close();
    }

    public static class GameViewFactory {
        private GameViewFactory() {
        }

        public static GameView createView() throws IOException {
            FXMLLoader loader = new FXMLLoader(StartView.class.getResource("SpotMap.fxml"), Main.getMessageBundle());
            Parent root = loader.load();
            GameView view = loader.getController();
            Scene scene = new Scene(root, 800, 600);
            Stage stage = new Stage();
            stage.setTitle(Main.getMessageBundle().getString("project.title"));
            stage.setScene(scene);
            _stage = stage;
            scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                KeyCode code = event.getCode();
                view.handleKeyPressed(code);
            });
            return view;
        }
    }
}