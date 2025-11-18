package fr.groupe.pcube;

public class ServiceGestionOrder {
    private ServiceOrderClient serviceOrderClient;

    public ServiceGestionOrder(ServiceOrderClient serviceOrderClient){
        this.serviceOrderClient = serviceOrderClient;
    }

    public void createOrder(){
        if(this.serviceOrderClient.hasOrder()){
            throw new IllegalStateException("Une commande est déjà en cours");
        }
        System.out.println("Creation de la commande client");
        this.serviceOrderClient.createOrder();
    }

    public void addProduct(Vin vin, int quantity){
        if(!this.serviceOrderClient.hasOrder()){
            throw new IllegalStateException("Aucune commande en cours.");
        }
        System.out.println("Ajout de "+vin.getName()+" à la commande.");
        Ligne ligne = new Ligne(vin, quantity);
        this.serviceOrderClient.addLine(ligne);
        System.out.println("Ajout : "+ligne);
    }

    public void addClient(Client client){
        if(!this.serviceOrderClient.hasOrder()){
            throw new IllegalStateException("Aucune commande en cours");
        }
        this.serviceOrderClient.addClient(client);
        System.out.println("Client : "+client.getEmail()+ " associé à la commande !");
    }

    public Order getOrder(){
        return this.serviceOrderClient.getOrder();
    }

    public void cancelOrder(){
        if(!this.serviceOrderClient.hasOrder()){
            throw new IllegalStateException("Aucun commande en cours");
        }
        this.serviceOrderClient.cancelOrder();
        System.out.println("Commande annulée");
    }

    public void clearOrderApresVente(){
        this.serviceOrderClient.deleteApresVente();
        System.out.println("Pret pour une autre commande client !");
    }
}
