package sn.sdley;

import java.util.List;

public class ListeUtil {

    // Méthode qui ajoute un élément à une liste
    public static void ajouterElement(List<String> list, String element) {
        if (list == null) {
            throw new IllegalArgumentException("La liste ne peut pas être null.");
        }
        list.add(element);
    }
}
