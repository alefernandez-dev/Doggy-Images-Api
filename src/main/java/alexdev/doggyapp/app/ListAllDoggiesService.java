package alexdev.doggyapp.app;

import alexdev.doggyapp.app.usecase.ListAllDoggiesUseCase;
import alexdev.doggyapp.app.domain.Doggy;
import alexdev.doggyapp.app.domain.DoggyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ListAllDoggiesService implements ListAllDoggiesUseCase {

    private final DoggyJpaRepository repository;

    @Override
    public List<Doggy> listAll() {
        return repository.findAll();
    }
}
