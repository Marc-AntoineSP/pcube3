package fr.groupe.pcube;

public class Ligne {
    private final Vin vin;
    private int quantity;

    protected Ligne(Vin vin, int quantity) {
        this.vin = vin;
        this.quantity = quantity;
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
