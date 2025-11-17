package fr.groupe.pcube;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Personne {

    public Client(String firstName, String lastName, String email, Address address) {
        super(firstName, lastName, email, address);
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
