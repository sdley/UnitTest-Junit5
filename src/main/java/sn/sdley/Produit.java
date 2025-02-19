package sn.sdley;

public class Produit {
    private String id;
    private String nom;

    public Produit(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
