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
                        "contact123@sub.example.net doit être valide")
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
                        "user@domain ne doit pas être valide")
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
}
