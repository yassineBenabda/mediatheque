import com.yassine.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpruntManagerTest {

    private Catalogue<Document> catalogue;
    private EmpruntManager manager;
    private Livre livre;

    @BeforeEach
    void setUp() {
        catalogue = new Catalogue<>();

        livre = new Livre("Clean Code", "Robert C. Martin");

        catalogue.ajouter(livre);
        catalogue.ajouter(
                new Dvd("Inception", "Christopher Nolan")
        );
        catalogue.ajouter(
                new Revue("Java Magazine", 10)
        );

        manager = new EmpruntManager(catalogue);
    }

    // Test 1 : emprunt normal
    @Test
    void testEmpruntNormal() throws DocumentIndisponibleException,
            DocumentIntrouvableException {

        manager.emprunter("Clean Code");

        assertTrue(livre.estEmprunte());
    }

    // Test 2 : exception lors d'un double emprunt
    @Test
    void testDoubleEmprunt() throws DocumentIndisponibleException,
            DocumentIntrouvableException {

        manager.emprunter("Clean Code");

        assertThrows(
                DocumentIndisponibleException.class,
                () -> manager.emprunter("Clean Code")
        );
    }

    // Test 3 : le message contient le titre du document
    @Test
    void testMessageContientTitre() throws DocumentIndisponibleException,
            DocumentIntrouvableException {

        manager.emprunter("Clean Code");

        DocumentIndisponibleException exception = assertThrows(
                DocumentIndisponibleException.class,
                () -> manager.emprunter("Clean Code")
        );

        assertTrue(exception.getMessage().contains("Clean Code"));
    }

    // Test 4 : document introuvable
    @Test
    void testDocumentIntrouvable() {

        DocumentIntrouvableException exception = assertThrows(
                DocumentIntrouvableException.class,
                () -> manager.emprunter("Java Patterns")
        );

        assertTrue(
                exception.getMessage().contains("Java Patterns")
        );
    }

    // Test 5 : conservation de la cause initiale
    @Test
    void testChaineCause() {

        Exception causeInitiale =
                new IllegalStateException("Erreur initiale");

        DocumentIndisponibleException exception =
                new DocumentIndisponibleException(
                        "Impossible d'emprunter Clean Code",
                        causeInitiale
                );

        assertSame(causeInitiale, exception.getCause());
    }
}
