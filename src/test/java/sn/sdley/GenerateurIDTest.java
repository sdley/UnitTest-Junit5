package sn.sdley;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenerateurIDTest {

    @Test
    @DisplayName("Vérifier que l'identifiant généré n'est jamais null")
    public void testIdentifiantNonNull() {
        String identifiant = GenerateurID.generer();
        assertNotNull(identifiant, "L'identifiant ne doit pas être null");
    }

    @Test
    @DisplayName("Vérifier que l'identifiant généré fait exactement 10 caractères")
    public void testIdentifiantLongueur() {
        String identifiant = GenerateurID.generer();
        assertEquals(10, identifiant.length(), "L'identifiant doit faire 10 caractères");
    }
}
