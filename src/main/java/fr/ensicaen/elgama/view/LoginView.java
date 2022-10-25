package fr.ensicaen.elgama.view;

import fr.ensicaen.elgama.presenter.ILoginView;
import fr.ensicaen.elgama.presenter.LoginPresenter;
import fr.ensicaen.elgama.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView implements ILoginView {
    private LoginPresenter _loginPresenter;
    private Stage _stage;
    @FXML
    private TextField _nickName;
    @FXML
    private Label _errorMessage;

    public void setLoginPresenter( LoginPresenter presenter ) {
        _loginPresenter = presenter;
    }

    public void show() {
        _stage.show();
    }

    @Override
    public void close() {
        _stage.close();
    }

    @Override
    public void displayError( String message ) {
        _errorMessage.setText(message);
    }

    @FXML
    private void onClickOnStartGame() {
        _loginPresenter.launchGame(_nickName.getText());
    }

    public static class LoginViewFactory {
        private LoginViewFactory() {
            // Factory class as Utility class where the constructor is private
            // FIXME supprimer ce commentaire devenu inutile. Il n'avait qu'un vertue pédagogique
        }

        public static LoginView createView() throws IOException {
            FXMLLoader loader = new FXMLLoader(LoginView.class.getResource("LoginDialog.fxml"), Main.getMessageBundle());
            Parent root = loader.load();
            LoginView view = loader.getController();
            Scene scene = new Scene(root);
            view._stage = new Stage();
            view._stage.setTitle(Main.getMessageBundle().getString("project.title"));
            view._stage.setScene(scene);
            view._stage.setResizable(false);
            return view;
        }
    }
}