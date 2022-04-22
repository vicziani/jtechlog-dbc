package bv;

import jakarta.validation.*;

import java.util.List;
import java.util.Set;

public class MeetupService {

    private MeetupRepo meetupRepo;

//    public boolean attend(int meetupId, List<String> attendees) {
//        Meetup meetup = meetupRepo.findById(meetupId);
////        if (attendees.size() <= meetup.getSpotsLeft()) {
//        if (meetup.hasSpotsFor(attendees)) {
//            meetup.attend(attendees);
//            return true;
//        }
//        else {
//            return false;
//        }
//    }



    public boolean attend(int meetupId, List<String> attendees) {
        Meetup meetup = meetupRepo.findById(meetupId);
        boolean success = false;
        if (meetup.hasSpotsFor(attendees)) {
            meetup.attend(attendees);
            success = true;
        }
        return success;
    }
}
