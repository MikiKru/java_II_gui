package service;

import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

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
    public void logout(Label lbl){

    }
}
