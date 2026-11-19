import com.yassine.FormatRapport;
import com.yassine.Notificateur;
import com.yassine.RapportService;
import com.yassine.SortieRapport;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class RapportServiceTest {

    @Test
    void testGenererRapportAvecFaussesDependances() {

        // Faux format
        FormatRapport fauxFormat = docs -> "Mon faux rapport";

        // Faux système de sortie
        AtomicReference<String> contenuRecu =
                new AtomicReference<>();

        SortieRapport fausseSortie =
                contenuRecu::set;

        // Faux notificateur
        AtomicReference<String> messageRecu =
                new AtomicReference<>();

        Notificateur fauxNotificateur =
                messageRecu::set;

        // Créer le service avec les fausses dépendances
        RapportService service = new RapportService(
                fauxFormat,
                fausseSortie,
                fauxNotificateur
        );

        // Exécuter le service
        service.genererRapport(List.of());

        // Vérifier les résultats
        assertEquals("Mon faux rapport", contenuRecu.get());

        assertEquals(
                "Rapport genere",
                messageRecu.get()
        );

        System.out.println("Test DIP réussi !");
    }
}

