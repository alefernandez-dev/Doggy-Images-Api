package alexdev.doggyapp.app;

import alexdev.doggyapp.DoggyMapper;
import alexdev.doggyapp.DoggyRequest;
import alexdev.doggyapp.app.domain.DoggyJpaRepository;
import alexdev.doggyapp.app.exception.DoggyIdNotFoundException;
import alexdev.doggyapp.app.exception.DoggyNameAlreadyExitsException;
import alexdev.doggyapp.app.usecase.UpdateDoggyUseCase;
import alexdev.doggyapp.app.validator.DoggyRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class UpdateDoggyService implements UpdateDoggyUseCase {

    private final DoggyJpaRepository repository;
    private final DoggyRequestValidator validator;

    @Override
    public void update(DoggyRequest doggyRequest, UUID doggyId) throws DoggyNameAlreadyExitsException, DoggyIdNotFoundException {

        validator.validate(doggyRequest);

        if(!repository.existsById(doggyId)) {
            throw DoggyIdNotFoundException.id(doggyId);
        }

        if(repository.existsByNameAndIdNot(doggyRequest.name(), doggyId)) {
            throw DoggyNameAlreadyExitsException.name(doggyRequest.name());
        }

        var doggy = DoggyMapper.mapToDoggy(doggyRequest);
        doggy.setId(doggyId);

        repository.save(doggy);

    }
}
