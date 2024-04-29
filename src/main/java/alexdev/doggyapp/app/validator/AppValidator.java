package alexdev.doggyapp.app.validator;

import alexdev.doggyapp.app.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class AppValidator<T> {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    public void validate(T obj) {

        var violations = validator.validate(obj);

        if(!violations.isEmpty()) {

            var message = violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .toList();

            throw ValidationException.addMessages(message);

        }

    }

}
