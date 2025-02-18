package sn.sdley;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TexteUtilTest {

    @Test
    @DisplayName("Test avec un texte standard")
    public void testTexteStandard() {
        assertEquals("HELLO WORLD", TexteUtil.transformerTexte("Hello World"));
    }

    @Test
    @DisplayName("Test avec des espaces en début et fin")
    public void testEspacesDebutFin() {
        assertEquals("JAVA", TexteUtil.transformerTexte("   java   "));
    }

    @Test
    @DisplayName("Test avec un texte en minuscules")
    public void testTexteEnMinuscules() {
        assertEquals("TEST", TexteUtil.transformerTexte("test"));
    }

    @Test
    @DisplayName("Test avec un texte déjà en majuscules")
    public void testTexteMajuscules() {
        assertEquals("PROGRAMMATION", TexteUtil.transformerTexte("PROGRAMMATION"));
    }

    @Test
    @DisplayName("Test avec un texte vide")
    public void testTexteVide() {
        assertEquals("", TexteUtil.transformerTexte(""));
    }

    @Test
    @DisplayName("Test avec un texte null")
    public void testTexteNull() {
        assertNull(TexteUtil.transformerTexte(null));
    }
}
