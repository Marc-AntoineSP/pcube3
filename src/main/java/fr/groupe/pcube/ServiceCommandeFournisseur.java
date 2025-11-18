package fr.groupe.pcube;

import java.util.HashMap;
import java.util.Map;

public class ServiceCommandeFournisseur {
    private Commande currentCommande;

    public ServiceCommandeFournisseur() {
        //Oui.
    }

    public boolean hasCommande(){
        return currentCommande != null;
    }

    public Commande getCommande(){
        if(!this.hasCommande()){
            throw new IllegalStateException("Aucune commande.");
        }
        return this.currentCommande;
    }

    //ON PART DU PRINCIPE QU ON CONNAIT LE FOURNISSEUR AVANT DE COMMENCER LA COMMANDE.
    public void addCommande(Fournisseur fournisseur) {
        if(hasCommande()){
            throw new IllegalStateException("Commande déjà en cours");
        }
        this.currentCommande = new Commande(fournisseur);
    }

    public void addLigne(Ligne ligne){
        if(!hasCommande()){
            throw new IllegalStateException("Aucune commande en cours");
        }
        this.currentCommande.addLignes(ligne);
    }

    public void removeLigne(Ligne ligne){
        if(!this.hasCommande()){
            throw new IllegalStateException("Aucune commande en cours");
        }
        this.currentCommande.removeLigne(ligne);
    }

    public void cancelCommande(){
        if(!this.hasCommande()){
            throw new IllegalStateException("Rien à cancel");
        }
        this.currentCommande = null;
    }

    public void deleteApresReception(){
        this.currentCommande = null;
    }
}
