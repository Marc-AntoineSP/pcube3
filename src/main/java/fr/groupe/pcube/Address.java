package fr.groupe.pcube;

import jakarta.persistence.Embeddable;
@Embeddable
public class Address {
    private int codePostal;
    private String rue;
    private int numero;
    private String ville;
    private String pays;

    public Address(int numero, String rue, String ville, int codePostal,
            String pays) {
        this.codePostal = codePostal;
        this.rue = rue;
        this.numero = numero;
        this.ville = ville;
        this.pays = pays;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return this.numero + " rue " + this.rue + " " + this.ville + " "
                + this.codePostal + " " + this.pays;
    }

}
