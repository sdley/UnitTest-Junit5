package sn.sdley;

import java.util.Collections;
import java.util.List;

public class TriUtil {
    /**
     * Trie une liste de noms par ordre alphabétique.
     * @param noms Liste de noms à trier.
     */
    public static void trierListe(List<String> noms) {
        if (noms != null) {
            Collections.sort(noms); // Trie la liste en ordre alphabétique
        }
    }
}
