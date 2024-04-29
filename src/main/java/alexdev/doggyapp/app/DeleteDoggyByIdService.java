package alexdev.doggyapp.app;

import alexdev.doggyapp.app.usecase.DeleteDoggyByIdUseCase;
import alexdev.doggyapp.app.exception.DoggyIdNotFoundException;
import alexdev.doggyapp.app.domain.DoggyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeleteDoggyByIdService implements DeleteDoggyByIdUseCase {

    private final DoggyJpaRepository repository;


    @Override
    public void delete(UUID id) throws DoggyIdNotFoundException {

        if(!repository.existsById(id)) {
            throw DoggyIdNotFoundException.id(id);
        }


        repository.deleteById(id);

    }
}
