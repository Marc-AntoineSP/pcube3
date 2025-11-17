package fr.groupe.pcube;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrateur")
public class Administrateur extends Personne{
    private String password;
    private Role role;

    public Administrateur(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email);
        this.password = password;
        this.role = Role.ADMINISTRATEUR;
    }

    public Administrateur(String firstName, String lastName, String email, Address address, String password) {
        super(firstName, lastName, email, address);
        this.password = password;
        this.role = Role.ADMINISTRATEUR;
    }

    public String getPassword(){
        return this.password;
    }

    public Role getRole(){
        return this.role;
    }
}
