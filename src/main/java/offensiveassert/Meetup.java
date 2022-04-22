package offensiveassert;

import java.util.ArrayList;
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
        assert newAttendees != null && newAttendees.size() > 0;
        assert hasSpotsFor(newAttendees);

        attendees.addAll(newAttendees);
    }

}
