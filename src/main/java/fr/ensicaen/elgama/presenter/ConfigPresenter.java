package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.view.ConfigView;
import fr.ensicaen.elgama.view.GameView;

import java.io.IOException;

public final class ConfigPresenter {
    private final String _nickname;
    private IConfigView _configView;

    public ConfigPresenter(String nickname) {
        _nickname = nickname;
    }

    public void setConfigView(ConfigView configView) {
        _configView = configView;
    }

    public void launchGame() {
        try {
            GameView view = GameView.GameViewFactory.createView();
            GamePresenter gamePresenter = new GamePresenter(_nickname);
            view.setGamePresenter(gamePresenter);
            gamePresenter.setGameView(view);
            view.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        _configView.close();
    }
}
