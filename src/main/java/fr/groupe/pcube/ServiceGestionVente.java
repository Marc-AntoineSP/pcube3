package fr.groupe.pcube;

public class ServiceGestionVente {
    private final Cave cave;
    private final ServiceLogs serviceLogs;
    private final ServiceAlerte serviceAlerte;
    //TODO: Insérer gestion de pdf

    public ServiceGestionVente(Cave cave, ServiceLogs serviceLogs, ServiceAlerte serviceAlerte){
        this.cave = cave;
        this.serviceLogs = serviceLogs;
        this.serviceAlerte = serviceAlerte;
    }

    public void vente(Order order){
        try{
            for(Ligne l : order.getLignes()){
                if(this.cave.getStock(l.getVin())<l.getQuantity()) throw new IllegalArgumentException("Pas assez de vin, annulation de la commande.");
            }
            for(Ligne l : order.getLignes()){
                this.cave.decreaseStock(l.getVin(), l.getQuantity());
                this.serviceLogs.addLog(new Log("Vente : "+l.getVin()+", quantité : "+l.getQuantity(), 1));
                this.serviceAlerte.checkStock(l.getVin());
                //TODO: PDF ICI.
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
