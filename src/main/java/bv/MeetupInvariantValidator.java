package bv;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MeetupInvariantValidator implements ConstraintValidator<MeetupInvariant, Meetup> {

    @Override
    public boolean isValid(Meetup meetup, ConstraintValidatorContext constraintValidatorContext) {
        return meetup.getAttendees().size() <= meetup.getLimit();
    }
}
