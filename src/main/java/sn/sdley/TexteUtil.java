package sn.sdley;

public class TexteUtil {
    /**
     * Transforme le texte en le mettant en majuscules et en supprimant les espaces en début et en fin.
     * @param texte le texte à transformer
     * @return le texte transformé
     */
    public static String transformerTexte(String texte) {
        if (texte == null) {
            return null; // Gérer le cas où le texte est null
        }
        return texte.trim().toUpperCase();
    }
}
