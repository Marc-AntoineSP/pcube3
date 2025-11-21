#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vin")
public class Vin {
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int seuil;
    @Column(nullable = false)
    private int stock = 0;

    public Vin(String name, String type, int price){
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = 0;
    }

    public Vin(String name, String type, int price, int seuil) {
        this(name, type, price);
        this.seuil = seuil;
    }

    protected Vin(){
        //Vide pour Hibernate.
    }

    public int getSeuil(){
        return this.seuil;
    }
    public void setSeuil(int seuil){
        this.seuil = seuil;
    }
    public UUID getId() {
        return id;
    }
    public int getStock(){
        return this.stock;
    }
    public void setStock(int stock){
        if(stock < 0){
            throw new IllegalArgumentException("stock > 0");
        }
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Vin other = (Vin) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vin [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", seuil=" + seuil
                + ", stock=" + stock + "]";
    }
    

}
