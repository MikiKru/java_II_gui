package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import service.LoginService;

public class EventController {

    @FXML
    private Label lbl_login;

    public void initialize(){
        lbl_login.setText(lbl_login.getText() + LoginService.logged_login);
    }
}