package alexdev.doggyapp.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DOGGY")
public class Doggy implements Serializable {
    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String imageUrl;

    public static Doggy register(String name, String imageUrl) {
        return new Doggy(UUID.randomUUID(), name, imageUrl);
    }
}
