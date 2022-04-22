package defensive;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
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

    public boolean containsAny(List<String> newAttendees) {
        return newAttendees.stream().anyMatch(newAttendee -> attendees.contains(newAttendee));
    }

    public void attend(List<String> newAttendees) {
        assert newAttendees != null && newAttendees.size() > 0;
        assert hasSpotsFor(newAttendees);
        assert !containsAny(newAttendees);

        attendees.addAll(newAttendees);
    }

    public List<String> getNotAttended(List<String> newAttendees) {
        return newAttendees.stream().filter(newAttendee -> !attendees.contains(newAttendee)).toList();
    }
}
