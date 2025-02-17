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


}
