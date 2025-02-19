package sn.sdley;

import java.util.HashMap;
import java.util.Map;

public class GestionProduits {
    /**
     * Nous utilisons un HashMap<String, Produit> où la clé est l'ID du produit
     * et la valeur est l'objet Produit. Cela permet une recherche rapide.
     */
    private Map<String, Produit> produits;

    public GestionProduits() {
        this.produits = new HashMap<>();
    }

    // Ajouter un produit à la collection
    public void ajouterProduit(String id, String nom) {
        produits.put(id, new Produit(id, nom));
    }

    // Vérifier si un produit existe par son nom
    public boolean rechercherProduit(String nomProduit) {
        if (nomProduit == null || nomProduit.trim().isEmpty()) {
            return false; // Empêche les recherches invalides
        }

        return produits.values().stream()
                .anyMatch(produit -> produit.getNom().equalsIgnoreCase(nomProduit));
    }
}
