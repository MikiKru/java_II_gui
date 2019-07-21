package service;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Event;
import repository.EventRepository;
import repository.FileEventRepository;
import java.util.List;

import java.io.IOException;
import java.util.stream.Collectors;

public class EventService {
    private AlertService alertService;
    private EventRepository eventRepository;
    // inicjalizacja obiektów dostarczających obsługę okein dialodowych
    public EventService() {
        alertService = new AlertService();
        eventRepository = new FileEventRepository();
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
    // wydobycie nazw eventów jako content do combobox
    public List<String> getEventsName(){
        List<Event> events = eventRepository.getAllEvents();
        return events
                .stream()
                .map(event -> event.getEvent_name())
                .collect(Collectors.toList());
    }

}
