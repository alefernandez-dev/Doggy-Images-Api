package alexdev.doggyapp.app.exception;

public class DoggyNameAlreadyExitsException extends GenericDoggyAppRuntimeException {
    public DoggyNameAlreadyExitsException(String message) {
        super(message);
    }

    public static DoggyNameAlreadyExitsException name(String name) {
        return new DoggyNameAlreadyExitsException("doggy name: " + name + ", already exists");
    }
}
