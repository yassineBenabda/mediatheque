package com.yassine;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Création des documents
        List<Document> docs = List.of(
                new Livre("Clean Code", "Robert C. Martin"),
                new Livre("Effective Java", "Joshua Bloch"),
                new Livre("Design Patterns", "Erich Gamma")
        );

        // Création du service
        RapportService service = new RapportService();

        // Test CSV
        System.out.println("=== Génération CSV ===");
        service.genererRapport(docs, new FormatCSV());

        // Test TXT
        System.out.println("\n=== Génération TXT ===");
        service.genererRapport(docs, new FormatTXT());

        System.out.println("\nTous les rapports ont été générés !");
    }
}
