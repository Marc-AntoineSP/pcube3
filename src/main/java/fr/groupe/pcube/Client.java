package fr.groupe.pcube;

public class Client extends Personne {

    public Client(int id, String name, String email, Address address) {
        super(id, name, email, address);
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
