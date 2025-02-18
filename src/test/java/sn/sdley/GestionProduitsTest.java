package sn.sdley;

import sn.sdley.GestionProduits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestionProduitsTest {

    @Test
    @DisplayName("Test recherche d'un produit présent")
    public void testProduitPresent() {
        assertTrue(GestionProduits.rechercherProduit("Riz"),
                "Le produit 'Riz' devrait être trouvé dans la liste.");
    }

    @Test
    @DisplayName("Test recherche d'un produit absent")
    public void testProduitAbsent() {
        assertFalse(GestionProduits.rechercherProduit("Pâtes"),
                "Le produit 'Pâtes' ne devrait pas être trouvé dans la liste.");
    }

    @Test
    @DisplayName("Test recherche avec une chaîne vide ou null")
    public void testRechercheVideOuNull() {
        assertAll(
                () -> assertFalse(GestionProduits.rechercherProduit(""),
                        "Une chaîne vide ne devrait pas être considérée comme un produit valide."),

                () -> assertFalse(GestionProduits.rechercherProduit("   "),
                        "Une chaîne contenant uniquement des espaces ne devrait pas être trouvée."),

                () -> assertFalse(GestionProduits.rechercherProduit(null),
                        "La recherche d'un produit null ne devrait pas être trouvée.")
        );
    }
}
