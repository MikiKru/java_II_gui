package service;

import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginService {

    public void password_show(CheckBox cb_show, TextField tf_password, PasswordField pf_password) {
        if (cb_show.isSelected()) {
            tf_password.setVisible(true);
            pf_password.setVisible(false);
            tf_password.setText(pf_password.getText());
        } else {
            tf_password.setVisible(false);
            pf_password.setVisible(true);
            pf_password.setText(tf_password.getText());
        }
    }
    private void validation_clear() {
        lbl_login_validation.setText("");
        lbl_password_validation.setText("");
    }

    private void credential_clear() {
        tf_login.clear();
        pf_password.clear();
    }

    private void credentials_check(String login, String password) {
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

}
