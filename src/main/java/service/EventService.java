package service;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EventService {
    private AlertService alertService;
    // inicjalizacja obiektów dostarczających obsługę okein dialodowych
    public EventService() {
        alertService = new AlertService();
    }

    public void closeWindow(){
        // wywołanie okna dialogowego z potwierdzeniem zwracającego Optional z ButtonType i nasłuchiwanie na wciśnięcie przycisku OK
        if(alertService.confirmation_alert(
                "Exit confirmation",
                "Exit confirmation",
                "Do you want to exit?").get() == ButtonType.OK){
            Platform.exit();
        }
    }
    public void logout(Label lbl) throws IOException {
        // zamknięcie istniejącego okna
        Stage stage = (Stage) lbl.getScene().getWindow();
        stage.close();
        // powrotne otwarcie okna logowania
        Stage primaryStage = new Stage();
        // załadowanie pliku FXML do obiektu root
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        // przypisanie właściwości do obiektu okna aplikacji
        primaryStage.setTitle("Events");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
