package fr.groupe.pcube;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Commande {
    private final UUID id;
    private final Date date;
    private final Fournisseur fournisseur;
    private final List<Ligne> lignes;

    public Commande(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
        this.id = UUID.randomUUID();
        this.date = Date.from(Instant.now());
        this.lignes = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public void addLignes(Ligne l) {
        this.lignes.add(l);
    }

    public double getTotal() {
        return this.lignes.stream().mapToDouble(Ligne::getPrice).sum();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result
                + ((fournisseur == null) ? 0 : fournisseur.hashCode());
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
        Commande other = (Commande) obj;
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
        if (fournisseur == null) {
            if (other.fournisseur != null)
                return false;
        } else if (!fournisseur.equals(other.fournisseur))
            return false;
        if (lignes == null) {
            if (other.lignes != null)
                return false;
        } else if (!lignes.equals(other.lignes))
            return false;
        return true;
    }

}
