package fr.groupe.pcube;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final Date date;
    private final Client client;
    private final List<Ligne> lignes;

    public Order(Client client) {
        this.id = UUID.randomUUID();
        this.date = Date.from(Instant.now());
        this.client = client;
        this.lignes = new ArrayList<>();
    }

    public void addLine(Ligne l) {
        this.lignes.add(l);
    }

    public List<Ligne> getLignes() {
        return this.lignes;
    }

    public double getTotal() {
        return this.lignes.stream().mapToDouble(Ligne::getPrice).sum();
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((client == null) ? 0 : client.hashCode());
        result = prime * result + ((lignes == null) ? 0 : lignes.hashCode());
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
        Order other = (Order) obj;
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
        if (client == null) {
            if (other.client != null)
                return false;
        } else if (!client.equals(other.client))
            return false;
        if (lignes == null) {
            if (other.lignes != null)
                return false;
        } else if (!lignes.equals(other.lignes))
            return false;
        return true;
    }

    public Client getClient() {
        return client;
    }

}
