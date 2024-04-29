package alexdev.doggyapp.app.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationException extends GenericDoggyAppRuntimeException {
    private final List<String> errors;

    public ValidationException(List<String> errors) {
        this.errors = errors;
    }

    public static ValidationException addMessages(List<String> errors) {
        return new ValidationException(errors);
    }
}
