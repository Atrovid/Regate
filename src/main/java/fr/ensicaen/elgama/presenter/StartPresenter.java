package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.view.LoginView;
import fr.ensicaen.elgama.view.StartView;

import java.io.IOException;

public class StartPresenter {
    private IStartView _startView;

    public void setStartView(StartView startview) {
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
