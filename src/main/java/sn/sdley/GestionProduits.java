package sn.sdley;

import java.util.Arrays;
import java.util.List;

public class GestionProduits {
    private static final List<String> produits = Arrays.asList(
            "Riz", "Sucre", "Huile", "Lait", "Pain", "Café", "Beurre", "Jus", "Farine"
    );

    // Méthode qui recherche un produit dans la liste
    public static boolean rechercherProduit(String nomProduit) {
        if (nomProduit == null || nomProduit.trim().isEmpty()) {
            return false; // Retourne false si la chaîne est vide ou null
        }
        return produits.contains(nomProduit);
    }
}
