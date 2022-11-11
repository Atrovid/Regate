package fr.ensicaen.elgama;

import fr.ensicaen.elgama.presenter.StartPresenter;
import fr.ensicaen.elgama.view.StartView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public final class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeLanguage(String lang, String country) {
        Locale.setDefault(new Locale(lang, country));
    }

    public static ResourceBundle getMessageBundle() {
        return ResourceBundle.getBundle("fr.ensicaen.elgama.MessageBundle");
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle(getMessageBundle().getString("project.title"));
        StartView view = StartView.StartViewFactory.createView(primaryStage);
        StartPresenter presenter = new StartPresenter();
        presenter.setStartView(view);
        view.setStartPresenter(presenter);
        view.show();
    }

    @Override
    public void stop() {
        System.out.println(getMessageBundle().getString("project.bye"));
    }
}