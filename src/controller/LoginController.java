package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import repository.FileUserRepository;
import service.LoginService;

public class LoginController {
    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_login;

    @FXML
    private PasswordField pf_password;

    @FXML
    private CheckBox cb_show;

    @FXML
    private Label lbl_login_validation;

    @FXML
    private Label lbl_password_validation;
    // globalny obiekt klasy serwisu -> do logiki biznesowej
    private LoginService loginService;

    public void initialize() {
        // utworzenie nowej instancji klasy serwisu
        loginService = new LoginService();
        loginService.validation_clear(lbl_login_validation, lbl_password_validation);
//        // tymczasowe
//        FileUserRepository fileUserRepository = new FileUserRepository();
//        fileUserRepository.getAllUsers();
    }

    @FXML
    void loginAction(ActionEvent event) {
        loginService.credentials_check(tf_login, pf_password, tf_password, cb_show, lbl_login_validation, lbl_password_validation);
    }

    @FXML
    void registerAction(ActionEvent event) {

    }
    // metoda do sterowania kontrolkami PasswordField i TextField -> dot. wodoczności hasła
    @FXML
    void showAction(ActionEvent event) {
        loginService.password_show(cb_show, tf_password, pf_password);
    }

    @FXML
    void keyLoginAction(KeyEvent keyEvent) {
        // sprawdzamy czy wciśnięty klawisz to enter za pomocą obiektu keyEvent
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            loginService.credentials_check(tf_login, pf_password, tf_password, cb_show, lbl_login_validation, lbl_password_validation);
        }
    }
}