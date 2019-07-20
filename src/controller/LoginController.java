package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

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

    public void initialize() {
        validation_clear();
    }

    private void validation_clear() {
        lbl_login_validation.setText("");
        lbl_password_validation.setText("");
    }

    private void credential_clear() {
        tf_login.clear();
        pf_password.clear();
    }
    private void credentials_check(String login, String password){
        if (login.equals("") && !password.equals("")) {
            lbl_login_validation.setText("login can't be empty");
            lbl_password_validation.setText("");
        } else if (!login.equals("") && password.equals("")) {
            lbl_login_validation.setText("");
            lbl_password_validation.setText("password can't be empty");
        } else if (login.equals("")) {
            lbl_login_validation.setText("login can't be empty");
            lbl_password_validation.setText("password can't be empty");
        } else if (login.equals("admin") && password.equals("admin")) {
            System.out.println("zalogowano");
            validation_clear();
            credential_clear();
        } else {
            System.out.println("błąd logowania!");
            validation_clear();
        }
    }
    @FXML
    void loginAction(ActionEvent event) {
        credentials_check(tf_login.getText(), pf_password.getText());
    }

    @FXML
    void registerAction(ActionEvent event) {

    }

    @FXML
    void showAction(ActionEvent event) {

    }
}