package sn.sdley;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utilisateur {
    private String nom;
    private String prenom;

    // Constructeur
    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getter pour récupérer le nom
    public String getNom() {
        return nom;
    }

    // Getter pour récupérer le prénom
    public String getPrenom() {
        return prenom;
    }

    // Expression régulière pour valider les emails
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Méthode de validation d'email
    public static boolean estEmailValide(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // Liste statique d'utilisateurs
    private static final List<Utilisateur> utilisateurs = Arrays.asList(
            new Utilisateur("Diop", "Mamadou"),
            new Utilisateur("Ba", "Aissatou"),
            new Utilisateur("Ndoye", "Cheikh"),
            new Utilisateur("Sarr", "Fatou"),
            new Utilisateur("Faye", "Modou"),
            new Utilisateur("Gueye", "Awa"),
            new Utilisateur("Ndiaye", "Ousmane"),
            new Utilisateur("Sy", "Mariama"),
            new Utilisateur("Seck", "Babacar")
    );

    // Méthode qui retourne une liste de noms d'utilisateurs
    public static List<String> obtenirNomsUtilisateurs() {
        return utilisateurs.stream() // Convertit la liste en un flux
                .map(Utilisateur::getNom) // Extrait seulement les noms des objets Utilisateur
                .collect(Collectors.toList());
    }


    // 13. Méthode de concaténation de deux chaînes
    public static String concatener(String a, String b) {
        return a + b;
    }

    // Méthode principale de Test
    public static void main(String[] args) {
        // 12
        List<String> noms = obtenirNomsUtilisateurs();
        System.out.println("Liste des noms d'utilisateurs : " + noms);

        // 13
        System.out.println(concatener("Bonjour, ", "Mamadou !"));
        System.out.println(concatener("Aissatou", ""));
        System.out.println(concatener("", "Bienvenue !"));
    }

}
