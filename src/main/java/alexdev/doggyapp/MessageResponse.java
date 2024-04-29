package alexdev.doggyapp;

import java.io.Serializable;
import java.util.List;

public record MessageResponse(List<String> messages) implements Serializable {

    public static MessageResponse single(String message) {
        return new MessageResponse(List.of(message));
    }

    public static MessageResponse list(List<String> messages) {
        return new MessageResponse(messages);
    }
}
