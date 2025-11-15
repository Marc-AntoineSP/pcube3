package fr.groupe.pcube;

public class Etablissement {
    private final Cave cave;
    private final ServiceAlerte serviceAlerte;
    private final ServiceCommandeFournisseur serviceCommandeFournisseur;
    private final ServiceFournisseur serviceFournisseur;
    private final ServiceLogs serviceLogs;
    private final ServiceOrderClient serviceOrderClient;
    public Etablissement() {
        this.cave = new Cave();
        this.serviceAlerte = new ServiceAlerte(cave, 5);
        this.serviceCommandeFournisseur = new ServiceCommandeFournisseur();
        this.serviceFournisseur = new ServiceFournisseur();
        this.serviceLogs = new ServiceLogs();
        this.serviceOrderClient = new ServiceOrderClient();
    }

}
