package fr.ensicaen.Elgama.presenter;

import fr.ensicaen.Elgama.Main;
import fr.ensicaen.Elgama.model.PlayerModel;
import fr.ensicaen.Elgama.view.ConfigView;
import fr.ensicaen.Elgama.view.GameView;

import java.io.IOException;

public final class ConfigPresenter {
    private IConfigView _configView;
    private String _nickname;

    public ConfigPresenter( String nickname ) {
        _nickname = nickname;
    }

    public void setConfigView( ConfigView configView ) {
        _configView = configView;
    }

    public void launchGame(  ) {
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
