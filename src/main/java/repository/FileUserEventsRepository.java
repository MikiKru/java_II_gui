package repository;

import model.Event;
import model.UserEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUserEventsRepository implements UserEventRepository {

    FileWriter userevent_writer;
    File userevent_reader;
    String userevent_path;
    public FileUserEventsRepository() throws IOException {
        userevent_path = this.getClass()
                .getClassLoader()
                .getResource("file/users_events.csv").getFile();
        // obiekt do odczytywania zawortości pliku
        userevent_reader = new File(userevent_path);
        // obiekt do zapisywania do pliku
        userevent_writer = new FileWriter("C:\\Users\\PROXIMO\\Desktop\\GUI\\java_gui\\src\\main\\resources\\file\\users_events.csv", true);
    }
    @Override
    public void save(UserEvent userEvent) throws IOException {
        userEvent.setId(count()+1);
        userevent_writer.write(userEvent.toString()+"\n");
        userevent_writer.flush();
    }

    private List<UserEvent> users_events = new ArrayList<>();
    @Override
    public List<UserEvent> getAllUserEvents() {

        // wydobycie zawartości pliku
        try {
            Scanner file_content = new Scanner(userevent_reader);
            file_content.nextLine();
            while (file_content.hasNextLine()) {
                // preprocessing pliku -> cięce po ';'
                String users_events_array [] = file_content.nextLine().split(";");

                // wprowadzenie wydobytych pól z pliku do modelu
                UserEvent userEvent = new UserEvent(
                        Integer.valueOf(users_events_array[0]),
                        users_events_array[1],
                        users_events_array[2],
                        Boolean.valueOf(users_events_array[3]));
                // dodanie instancji modelu do listy
                users_events.add(userEvent);
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        // zwrócenie listy wszystkich użytkowników
        return users_events;
    }

    @Override
    public int count() {
        return getAllUserEvents().size() ;
    }
}
