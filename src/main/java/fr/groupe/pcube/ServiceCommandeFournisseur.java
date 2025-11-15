package fr.groupe.pcube;

import java.util.HashMap;
import java.util.Map;

public class ServiceCommandeFournisseur {
    private final Map<Fournisseur, Commande> commandesEncours;

    public ServiceCommandeFournisseur() {
        this.commandesEncours = new HashMap<>();
    }

    public void addCommande(Commande commande) {
        if (!this.commandesEncours.containsKey(commande.getFournisseur())) {
            this.commandesEncours.put(commande.getFournisseur(), commande);
        }
    }

    public void deleteCommande(Commande commande){
        if(this.commandesEncours.containsKey(commande.getFournisseur())) {
            this.commandesEncours.remove(commande.getFournisseur(), commande);
        }
    }
}
