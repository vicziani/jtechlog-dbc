package bv;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MeetupTest {

    @Test
    void testInvariant() {
        Meetup meetup = new Meetup(-1);
        Set<ConstraintViolation<Meetup>> violations = getValidator().validate(meetup);
        assertTrue(violations.stream().map(ConstraintViolation::getMessage).anyMatch(s -> s.equals("must be greater than or equal to 1")));
    }

    @Test
    void testPrecondition() throws NoSuchMethodException {
        Meetup meetup = new Meetup(2);
        Method method = Meetup.class.getMethod("attend", List.class);
        ExecutableValidator executableValidator = getValidator().forExecutables();
        Set<ConstraintViolation<Meetup>> violations = executableValidator.validateParameters(meetup, method, new Object[]{List.of()});
        assertEquals(1, violations.size());
        assertEquals("must not be empty", violations.stream().findFirst().get().getMessage());
    }

    Validator getValidator() {
        return Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator(Collections.emptySet(), Locale.ENGLISH, false))
                .buildValidatorFactory()
                .getValidator();
    }

//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();

//        Set<ConstraintViolation<Meetup>> violations = validator.validate(meetup);
//        if (violations.size() > 0) {
//            throw new ConstraintViolationException("Invalid meetup", violations);
//        }

}
