package sn.sdley;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListeUtilTest {

    @Test
    @DisplayName("Test de l'ajout d'un élément dans une liste avec assertAll()")
    public void testAjouterElement() {
        // Création d'une liste vide
        List<String> liste = new ArrayList<>();
        String element = "Element 1";

        // Ajout de l'élément à la liste
        ListeUtil.ajouterElement(liste, element);

        // Vérifications avec assertAll()
        assertAll(
                () -> assertEquals(1, liste.size(), "La taille de la liste doit être 1 après l'ajout."),
                () -> assertTrue(liste.contains(element), "La liste doit contenir l'élément ajouté."),
                () -> assertNotNull(liste, "La liste ne doit pas être null après l'ajout.")
        );
    }

    @Test
    @DisplayName("Test de l'ajout d'un élément avec une liste null")
    public void testAjouterElementListeNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            ListeUtil.ajouterElement(null, "Test");
        });

        assertEquals("La liste ne peut pas être null.", e.getMessage());
    }
}
