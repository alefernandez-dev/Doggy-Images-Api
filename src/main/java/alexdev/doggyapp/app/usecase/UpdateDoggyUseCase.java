package alexdev.doggyapp.app.usecase;

import alexdev.doggyapp.DoggyRequest;
import alexdev.doggyapp.app.exception.DoggyIdNotFoundException;
import alexdev.doggyapp.app.exception.DoggyNameAlreadyExitsException;

import java.util.UUID;


public interface UpdateDoggyUseCase {
    void update(DoggyRequest doggyRequest, UUID doggyId) throws DoggyNameAlreadyExitsException, DoggyIdNotFoundException;
}
