package  com.yassine;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Création des documents
        List<Document> docs = List.of(
                new Livre("Clean Code", "Robert C. Martin"),
                new Livre("Java pour débutants", "Auteur inconnu")
        );

        // Création du service
        RapportService service = new RapportService();

        // Génération du rapport CSV
        System.out.println("Génération du rapport CSV...");
        service.genererRapport(docs, "CSV");

        System.out.println("Rapport généré avec succès !");
    }
}
