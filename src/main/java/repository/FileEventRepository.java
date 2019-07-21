package repository;

import model.Event;
import model.User;
import model.enums.Role;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Klasa mapująca dane z pliku do listy obiektów modelu Event
public class FileEventRepository implements EventRepository {
    private File event_file;
    private String event_path;

    public FileEventRepository() {
        // połaczenie z istniejącym plikiem
        event_path = this.getClass()
                .getClassLoader()
                .getResource("file/events.csv").getFile();
        event_file = new File(event_path);
    }


    private List<Event> events = new ArrayList<>();
    @Override
    public List<Event> getAllEvents() {

        // wydobycie zawartości pliku
        try {
            Scanner file_content = new Scanner(event_file);
            file_content.nextLine();
            while (file_content.hasNextLine()) {
                // preprocessing pliku -> cięce po ';'
                String events_array [] = file_content.nextLine().split(";");

                // wprowadzenie wydobytych pól z pliku do modelu
                Event event = new Event(events_array[0], events_array[1], Integer.valueOf(events_array[2]));
                // dodanie instancji modelu do listy
                events.add(event);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // zwrócenie listy wszystkich użytkowników
        return events;
    }
}
