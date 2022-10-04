package fr.ensicaen.Elgama.presenter;

import fr.ensicaen.Elgama.Main;
import fr.ensicaen.Elgama.view.GameView;
import fr.ensicaen.Elgama.view.LoginView;
import fr.ensicaen.Elgama.view.StartView;

import java.io.IOException;

public class StartPresenter {
    private IStartView _startView;

    public void setStartView( StartView startview ) {
        _startView = startview;
    }

    public void launchGame() {
        try {
            LoginView view = LoginView.LoginViewFactory.createView();
            LoginPresenter gamePresenter = new LoginPresenter();
            view.setLoginPresenter(gamePresenter);
            gamePresenter.setLoginView(view);
            view.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        _startView.close();
    }

}
