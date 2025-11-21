#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne(optional = false)
    @JoinColumn(name = "fournisseur_id", nullable = false)
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ligne> lignes = new ArrayList<>();

    public Commande(){
        //Hibernato
    }
    public Commande(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
        this.id = UUID.randomUUID();
        this.date = LocalDate.now();
        this.lignes = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public void addLignes(Ligne l) {
        this.lignes.add(l);
    }

    public void removeLigne(Ligne l){
        if(!this.lignes.contains(l)){
            throw new IllegalArgumentException("La ligne n'existe pas");
        }
        this.lignes.remove(l);
    }

    public double getTotal() {
        return this.lignes.stream().mapToDouble(Ligne::getPrice).sum();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((fournisseur == null) ? 0 : fournisseur.hashCode());
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
        Commande other = (Commande) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (fournisseur == null) {
            if (other.fournisseur != null)
                return false;
        } else if (!fournisseur.equals(other.fournisseur))
            return false;
        return true;
    }

    

}
