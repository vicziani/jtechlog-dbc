package oo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Meetup {

    private Long id;

    private int limit;

    private List<String> attendees = new ArrayList<>();

    public boolean hasSpotsFor(List<String> newAttendees) {
        return attendees.size() + newAttendees.size() <= limit;
    }

    public void attend(List<String> newAttendees) {
        attendees.addAll(newAttendees);
    }

}
