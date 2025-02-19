package sn.sdley;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestionProduitsTest {
    private GestionProduits gestionProduits;

    @BeforeEach
    public void setUp() {
        gestionProduits = new GestionProduits();
        gestionProduits.ajouterProduit("1", "Riz");
        gestionProduits.ajouterProduit("2", "Mil");
        gestionProduits.ajouterProduit("3", "Sucre");
    }

    @AfterEach
    public void tearDown() {
        gestionProduits = null;
    }

    @Test
    @DisplayName("Recherche de produit present")
    public void testProduitPresent() {
        assertTrue(gestionProduits.rechercherProduit("Riz"),
                "Le produit 'Riz' doit être trouvé");
    }

    @Test
    @DisplayName("Recherche de produit absent")
    public void testProduitAbsent() {
        assertFalse(gestionProduits.rechercherProduit("Café"),
                "Le produit 'Café' ne doit pas être trouvé");
    }

    @Test
    @DisplayName("Recherche de produit avec chaines vides")
    public void testRechercheAvecChaineVide() {
        assertFalse(gestionProduits.rechercherProduit(""),
                "Une chaîne vide ne doit pas retourner de produit valide");
        assertFalse(gestionProduits.rechercherProduit("   "),
                "Une chaîne contenant seulement des espaces ne doit pas être valide");
        assertFalse(gestionProduits.rechercherProduit(null),
                "Une valeur null ne doit pas être valide");
    }
}
