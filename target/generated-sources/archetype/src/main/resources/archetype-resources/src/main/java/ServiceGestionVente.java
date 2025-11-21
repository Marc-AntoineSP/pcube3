#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

public class ServiceGestionVente {
    private final Cave cave;
    private final ServiceLogs serviceLogs;
    private final ServiceAlerte serviceAlerte;
    private final ServiceGestionClient serviceGestionClient;
    private final ServiceGestionOrder serviceGestionOrder;
    //TODO: Insérer gestion de pdf

    public ServiceGestionVente(Cave cave, ServiceLogs serviceLogs, ServiceAlerte serviceAlerte, ServiceGestionClient serviceGestionClient, ServiceGestionOrder serviceGestionOrder){
        this.cave = cave;
        this.serviceLogs = serviceLogs;
        this.serviceAlerte = serviceAlerte;
        this.serviceGestionClient = serviceGestionClient;
        this.serviceGestionOrder = serviceGestionOrder;
    }

    /*VENTE :
     * Commande client a une ligne minimum
     * Verif des stocks pour les lignes
     * Decrementer les stocks
     * Logger
     * Alerte si jamais
     * Clean a la fin
     * Puis commande DB une fois que tout est clean.
     */
    public void vente(Order order){
        try{
            for(Ligne l : order.getLignes()){
                if(this.cave.getStock(l.getVin())<l.getQuantity()) throw new IllegalArgumentException("Pas assez de vin, annulation de la commande.");
            }
            for(Ligne l : order.getLignes()){
                this.cave.decreaseStock(l.getVin(), l.getQuantity());
                this.serviceLogs.addLog(new Log("Vente : "+l.getVin().getName()+", quantité : "+l.getQuantity(), TypeLog.VENTE));
                this.serviceAlerte.checkStock(l.getVin());
                this.serviceGestionOrder.clearOrderApresVente();
                //TODO: PDF ICI.
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

// Gestion des ventes : 
//  Enregistrer les clients avec leurs informations (nom, mail, adresse postale). 
//  Gérer le stock de vins et la quantité disponible. 
//  Lorsqu’un vin est vendu, le stock est décrémenté. 
//  Alerte par mail lorsque le stock d'un vin est trop bas. 
//  Intégration d’une API pour récupérer une liste de vins (nom, type, prix) pour enrichir la base de données du 
// caviste. 
//  Générer un ticket de caisse au format PDF après chaque vente.