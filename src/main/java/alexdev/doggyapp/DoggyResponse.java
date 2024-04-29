package alexdev.doggyapp;

import java.io.Serializable;
import java.util.UUID;

public record DoggyResponse(UUID id, String name, String imageUrl) implements Serializable {
}
