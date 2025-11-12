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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + type;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Log other = (Log) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (type != other.type)
            return false;
        return true;
    }
}
