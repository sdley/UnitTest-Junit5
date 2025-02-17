package sn.sdley;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
        System.out.println("Nettoyage effectué après le test.");
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

        int result = calculatrice.addition(1234567890, 112323377);
        assertTrue(result < limite,
                "Le résultat doit être inférieur à Integer.MAX_VALUE");

    }

    // exo 5
    @Test
    public void testSoustraction(){
        assert calculatrice.soustraction(5, 3) == 2;
    }

    @Test
    public void testMultiplication(){
        assert calculatrice.multiplication(5, 3) == 15;
    }

    @Test
    public void testDivision(){
        assert calculatrice.division(6, 3) == 2;
    }

    @Test
    public void divisionParZero(){
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            calculatrice.division(6, 0);
        });
        assertEquals("Division par zéro", e.getMessage());
    }

    /*
    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 2, 4",
            "5, 5, 10",
            "10, 15, 25",
            "0, 0, 0",
            "100, 200, 300"
    })
    public void testAdditionParametree(int a, int b, int expected) {
        assertEquals(expected, calculatrice.addition(a, b),
                "L'addition de " + a + " et " + b + " devrait être " + expected);
    }

     */
//    static Stream<Object[]> additionData() {
//        return Stream.of(
//                new Object[]{1, 1, 2},
//                new Object[]{2, 2, 4},
//                new Object[]{5, 5, 10},
//                new Object[]{10, 15, 25},
//                new Object[]{0, 0, 0},
//                new Object[]{100, 200, 300}
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("additionData")
//    public void testAdditionParametree(int a, int b, int expected) {
//        assertEquals(expected, calculatrice.addition(a, b));
//    }


}
