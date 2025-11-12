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

    public Client getClient() {
        return client;
    }

}
