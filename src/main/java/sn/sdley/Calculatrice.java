package sn.sdley;

public class Calculatrice {
    public int addition(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Les nombres doivent être positifs");
        }
        return a + b;
    }


}
