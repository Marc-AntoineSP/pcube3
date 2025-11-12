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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
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
        Client other = (Client) obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

}
