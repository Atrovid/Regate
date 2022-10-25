package fr.ensicaen.elgama.presenter;
// FIXME imports non utilisés
import fr.ensicaen.elgama.view.ConfigView;
import fr.ensicaen.elgama.view.GameView;

import java.io.IOException;

public final class ConfigPresenter {
    private IConfigView _configView;
    private String _nickname; // FIXME est-ce une valeur constante ?-> final

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
