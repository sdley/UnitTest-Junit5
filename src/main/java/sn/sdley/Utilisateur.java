package sn.sdley;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utilisateur {
    private String nom;
    private String prenom;
    private boolean actif;

    // Simulons une base d'utilisateurs avec une HashMap
    private static final Map<String, Utilisateur> baseUtilisateurs = new HashMap<>();

    // Constructeur
    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.actif = true; // Par défaut, l'utilisateur est actif
    }
    // Constructeur
    public Utilisateur(String id, String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.actif = true; // Par défaut, l'utilisateur est actif
        baseUtilisateurs.put(id, this); // Ajout dans la base simulée
    }

    // Getter pour récupérer le nom
    public String getNom() {
        return nom;
    }

    // Getter pour récupérer le prénom
    public String getPrenom() {
        return prenom;
    }

    // Getter pour récupérer l'état de l'utilisateur
    public boolean estActif() {
        return actif;
    }

    // Setter pour définir l'état de l'utilisateur
    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isActif() {
        return actif;
    }

    // Expression régulière pour valider les emails
    /**
     * accepte les emails de type user@.domain.com
     * accepte les emails de type user@domain..com
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
     */
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,6}$";
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

    // 16.Vérification d’une exception sur une méthode de suppression
    // Méthode pour supprimer un utilisateur
    public static void supprimerUtilisateur(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("L'ID ne peut pas être null ou vide");
        }
        baseUtilisateurs.remove(id); // Suppression de la base
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
