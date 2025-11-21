#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

public class Etablissement {
    private final Cave cave;
    private final ServiceAlerte serviceAlerte;
    private final ServiceCommandeFournisseur serviceCommandeFournisseur;
    private final ServiceFournisseur serviceFournisseur;
    private final ServiceLogs serviceLogs;
    private final ServiceOrderClient serviceOrderClient;

    public Etablissement() {
        this.cave = new Cave();
        this.serviceAlerte = new ServiceAlerte(cave);
        this.serviceCommandeFournisseur = new ServiceCommandeFournisseur();
        this.serviceFournisseur = new ServiceFournisseur();
        this.serviceLogs = new ServiceLogs();
        this.serviceOrderClient = new ServiceOrderClient();
    }

}
