package fr.ensicaen.elgama.view;

import fr.ensicaen.elgama.Main;
import fr.ensicaen.elgama.presenter.IStartView;
import fr.ensicaen.elgama.presenter.StartPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class StartView implements IStartView {
    public MenuButton languageButton;
    public Button playButton;
    private StartPresenter _startPresenter;
    private Stage _stage;

    static MenuItem createMenuItem(String text, String id, EventHandler<ActionEvent> handler) {
        MenuItem result = new MenuItem(text);
        result.setId(id);
        result.setOnAction(handler);
        return result;
    }

    public void setStartPresenter(StartPresenter presenter) {
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

    @FXML
    private void onClickChangeLanguage(String lang, String country) throws IOException {
        Main.changeLanguage(lang, country);
        StartView view = StartView.StartViewFactory.createView(_stage);
        StartPresenter presenter = new StartPresenter();
        presenter.setStartView(view);
        view.setStartPresenter(presenter);
        view.show();
    }

    public static class StartViewFactory {
        private StartViewFactory() {
        }

        public static StartView createView(Stage primaryStage) throws IOException {
            FXMLLoader loader = new FXMLLoader(StartView.class.getResource("StartDialog.fxml"), Main.getMessageBundle());
            Parent root = loader.load();
            StartView view = loader.getController();

            EventHandler<ActionEvent> handler = event -> {
                String id = ((MenuItem) event.getSource()).getId();
                String lang = id.split("_")[0];
                String country = id.split("_")[1];
                try {
                    view.onClickChangeLanguage(lang, country);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };

            view.languageButton.getItems().addAll(createMenuItem("Français", "fr_FR", handler), createMenuItem("English", "en_US", handler));
            Scene scene = new Scene(root);
            view._stage = primaryStage;
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            return view;
        }
    }
}
