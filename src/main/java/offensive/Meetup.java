package offensive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Meetup {

    private Long id;

    private int limit;

    private List<String> attendees = new ArrayList<>();

    public Meetup(int limit) {
        this.limit = limit;
    }

    public boolean hasSpotsFor(List<String> newAttendees) {
        return attendees.size() + newAttendees.size() <= limit;
    }

    public void attend(List<String> newAttendees) {
        if (newAttendees == null || newAttendees.isEmpty()) {
            throw new IllegalArgumentException("Must contain attendees");
        }
        if (!hasSpotsFor(newAttendees)) {
            throw new IllegalArgumentException("Has no spots");
        }
        attendees.addAll(newAttendees);
    }
}
