package service;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    public void validation_clear(Label lbl_login_validation, Label lbl_password_validation) {
        lbl_login_validation.setText("");
        lbl_password_validation.setText("");
    }

    public void credential_clear(TextField tf_login, PasswordField pf_password, TextField tf_password) {
        tf_login.clear();
        pf_password.clear();
        tf_password.clear();
    }

    public void credentials_check(TextField tf_login,
                                   PasswordField pf_password,
                                   TextField tf_password,
                                   CheckBox cb_show, Label lbl_login_validation,
                                   Label lbl_password_validation) {
        String login = tf_login.getText();
        String password = pf_password.getText();
        if(cb_show.isSelected()) {
            password = tf_password.getText();
        }
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
            validation_clear(lbl_login_validation, lbl_password_validation);
            credential_clear(tf_login, pf_password, tf_password);
        } else {
            System.out.println("błąd logowania!");
            validation_clear(lbl_login_validation, lbl_password_validation);
        }
    }

}
