package repository;

import model.UserEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        userevent_writer.write(userEvent.toString()+"\n");
        userevent_writer.flush();
    }

    @Override
    public List<UserEvent> getAllUserEvents() {
        return null;
    }
}
