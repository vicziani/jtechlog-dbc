package defensive;

import java.util.List;

public class MeetupService {

    private MeetupRepo meetupRepo;

    public boolean attend(int meetupId, List<String> attendees) {
        if (attendees == null || attendees.isEmpty()) {
            throw new IllegalArgumentException("Must contain attendees");
        }
        Meetup meetup = meetupRepo.findById(meetupId);
        boolean success = false;
        List<String> notAttendedYet = meetup.getNotAttended(attendees);
        if (notAttendedYet.size() > 0 && meetup.hasSpotsFor(notAttendedYet)) {
            meetup.attend(notAttendedYet);
            success = true;
        }
        return success;
    }
}
