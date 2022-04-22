package bv;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = MeetupInvariantValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface MeetupInvariant {

    String message() default "Invalid meetup";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
