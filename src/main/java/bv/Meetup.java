package bv;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Invariáns: a jelentkezők száma nem haladhatja meg a
 * jelentkezések maximális számát.
 *
 * attendees.size() <= limit
 */
@Data
@MeetupInvariant
public class Meetup {

    private Long id;

    @Min(1)
    private int limit;

    private List<String> attendees = new ArrayList<>();

    public Meetup(int limit) {
        this.limit = limit;
    }

    public boolean hasSpotsFor(List<String> newAttendees) {
        return attendees.size() + newAttendees.size() <= limit;
    }

    public void attend(@NotNull @NotEmpty List<String> newAttendees) {
        attendees.addAll(newAttendees);
    }

}
