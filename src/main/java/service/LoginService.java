package service;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.User;
import repository.FileUserRepository;
import repository.UserRepository;

import java.io.IOException;

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
    // pole statyczne przechowyjące login zalogowanego użytkownika
//    public static String logged_login;
    public void credentials_check(TextField tf_login,
                                   PasswordField pf_password,
                                   TextField tf_password,
                                   CheckBox cb_show, Label lbl_login_validation,
                                   Label lbl_password_validation) throws IOException {
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
        } else if (log_me_in(login, password)) {
            validation_clear(lbl_login_validation, lbl_password_validation);
            credential_clear(tf_login, pf_password, tf_password);
            // przypisanie do statycznego obiektu User zalogowanego użytkownika
            logged_user = userRepository.getUserByLogin(login).get();
            // wywołanie okna event
            Stage eventStage = new Stage();
            // załadowanie pliku FXML do obiektu root
            Parent root = FXMLLoader.load(getClass().getResource("/view/event.fxml"));
            // przypisanie właściwości do obiektu okna aplikacji
            eventStage.setTitle("Events");
            eventStage.setScene(new Scene(root));
            eventStage.show();
            // zamknięcie okna logowania aplikacji
            Stage primaryStage = (Stage) tf_login.getScene().getWindow();
            primaryStage.close();
        } else {
            System.out.println("błąd logowania!");
            validation_clear(lbl_login_validation, lbl_password_validation);
            int probes = login_counter();
            new AlertService().window_alert(Alert.AlertType.ERROR,
                    "Credentials faild",
                    "Credentials faild",
                    "Check your login or password! Probes to disable: " + probes );
            if(probes == 0){
                // systemowe zamknięcie okna aplikacji - tak jak X
                Platform.exit();
            }
        }
    }
    private UserRepository userRepository = new FileUserRepository();
    public static User logged_user;
    private boolean log_me_in(String login, String password){
        return userRepository.getAllUsers().stream().anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password));
    }

    // globalna liczba prób - zaczynamy od 3
    private int login_count = 3;
    // metoda dekrementująca liczbę prób z 3 do 0
    private int login_counter(){
        login_count --;
        return login_count;
    }

}
