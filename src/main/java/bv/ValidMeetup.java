package bv;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = MeetupValidator.class)
public @interface ValidMeetup {

    String message() default "Too many attendees";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
