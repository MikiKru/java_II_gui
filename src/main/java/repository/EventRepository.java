package repository;

import model.Event;
import java.util.List;
import java.util.Optional;

public interface EventRepository {
    List<Event> getAllEvents();
    Optional<Event> getEventByEventName(String event_name);
}
