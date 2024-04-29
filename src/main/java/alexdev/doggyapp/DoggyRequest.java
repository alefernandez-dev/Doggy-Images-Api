package alexdev.doggyapp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record DoggyRequest(
        @NotNull(message = "name cannot be null")
        @NotBlank(message = "name cannot be blank")
        @Size(min = 3, max = 100, message = "name must be between 3 and 100 characters long")
        String name,
        @NotNull(message = "image URL cannot be null")
        @NotBlank(message = "image URL cannot be blank")
        String imageUrl) implements Serializable {}
