package fr.groupe.pcube;

import java.util.HashMap;
import java.util.Map;

public class Fournisseur extends Personne {
    private final Map<String, Vin> vins;

    public Fournisseur(int id, String name, String email) {
        super(id, name, email);
        this.vins = new HashMap<>();
    }

    public Fournisseur(int id, String name, String email, Address address) {
        super(id, name, email, address);
        this.vins = new HashMap<>();
    }

    public Fournisseur(int id, String name, String email, Vin vin) {
        super(id, name, email);
        this.vins = new HashMap<>();
        this.vins.put(vin.getName(), vin);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vins == null) ? 0 : vins.hashCode());
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
        Fournisseur other = (Fournisseur) obj;
        if (vins == null) {
            if (other.vins != null)
                return false;
        } else if (!vins.equals(other.vins))
            return false;
        return true;
    }

    public Fournisseur(int id, String name, String email, Address address,
            Vin vin) {
        super(id, name, email, address);
        this.vins = new HashMap<>();
        this.vins.put(vin.getName(), vin);
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
