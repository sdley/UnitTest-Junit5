package sn.sdley;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatriceTest {
    Calculatrice calculatrice;

    @BeforeEach
    public void instance(){
        calculatrice = new Calculatrice();
    }

    @AfterEach
    public void destroy(){
        calculatrice = null;
    }

    @Test
    public void testAddition(){
        assert calculatrice.addition(2, 3) == 5;
    }

    @Test
    public void additionValeurNegativeParTry(){
        try {
            calculatrice.addition(-1, 2);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Les nombres doivent être positifs");
        }
    }

    @Test
    public void additionValeurNegativeParAssertThrows(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            calculatrice.addition(-1, 2);
        });
        assert e.getMessage().equals("Les nombres doivent être positifs");
    }

    @Test
    public void additionValeurNegativeParAssertThrows2(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculatrice.addition(-1, 2);
        }, "Les nombres doivent être positifs");
    }

    @Test
    public void testAdditionOverflow() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            calculatrice.addition(Integer.MAX_VALUE, 1);
        });
        assertEquals("Dépassement de capacité : la somme dépasse Integer.MAX_VALUE",
                e.getMessage());
    }

    @Test
    public void testAdditionNoOverflow() {
        assertEquals(10, calculatrice.addition(5, 5));
    }

    // Utilisons assertTrue() pour vérifier que le résultat est inférieur à une certaine
    //limite

    @Test
    public void testAdditionSansDepassement() {
        int limite = Integer.MAX_VALUE;

        try {
            int result = calculatrice.addition(5, 5);
            assertTrue(result < limite,
                    "Le résultat doit être inférieur à Integer.MAX_VALUE");
        } catch (ArithmeticException e) {
            fail("L'addition ne doit pas dépasser Integer.MAX_VALUE");
        }

    }

}
