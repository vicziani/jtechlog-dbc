package anemic;

import java.util.List;

public class MeetupService {

    private MeetupRepo meetupRepo;

    public boolean attend(int meetupId, List<String> attendees) {
        Meetup meetup = meetupRepo.findById(meetupId);
        if (meetup.getAttendees().size() + attendees.size() <= meetup.getLimit()) {
            meetup.getAttendees().addAll(attendees);
            return true;
        }
        else {
            return false;
        }
    }
}
