package fr.groupe.pcube;

public class Client extends Personne {
    private final String password;

    public Client(int id, String name, String email, String password) {
        super(id, name, email);
        this.password = password;
    }

    public Client(int id, String name, String email, Address address,
            String password) {
        super(id, name, email, address);
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

}
