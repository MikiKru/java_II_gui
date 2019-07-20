package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        validation_clear();
        // utworzenie nowej instancji klasy serwisu
        loginService = new LoginService();
    }
    @FXML
    void loginAction(ActionEvent event) {
        credentials_check(tf_login.getText(), pf_password.getText());
    }

    @FXML
    void registerAction(ActionEvent event) {

    }
    // metoda do sterowania kontrolkami PasswordField i TextField -> dot. wodoczności hasła
    @FXML
    void showAction(ActionEvent event) {
        loginService.password_show(cb_show,tf_password,pf_password);
    }
}