package offensive;

import java.util.List;

public class MeetupService {

    private MeetupRepo meetupRepo;

    public boolean attend(int meetupId, List<String> attendees) {
        if (attendees == null || attendees.isEmpty()) {
            throw new IllegalArgumentException("Must contain attendees");
        }
        Meetup meetup = meetupRepo.findById(meetupId);
        boolean success = false;
        if (meetup.hasSpotsFor(attendees)) {
            meetup.attend(attendees);
            success = true;
        }
        return success;
    }
}
