package fr.groupe.pcube;

public class Administrateur extends Personne{
    private String password;
    private Role role;

    public Administrateur(int id, String name, String email, String password) {
        super(id, name, email);
        this.password = password;
        this.role = Role.ADMINISTRATEUR;
    }

    public Administrateur(int id, String name, String email, Address address, String password) {
        super(id, name, email, address);
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public Role getRole(){
        return this.role;
    }
}
