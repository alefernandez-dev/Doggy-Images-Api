package alexdev.doggyapp.app.exception;

import java.util.UUID;

public class DoggyIdNotFoundException extends GenericDoggyAppException {
    public DoggyIdNotFoundException(String message) {
        super(message);
    }

    public static DoggyIdNotFoundException id(UUID id) {
        return new DoggyIdNotFoundException("doggy id: " + id + ", not found");
    }

}
