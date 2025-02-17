package sn.sdley;

public class Calculatrice {
    public int addition(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Les nombres doivent être positifs");
        }

        // Vérification de l'overflow (dépassement de capacité)
        /*
        En réalité, la condition if (a > Integer.MAX_VALUE - b) fonctionne bien parce que, en l’occurrence,
        nous voulons éviter un dépassement lorsque a + b dépasse Integer.MAX_VALUE.

        Pourquoi a > Integer.MAX_VALUE - b suffit si b >0 ?
        En Java, Integer.MAX_VALUE est la plus grande valeur possible pour un int (2³¹ - 1).
        Si a est trop grand, alors a + b peut dépasser cette limite.
        La condition a > Integer.MAX_VALUE - b garantit que a + b reste dans les limites permises.
        Cependant, cette condition fonctionne uniquement si b est positif. Pour plus de clarté et de sécurité,
        il serait préférable de tester symétriquement b aussi.

         */
        if (a > Integer.MAX_VALUE - b || b > Integer.MAX_VALUE - a) {
            throw new ArithmeticException("Dépassement de capacité : la somme dépasse Integer.MAX_VALUE");
        }

        return a + b;
    }


}
