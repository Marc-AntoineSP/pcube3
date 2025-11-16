package fr.groupe.pcube;

public class Vin {
    private final int id;
    private final String name;
    private final String type;
    private int price;
    private int seuil;

    public Vin(int id, String name, String type, int price, int seuil) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.seuil = seuil;
    }

    public int getSeuil(){
        return this.seuil;
    }
    public void setSeuil(int seuil){
        this.seuil = seuil;
    }
    public int getId() {
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
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + price;
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
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (price != other.price)
            return false;
        return true;
    }

}
