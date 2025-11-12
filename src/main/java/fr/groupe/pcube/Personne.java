package fr.groupe.pcube;

public abstract class Personne {
    private final int id;
    private String name;
    private String email;
    private Address address;

    protected Personne(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    protected Personne(int id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
