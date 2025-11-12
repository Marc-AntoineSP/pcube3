package fr.groupe.pcube;

public class Ligne {
    private final Vin vin;
    private int quantity;
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

    public void increaseQuantity() {
        this.quantity += 1;
    }

    public double getPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Vin : " + this.vin.getType() + " " + this.vin.getName()
                + ". Quantité : " + this.quantity + ". Total = "
                + this.getPrice();
    }

}
