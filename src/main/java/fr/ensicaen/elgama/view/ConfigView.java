package fr.ensicaen.elgama.view;

import fr.ensicaen.elgama.Main;
import fr.ensicaen.elgama.presenter.ConfigPresenter;
import fr.ensicaen.elgama.presenter.IConfigView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfigView implements IConfigView {
    private ConfigPresenter _configPresenter;
    private static Stage _stage;

    @FXML
    private void onClickOnStartGame() {
        _configPresenter.launchGame();
    }


    public void setConfigPresenter(ConfigPresenter presenter ) {
        _configPresenter = presenter;
    }

    public void show() {
        _stage.show();
    }

    @Override
    public void close() {
        _stage.close();
    }


    public static class ConfigViewFactory {
        private ConfigViewFactory() {
        }

        public static ConfigView createView( ) throws IOException {
            FXMLLoader loader = new FXMLLoader(StartView.class.getResource("Config.fxml"), Main.getMessageBundle());
            Parent root = loader.load();
            ConfigView view = loader.getController();
            Scene scene = new Scene(root, 800, 600);
            _stage = new Stage();
            _stage.setTitle(Main.getMessageBundle().getString("project.title"));
            _stage.setScene(scene);
            return view;
        }
    }
}
