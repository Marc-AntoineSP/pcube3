package fr.groupe.pcube;

public class ServiceGestionCommande {
    private ServiceCommandeFournisseur serviceCommandeFournisseur;
    private CommandeRepository commandeRepository;

    public ServiceGestionCommande(ServiceCommandeFournisseur serviceCommandeFournisseur, CommandeRepository commandeRepository) {
        this.serviceCommandeFournisseur = serviceCommandeFournisseur;
        this.commandeRepository = commandeRepository;
    }

    public void createCommande(Fournisseur fournisseur){
        System.out.println("Creation de commande...");
        this.serviceCommandeFournisseur.addCommande(fournisseur);
    }

    public void addVin(Vin vin, int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantité > 0");
        }
        System.out.println("Ajout a la commande...");
        Ligne ligne = new Ligne(vin, quantity);
        this.serviceCommandeFournisseur.addLigne(ligne);
        System.out.println(ligne);
    }

    public Commande getCommande(){
        return this.serviceCommandeFournisseur.getCommande();
    }

    public void removeLigne(Ligne ligne){
        this.serviceCommandeFournisseur.removeLigne(ligne);
        System.out.println("Suppression de ligne...");
    }

    public void cancelCommande(){
        this.serviceCommandeFournisseur.cancelCommande();
        System.out.println("Commande annulée");
    }

    public void deleteApresReception(){
        Commande commande = this.serviceCommandeFournisseur.getCommande();
        this.commandeRepository.save(commande);
        this.serviceCommandeFournisseur.deleteApresReception();
        System.out.println("Commande terminée");
        //TODO: Y METTRE UNE ALERTE ET TOUT.
    }
}
