package fr.groupe.pcube;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ligne> lignes = new ArrayList<>();

    public Order() {
        this.id = UUID.randomUUID();
        this.date = LocalDate.now();
    }

    public void setClient(Client client){
        this.client = client;
    }
    
    public void addLine(Ligne l) {
        this.lignes.add(l);
    }

    public void removeLine(Ligne l) throws IllegalArgumentException {
        if (!this.lignes.contains(l)) {
            throw new IllegalArgumentException("La ligne n'existe pas.");
        }
        this.lignes.remove(l);
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

    public LocalDate getDate() {
        return date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((client == null) ? 0 : client.hashCode());
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
        return true;
    }

    public Client getClient() {
        return client;
    }

}
