import com.yassine.Catalogue;
import com.yassine.Livre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogueTest {

    @Test
    void testEmpruntNormal() {

        Livre livre = new Livre(
                "Clean Code",
                "Robert C. Martin"
        );

        livre.emprunter();

        assertTrue(livre.estEmprunte());
    }

    @Test
    void testDoubleEmprunt() {

        Livre livre = new Livre(
                "Clean Code",
                "Robert C. Martin"
        );

        livre.emprunter();

        assertThrows(
                IllegalStateException.class,
                () -> livre.emprunter()
        );
    }

    @Test
    void testRechercheInfructueuse() {

        Catalogue<Livre> catalogue = new Catalogue<>();

        Livre livre = new Livre(
                "Clean Code",
                "Robert C. Martin"
        );

        catalogue.ajouter(livre);

        var resultat =
                catalogue.rechercherParTitre("Java Design Patterns");

        assertTrue(resultat.isEmpty());
    }
}