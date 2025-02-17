package sn.sdley;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonneTest {

    @Test
    @DisplayName("Test de la méthode toString() de la classe Personne")
    public void testToString() {
        // Création d'une instance de Personne
        Personne personne = new Personne("Jean", 30);

        // Chaîne attendue
        String expected = "Nom: Jean, Age: 30";

        // Vérification avec assertEquals
        assertEquals(expected, personne.toString(),
                "La méthode toString() ne retourne pas la bonne valeur.");
    }
}
