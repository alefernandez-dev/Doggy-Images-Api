package alexdev.doggyapp;

import alexdev.doggyapp.app.usecase.*;
import alexdev.doggyapp.app.exception.DoggyIdNotFoundException;
import alexdev.doggyapp.app.exception.DoggyNameAlreadyExitsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/doggy")
public class DoggyHttp {


    private final RegisterDoggyUseCase registerDoggy;
    private final ListAllDoggiesUseCase listAllDoggies;
    private final DeleteDoggyByIdUseCase deleteDoggy;
    private final UpdateDoggyUseCase updateDoggy;

    @PostMapping
    public ResponseEntity<MessageResponse> register(@RequestBody DoggyRequest doggyRequest) {

        try {

            registerDoggy.register(doggyRequest);

            return ResponseEntity.ok(MessageResponse.single("Success: doggy registered successfully"));

        } catch (DoggyNameAlreadyExitsException e) {
            return ResponseEntity.badRequest().body(MessageResponse.single(e.getMessage()));
        }

    }

    @GetMapping
    public ResponseEntity<List<DoggyResponse>> listAll() {

        var doggies = listAllDoggies.listAll().stream().map(DoggyMapper::mapToDoggyResponse).toList();

        return ResponseEntity.ok(doggies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable UUID id) {

        try {

            deleteDoggy.delete(id);

            return ResponseEntity.ok(MessageResponse.single("Success: doggy deleted successfully"));

        } catch (DoggyIdNotFoundException e) {
            return ResponseEntity.badRequest().body(MessageResponse.single("Error: " + e.getMessage()));
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@RequestBody DoggyRequest doggyRequest, @PathVariable UUID id) {

        try {

            updateDoggy.update(doggyRequest, id);

            return ResponseEntity.ok(MessageResponse.single("Success: doggy updated successfully"));

        } catch (DoggyNameAlreadyExitsException | DoggyIdNotFoundException e) {
            return ResponseEntity.badRequest().body(MessageResponse.single("Error: " + e.getMessage()));
        }
    }
}
