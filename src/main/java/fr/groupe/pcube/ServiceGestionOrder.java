package fr.groupe.pcube;

public class ServiceGestionOrder {
    private ServiceOrderClient serviceOrderClient;

    public ServiceGestionOrder(ServiceOrderClient serviceOrderClient){
        this.serviceOrderClient = serviceOrderClient;
    }

    public void createOrder(){
        System.out.println("Creation de la commande client : ");
        this.serviceOrderClient.createOrder();
    }

    public void addProduct(Vin vin, int quantity){
        System.out.println("Ajout de "+vin.getName()+" à la commande.");
        Ligne ligne = new Ligne(vin, quantity);
        this.serviceOrderClient.addLine(ligne);
        System.out.println(ligne);
    }

    public void addClient(Client client){
        this.serviceOrderClient.addClient(client);
    }

    public Order getOrder(){
        return this.serviceOrderClient.getOrder();
    }

    public void clearOrderApresVente(){
        this.serviceOrderClient.deleteApresVente();
    }
}
