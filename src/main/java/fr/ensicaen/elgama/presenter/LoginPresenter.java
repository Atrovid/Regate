package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.Main;
import fr.ensicaen.elgama.view.ConfigView;
import fr.ensicaen.elgama.view.LoginView;

import java.io.IOException;

public final class LoginPresenter {
    private ILoginView _loginView;

    public void setLoginView( LoginView loginView ) {
        _loginView = loginView;
    }

    public void launchGame( String nickName ) {
        if (nickName.isEmpty()) {
            _loginView.displayError(Main.getMessageBundle().getString("error.nickname"));
        } else {
            try {
                ConfigView view = ConfigView.ConfigViewFactory.createView();
                ConfigPresenter configPresenter = new ConfigPresenter(nickName);
                view.setConfigPresenter(configPresenter);
                configPresenter.setConfigView(view);
                view.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            _loginView.close();
        }
    }
}