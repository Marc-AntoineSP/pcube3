package fr.groupe.pcube;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@Entity
public class Client extends Personne {

    public Client(String name, String email, Address address) {
        super(name, email, address);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
