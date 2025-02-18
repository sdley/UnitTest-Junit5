package sn.sdley;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationTest {

    @Test
    @DisplayName("Test de l'unicité de l'instance de Configuration")
    public void testSingletonInstance() {
        // Deux appels à getInstance()
        Configuration instance1 = Configuration.getInstance();
        Configuration instance2 = Configuration.getInstance();

        // Vérification que les deux instances sont bien identiques
        assertSame(instance1, instance2, "Les deux instances doivent être identiques.");
    }
}
