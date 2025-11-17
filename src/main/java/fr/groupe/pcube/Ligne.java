package fr.groupe.pcube;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ligne")
public class Ligne {
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "vin_id", nullable = false)
    private Vin vin;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
    @Column(nullable = false)
    private int quantity;

    protected Ligne(){
        //for hibernato del la vega
    }
    protected Ligne(Vin vin, int quantity) {
        this.vin = vin;
        this.quantity = quantity;
    }

    public void setOrder(Order order){
        this.order = order;
    }
    public Order getOrder(){
        return this.order;
    }

    public void setCommande(Commande commande){
        this.commande = commande;
    }
    public Commande getCommande(){
        return this.commande;
    }

    public static Ligne forOrder(Order order, Vin vin, int quantity){
        Ligne ligne = new Ligne(vin, quantity);
        ligne.setOrder(order);
        return ligne;
    }

    public static Ligne forCommande(Commande commande, Vin vin, int quantity){
        Ligne ligne = new Ligne(vin, quantity);
        ligne.setCommande(commande);
        return ligne;
    }

    public Vin getVin() {
        return vin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity += 1;
    }

    public double getPrice() {
        return this.vin.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Vin : " + this.vin.getType() + " " + this.vin.getName()
                + ". Quantité : " + this.quantity + ". Total = "
                + this.getPrice();
    }

}
