package fr.groupe.pcube;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Log {
    private final UUID id;
    private final Date date;
    private final String message;
    private final int type; // 0: err, 1: transaction client,
    // 2: transaction fournisseur

    public Log(String message, int type) {
        this.id = UUID.randomUUID();
        this.date = Date.from(Instant.now());
        this.message = message;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public int getType() {
        return type;
    }
}
