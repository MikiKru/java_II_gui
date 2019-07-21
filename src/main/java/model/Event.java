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

@AllArgsConstructor
@Data
@ToString
public class Event {
    private String event_name, event_description;
    private int event_capacity;
}
