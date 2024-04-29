package alexdev.doggyapp;

import alexdev.doggyapp.app.domain.Doggy;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class DoggyMapper {

    public static Doggy mapToDoggy(DoggyRequest d) {
        return Doggy.register(d.name(), d.imageUrl());
    }

    public static Doggy mapToDoggyWithId(DoggyRequest d, UUID id) {
        return new Doggy(id, d.name(), d.imageUrl());
    }


    public static DoggyResponse mapToDoggyResponse(Doggy d) {
        return new DoggyResponse(d.getId(), d.getName(), d.getImageUrl());
    }

}
