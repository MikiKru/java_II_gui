package model;

import lombok.*;

/*// lombok
// generuje konstruktor z wszystkimi polami klasowymi w argumencie
@AllArgsConstructor
// konstruktor domyślny
@NoArgsConstructor
// gettery
@Getter
// settery
@Setter
// getery i setery
@Data
// toString
@ToString */

//@AllArgsConstructor
@Data
@ToString
public class Event {
    private String event_name, event_description;
    private int event_capacity;

    public Event(String event_name, String event_description, int event_capacity) {
        this.event_name = event_name;
        this.event_description = event_description;
        this.event_capacity = event_capacity;
    }
}
