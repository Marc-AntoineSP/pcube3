package fr.groupe.pcube;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrateur")
public class Administrateur extends Personne{
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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

    public Administrateur(){
        //Hibernate :3
    }
    public String getPassword(){
        return this.password;
    }

    public Role getRole(){
        return this.role;
    }
}
