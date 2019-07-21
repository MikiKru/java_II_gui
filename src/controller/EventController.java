package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import service.EventService;
import service.LoginService;

import java.io.IOException;

public class EventController {

    @FXML
    private Label lbl_login;

    @FXML
    private Tab tab_submit;

    @FXML
    private ComboBox<?> cb_event;

    @FXML
    private TextArea ta_description;

    @FXML
    private Tab tab_confirm;

    @FXML
    private TableView<?> table_confirm;

    @FXML
    private TableColumn<?, ?> c_login;

    @FXML
    private TableColumn<?, ?> c_event;

    @FXML
    private TableColumn<?, ?> c_confirm;

    @FXML
    private Button btn_confirm;

    @FXML
    void confirmAction(ActionEvent event) {

    }

    @FXML
    void submitAction(ActionEvent event) {

    }
    @FXML
    private void logoutAction(ActionEvent actionEvent) throws IOException {
        eventService.logout(lbl_login);
    }
    @FXML
    private void exitAction(ActionEvent actionEvent) {
        eventService.closeWindow();
    }

    private EventService eventService;
    public void initialize(){
        // inicjalizacja obiektu klasy event service
        eventService = new EventService();
        lbl_login.setText(lbl_login.getText() + LoginService.logged_login);
    }

}