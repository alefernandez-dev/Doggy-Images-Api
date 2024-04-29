package alexdev.doggyapp.app.usecase;

import alexdev.doggyapp.app.exception.DoggyIdNotFoundException;

import java.util.UUID;

public interface DeleteDoggyByIdUseCase {
    void delete(UUID id) throws DoggyIdNotFoundException;
}
