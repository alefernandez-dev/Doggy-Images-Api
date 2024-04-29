package alexdev.doggyapp.app.usecase;

import alexdev.doggyapp.DoggyRequest;
import alexdev.doggyapp.app.exception.DoggyNameAlreadyExitsException;

public interface RegisterDoggyUseCase {
    void register(DoggyRequest doggyRequest) throws DoggyNameAlreadyExitsException;
}
