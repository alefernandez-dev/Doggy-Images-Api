package alexdev.doggyapp.app.exception;

public class GenericDoggyAppException extends Exception{
    public GenericDoggyAppException(String message) {
        super(message);
    }

    public GenericDoggyAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
