package fr.groupe.pcube;

import java.util.HashMap;
import java.util.Map;

public class ServiceCommandeFournisseur {
    private final Map<Fournisseur, Commande> commandesEncours;

    public ServiceCommandeFournisseur() {
        this.commandesEncours = new HashMap<>();
    }

    public void addCommandes(Commande commande) {
        if (!this.commandesEncours.containsKey(commande.getFournisseur())) {
            this.commandesEncours.put(commande.getFournisseur(), commande);
        }
    }
}
