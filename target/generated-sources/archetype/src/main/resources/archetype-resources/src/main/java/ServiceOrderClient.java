#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

public class ServiceOrderClient {
    private Order currentOrder;

    public ServiceOrderClient() {
        //Oui.
    }

    public boolean hasOrder(){
        return currentOrder != null;
    }

    public Order getOrder(){
        if(!this.hasOrder()){
            throw new IllegalStateException("No order");
        }
        return this.currentOrder;
    }

    public void addClient(Client client){
        this.currentOrder.setClient(client);
    }

    public void addLine(Ligne ligne){
        if(!hasOrder()){
            throw new IllegalStateException("No order");
        }
        this.currentOrder.addLine(ligne);
    }

    public void removeLine(Ligne ligne){
        if(!hasOrder()){
            throw new IllegalStateException("No order");
        }
        this.currentOrder.removeLine(ligne);
    }

    public void cancelOrder(){
        if(!hasOrder()){
            throw new IllegalStateException("No order");
        }
        this.currentOrder = null;
    }

    public void deleteApresVente(){
        this.currentOrder = null;
    }

    public void createOrder(){
        this.currentOrder = new Order();
    }

}

// VENTE : CREATION D'UNE COMMANDE CLIENT -> AJOUT DES LIGNES
// -> Deletion possible de lignes -> Clear apres le paiement (ou annulation).
