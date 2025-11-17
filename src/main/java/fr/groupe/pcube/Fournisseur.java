package fr.groupe.pcube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur extends Personne {
    private Map<String, Vin> vins;
    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    private List<Vin> vinsList = new ArrayList<>();

    public Fournisseur(){
        super();
    }

    public Fournisseur(String name, String email) {
        super(name, email);
        this.vins = new HashMap<>();
    }

    public Fournisseur(String name, String email, Address address) {
        super(name, email, address);
        this.vins = new HashMap<>();
    }

    public Fournisseur(String name, String email, Vin vin) {
        super(name, email);
        this.vins = new HashMap<>();
        this.vins.put(vin.getName(), vin);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((vins == null) ? 0 : vins.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fournisseur other = (Fournisseur) obj;
        if (vins == null) {
            if (other.vins != null)
                return false;
        } else if (!vins.equals(other.vins))
            return false;
        return true;
    }

    public Vin getVin(String vin) throws IllegalArgumentException {
        if (!this.vins.containsKey(vin)) {
            throw new IllegalArgumentException(
                    "Aucun vin ne correspond au vin demandé");
        }
        return this.vins.get(vin);
    }

    public boolean hasVin(String vin) {
        return this.vins.containsKey(vin);
    }

    public void addVin(Vin vin) {
        this.vins.put(vin.getName(), vin);
    }
}
