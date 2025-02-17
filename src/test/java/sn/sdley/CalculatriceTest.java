package sn.sdley;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        IllegalArgumentException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatrice.addition(-1, 2);
        });
        assert e.getMessage().equals("Les nombres doivent être positifs");
    }

    @Test
    public void additionValeurNegativeParAssertThrows2(){
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatrice.addition(-1, 2);
        }, "Les nombres doivent être positifs");
    }



}
