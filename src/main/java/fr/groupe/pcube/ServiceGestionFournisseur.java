package fr.groupe.pcube;

import java.util.List;
import java.util.UUID;

public class ServiceGestionFournisseur {
    private final FournisseurRepository fournisseurRepository;

    public ServiceGestionFournisseur(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public Fournisseur addFournisseur(String firstName, String lastName, String email, Address address){
        Fournisseur exists = fournisseurRepository.findByEmail(email);
        if(exists != null){
            return exists;
        }
        Fournisseur newFournisseur = new Fournisseur(firstName, lastName, email, address);
        this.fournisseurRepository.save(newFournisseur);
        return newFournisseur;
    }

    public List<Fournisseur> listFournisseurs(){
        return this.fournisseurRepository.findAll();
    }

    public Fournisseur getByEmail(String email){
        Fournisseur fournisseur = this.fournisseurRepository.findByEmail(email);
        if(fournisseur == null){
            throw new IllegalArgumentException("Aucun fournisseur avec le mail : "+email);
        }
        return fournisseur;
    }

    public Fournisseur getById(UUID id){
        Fournisseur fournisseur = this.fournisseurRepository.findById(id);
        if(fournisseur == null){
            throw new IllegalArgumentException("Aucun fournisseur avec l'id : "+id.toString());
        }
        return fournisseur;
    }

    public void addVinToFournisseur(Fournisseur fournisseur, Vin vin){
        fournisseur.addVin(vin);
        this.fournisseurRepository.update(fournisseur);
    }
}
