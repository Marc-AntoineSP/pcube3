package fr.groupe.pcube;

public class Ligne {
    private final Vin vin;
    private final int quantity;
    private final double price;

    protected Ligne(Vin vin, int quantity) {
        this.vin = vin;
        this.quantity = quantity;
        this.price = this.quantity * this.vin.getPrice();
    }

    public Vin getVin() {
        return vin;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

}
