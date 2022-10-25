package fr.ensicaen.Elgama.view;

import fr.ensicaen.Elgama.Main;
import fr.ensicaen.Elgama.presenter.ConfigPresenter;
import fr.ensicaen.Elgama.presenter.IConfigView;
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
            // Factory class as Utility class where the constructor is private
        }

        public static ConfigView createView( ) throws IOException {
            FXMLLoader loader = new FXMLLoader(StartView.class.getResource("Config.fxml"), Main.getMessageBundle());
            Parent root = loader.load();
            ConfigView view = loader.getController();
            Scene scene = new Scene(root, 800, 600);
            view._stage = new Stage(); // FIXME _state est un attribut statique -> utiliser la classe pour y accéder
            view._stage.setTitle(Main.getMessageBundle().getString("project.title"));
            view._stage.setScene(scene);
            return view;
        }
    }
}
