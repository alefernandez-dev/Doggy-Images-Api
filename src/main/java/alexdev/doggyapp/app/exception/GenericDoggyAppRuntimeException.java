package alexdev.doggyapp.app.exception;

public class GenericDoggyAppRuntimeException extends RuntimeException{
    public GenericDoggyAppRuntimeException(String message) {
        super(message);
    }

    public GenericDoggyAppRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericDoggyAppRuntimeException() {
    }
}
