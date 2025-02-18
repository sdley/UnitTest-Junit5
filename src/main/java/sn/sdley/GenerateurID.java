package sn.sdley;

import java.security.SecureRandom;

public class GenerateurID {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    /**
     * Génère un identifiant aléatoire de 10 caractères.
     * @return un identifiant unique de 10 caractères.
     */
    public static String generer() {
        StringBuilder id = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            id.append(CARACTERES.charAt(random.nextInt(CARACTERES.length())));
        }
        return id.toString();
    }

    public static void main(String[] args) {
        // Générer un identifiant unique
        String id = GenerateurID.generer();
        System.out.println("Identifiant généré : " + id);
    }
}
