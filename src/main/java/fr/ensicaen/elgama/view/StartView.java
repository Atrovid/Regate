package fr.ensicaen.elgama.view;

import fr.ensicaen.elgama.Main;
import fr.ensicaen.elgama.presenter.IStartView;
import fr.ensicaen.elgama.presenter.StartPresenter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartView implements IStartView {
    private StartPresenter _startPresenter;
    private Stage _stage;
    @FXML
    private TextField _nickName; // FIXME inutilisé.
    @FXML
    private Label _errorMessage; // FIXME inutilisé.

    public void setStartPresenter(StartPresenter presenter ) {
        _startPresenter = presenter;
    }

    public void show() {
        _stage.show();
    }

    @Override
    public void close() {
        _stage.close();
    }

    @FXML
    private void onClickOnStartGame() {
        _startPresenter.launchGame();
    }

    public static class StartViewFactory {
        private StartViewFactory() {
            // Factory class as Utility class where the constructor is private
        }

        public static StartView createView( Stage primaryStage ) throws IOException {
            FXMLLoader loader = new FXMLLoader(StartView.class.getResource("StartDialog.fxml"), Main.getMessageBundle());
            Parent root = loader.load();
            StartView view = loader.getController();
            Scene scene = new Scene(root);
            view._stage = primaryStage;
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            return view;
        }
    }

}
