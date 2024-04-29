package alexdev.doggyapp.app.usecase;

import alexdev.doggyapp.app.domain.Doggy;

import java.util.List;

public interface ListAllDoggiesUseCase {
    List<Doggy> listAll();
}
