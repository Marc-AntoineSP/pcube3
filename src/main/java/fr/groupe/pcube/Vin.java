package fr.groupe.pcube;

import java.util.UUID;

public class Vin {
    private UUID id;
    private String name;
    private String type;
    private int price;
    private int seuil;

    public Vin(String name, String type, int price){
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Vin(String name, String type, int price, int seuil) {
        this(name, type, price);
        this.seuil = seuil;
    }

    public Vin(){
        //Vide pour Hibernate.
    };

    public int getSeuil(){
        return this.seuil;
    }
    public void setSeuil(int seuil){
        this.seuil = seuil;
    }
    public UUID getId() {
        return id;
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

}
