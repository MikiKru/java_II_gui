package repository;

import model.UserEvent;

import java.io.IOException;
import java.util.List;

public interface UserEventRepository {

    void save(UserEvent userEvent) throws IOException;
    List<UserEvent> getAllUserEvents();
}
