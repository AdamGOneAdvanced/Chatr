package Chatr.Domain;

import java.util.UUID;

public class Entity {

    private UUID id;
    public Entity(UUID id) {
        this.id = id == null ? UUID.fromString("00000000-0000-0000-0000-000000000000") : id;
    }

    public UUID getId() {
        return id;
    }
}
