

import com.yassine.Catalogue;
import com.yassine.ConfigurationMediatheque;
import com.yassine.EmpruntManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigurationMediathequeTest {

    @Test
    void configurationsIndependantes() {

        ConfigurationMediatheque config1 =
                new ConfigurationMediatheque(7, 5);

        ConfigurationMediatheque config2 =
                new ConfigurationMediatheque(21, 3);

        EmpruntManager manager1 =
                new EmpruntManager(new Catalogue<>(), config1);

        EmpruntManager manager2 =
                new EmpruntManager(new Catalogue<>(), config2);

        assertEquals(7,
                manager1.getConfig().getDureeEmprunt());

        assertEquals(21,
                manager2.getConfig().getDureeEmprunt());

        assertEquals(5,
                manager1.getConfig().getNombreMaxEmprunts());

        assertEquals(3,
                manager2.getConfig().getNombreMaxEmprunts());
    }
}
