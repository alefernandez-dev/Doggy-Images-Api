package alexdev.doggyapp.app;

import alexdev.doggyapp.DoggyMapper;
import alexdev.doggyapp.DoggyRequest;
import alexdev.doggyapp.app.exception.DoggyNameAlreadyExitsException;
import alexdev.doggyapp.app.usecase.RegisterDoggyUseCase;
import alexdev.doggyapp.app.domain.DoggyJpaRepository;
import alexdev.doggyapp.app.validator.DoggyRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class RegisterDoggyService implements RegisterDoggyUseCase {

    private final DoggyJpaRepository repository;
    private final DoggyRequestValidator validator;


    @Override
    public void register(DoggyRequest doggyRequest) throws DoggyNameAlreadyExitsException {

        validator.validate(doggyRequest);

        var doggy = DoggyMapper.mapToDoggy(doggyRequest);

        if(repository.existsByName(doggy.getName())) {
            throw DoggyNameAlreadyExitsException.name(doggy.getName());
        }

        repository.save(doggy);

    }
}
