package sn.sdley;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilisateurTest {

    @Test
    @DisplayName("Test avec des emails valides")
    public void testEmailsValides() {
        assertAll(
                () -> assertTrue(Utilisateur.estEmailValide("exemple@test.com"),
                        "exemple@test.com doit être valide"),
                () -> assertTrue(Utilisateur.estEmailValide("user.name+test@domain.org"),
                        "user.name+test@domain.org doit être valide"),
                () -> assertTrue(Utilisateur.estEmailValide("contact123@sub.example.net"),
                        "contact123@sub.example.net doit être valide"),
                () -> assertTrue(Utilisateur.estEmailValide("user@domain.uam.sn"),
                        "user@domain.uam.sn doit être valide")
        );
    }

    @Test
    @DisplayName("Test avec des emails invalides")
    public void testEmailsInvalides() {
        assertAll(
                () -> assertFalse(Utilisateur.estEmailValide("invalid-email"),
                        "invalid-email ne doit pas être valide"),
                () -> assertFalse(Utilisateur.estEmailValide("test@com"),
                        "test@com ne doit pas être valide"),
                () -> assertFalse(Utilisateur.estEmailValide("@domain.com"),
                        "@domain.com ne doit pas être valide"),
                () -> assertFalse(Utilisateur.estEmailValide("user@.com"),
                        "user@.com ne doit pas être valide"),
                () -> assertFalse(Utilisateur.estEmailValide("user@domain"),
                        "user@domain ne doit pas être valide"),
                () -> assertFalse(Utilisateur.estEmailValide("user@domain..com"),
                        "user@domain..com ne doit pas être valide"),
                () -> assertFalse(Utilisateur.estEmailValide("user@.domain.com"),
                        "user@.domain.com ne doit pas être valide")
        );
    }

    @Test
    @DisplayName("Test avec des entrées null ou vides")
    public void testEmailsNulsEtVides() {
        assertAll(
                () -> assertFalse(Utilisateur.estEmailValide(null),
                        "null ne doit pas être valide"),
                () -> assertFalse(Utilisateur.estEmailValide(""),
                        "Une chaîne vide ne doit pas être valide"),
                () -> assertFalse(Utilisateur.estEmailValide("   "),
                        "Un email avec seulement des espaces ne doit pas être valide")
        );
    }

    // exo 12
    @Test
    @DisplayName("Test de la liste des utilisateurs avec noms sénégalais")
    public void testObtenirNomsUtilisateurs() {
        // Récupération de la liste des noms d'utilisateurs
        List<String> nomsUtilisateurs = Utilisateur.obtenirNomsUtilisateurs();

        // Vérifications avec assertAll()
        assertAll(
                () -> assertNotNull(nomsUtilisateurs, "La liste ne doit pas être null"),
                () -> assertFalse(nomsUtilisateurs.isEmpty(), "La liste ne doit pas être vide"),
                () -> assertTrue(nomsUtilisateurs.contains("Diop"), "La liste doit contenir 'Diop'"),
                () -> assertTrue(nomsUtilisateurs.contains("Ndiaye"), "La liste doit contenir 'Ndiaye'"),
                () -> assertTrue(nomsUtilisateurs.contains("Ba"), "La liste doit contenir 'Ba'")
        );
    }

    // 13.
    @Test
    @DisplayName("Test de la méthode concatener()")
    public void testConcatener() {
        assertAll(
                () -> assertEquals("Hello World", Utilisateur.concatener("Hello", " World"),
                        "La concaténation de 'Hello' et ' World' doit donner 'Hello World'"),

                () -> assertEquals("Bonjour", Utilisateur.concatener("", "Bonjour"),
                        "La concaténation d'une chaîne vide et 'Bonjour' doit donner 'Bonjour'"),

                () -> assertEquals("Bienvenue !", Utilisateur.concatener("Bienvenue !", ""),
                        "La concaténation de 'Bienvenue !' et une chaîne vide doit donner 'Bienvenue !'"),

                () -> assertEquals("", Utilisateur.concatener("", ""),
                        "La concaténation de deux chaînes vides doit donner une chaîne vide")
        );
    }

    // 14. Utilisateur actif
    @Test
    @DisplayName("Test qu'un utilisateur nouvellement créé est actif")
    public void testUtilisateurEstActif() {
        // Création d'un utilisateur
        Utilisateur utilisateur = new Utilisateur("Diop", "Mamadou");

        // Vérification que l'utilisateur est bien actif
        assertTrue(utilisateur.estActif(), "L'utilisateur doit être actif par défaut");
    }

    // 16.Vérification d’une exception sur une méthode de suppression
    @Test
    @DisplayName("Test suppression avec ID null")
    public void testSuppressionIdNull() {
        assertThrows(IllegalArgumentException.class, () ->
                        Utilisateur.supprimerUtilisateur(null),
                "Une IllegalArgumentException devrait être levée si l'ID est null"
        );
    }

    @Test
    @DisplayName("Test suppression avec ID vide")
    public void testSuppressionIdVide() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () ->
                                Utilisateur.supprimerUtilisateur(""),
                        "Une IllegalArgumentException devrait être levée si l'ID est vide"
                ),
                () -> assertThrows(IllegalArgumentException.class, () ->
                                Utilisateur.supprimerUtilisateur("   "),
                        "Une IllegalArgumentException devrait être levée si l'ID ne contient que des espaces"
                )
        );
    }

    @Test
    @DisplayName("Test suppression avec un ID valide")
    public void testSuppressionIdValide() {
        // Création d'un utilisateur
        Utilisateur utilisateur = new Utilisateur("123", "Seydou");

        // Vérifie que l'utilisateur est bien présent avant suppression
        assertDoesNotThrow(() -> Utilisateur.supprimerUtilisateur("123"),
                "La suppression d'un ID valide ne doit pas lever d'exception"
        );
    }
}
