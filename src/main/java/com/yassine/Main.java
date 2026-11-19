package com.yassine;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Créer les documents
        List<Document> docs = List.of(
                new Livre("Clean Code", "Robert C. Martin"),
                new Livre("Effective Java", "Joshua Bloch"),
                new Livre("Design Patterns", "Erich Gamma")
        );

        // 2. Créer les dépendances
        FormatRapport format = new FormatCSV();

        SortieRapport sortie = new SortieFichier();

        ServeurSmtp serveur = new ServeurSmtp("smtp.itbs.tn");
        Notificateur notificateur = new NotificateurSMTP(serveur);

        // 3. Injecter les dépendances
        RapportService service = new RapportService(
                format,
                sortie,
                notificateur
        );

        // 4. Générer le rapport
        System.out.println("Génération du rapport...");

        service.genererRapport(docs);

        System.out.println("Rapport généré avec succès !");
    }
}
