#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur extends Personne {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fournisseur_id")
    private List<Vin> vinsList = new ArrayList<>();

    public Fournisseur(){
        super();
    }

    public Fournisseur(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.vinsList = new ArrayList<>();
    }

    public Fournisseur(String firstName, String lastName, String email, Address address) {
        super(firstName, lastName, email, address);
        this.vinsList = new ArrayList<>();
    }

    public List<Vin> getList(){
        return vinsList;
    }

    public Vin getVinByName(String name) throws IllegalArgumentException {
        return vinsList.stream()
            .filter(v -> v.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Pas de vin avec le nom "+name));
    }

    public boolean hasVin(Vin vin) {
        return this.vinsList.contains(vin);
    }

    public void addVin(Vin vin) {
        if(!this.hasVin(vin)){
            vinsList.add(vin);
        }
    }
}
