package sn.sdley;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TriUtilTest {

    @Test
    @DisplayName("Test de tri d'une liste de noms")
    public void testTriListeCorrect() {
        List<String> noms = Arrays.asList("Zara", "Alpha", "Moussa", "Binta");
        List<String> expected = Arrays.asList("Alpha", "Binta", "Moussa", "Zara");

        TriUtil.trierListe(noms);
        assertEquals(expected, noms, "La liste doit être triée en ordre alphabétique.");
    }

    @Test
    @DisplayName("Test de tri d'une liste vide")
    public void testTriListeVide() {
        List<String> noms = Collections.emptyList(); // Liste vide
        List<String> expected = Collections.emptyList();

        TriUtil.trierListe(noms);
        assertEquals(expected, noms, "Une liste vide doit rester vide.");
    }

    @Test
    @DisplayName("Test de tri d'une liste avec un seul élément")
    public void testTriListeUnSeulElement() {
        List<String> noms = Arrays.asList("Unique");
        List<String> expected = Arrays.asList("Unique");

        TriUtil.trierListe(noms);
        assertEquals(expected, noms, "Une liste avec un seul élément doit rester inchangée.");
    }
}
