package fr.ensicaen.elgama.presenter;

import fr.ensicaen.elgama.view.ConfigView;
import fr.ensicaen.elgama.view.StartView;

import java.io.IOException;

public class StartPresenter {
    private IStartView _startView;

    public void setStartView(StartView startview) {
        _startView = startview;
    }

    public void launchGame() {
        try {
            ConfigView view = ConfigView.ConfigViewFactory.createView();
            ConfigPresenter configPresenter = new ConfigPresenter();
            view.setConfigPresenter(configPresenter);
            configPresenter.setConfigView(view);
            view.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        _startView.close();
    }

}
