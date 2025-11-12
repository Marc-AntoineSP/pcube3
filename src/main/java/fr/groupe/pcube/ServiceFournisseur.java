package fr.groupe.pcube;

import java.util.ArrayList;
import java.util.List;

public class ServiceFournisseur {
    private final List<Fournisseur> fournisseurs;

    public ServiceFournisseur() {
        this.fournisseurs = new ArrayList<>();
    }

    public void add(Fournisseur fournisseur) {
        this.fournisseurs.add(fournisseur);
    }

    public void remove(Fournisseur fournisseur) {
        this.fournisseurs.remove(fournisseur);
    }
}
