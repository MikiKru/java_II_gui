package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
public class UserEvent {
    private int id;
    private String login, event_name;
    private boolean confirm;
    private int event_capacity;

    public UserEvent(String login, String event_name) {
        this.login = login;
        this.event_name = event_name;
    }

    @Override
    public String toString() {
        return id+";"+login+";"+ event_name+";"+confirm+";"+event_capacity;
    }
}
