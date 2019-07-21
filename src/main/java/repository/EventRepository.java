package repository;

import model.Event;
import java.util.List;

public interface EventRepository {
    List<Event> getAllEvents();
}
