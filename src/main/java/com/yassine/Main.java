
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

        // 2. Créer le catalogue
        Catalogue<Document> catalogue = new Catalogue<>();

        for (Document doc : docs) {
            catalogue.ajouter(doc);
        }

        // 3. Créer la configuration unique
        ConfigurationMediatheque config =
                new ConfigurationMediatheque(21, 5);

        // 4. Injecter la configuration dans EmpruntManager
        EmpruntManager manager =
                new EmpruntManager(catalogue, config);

        System.out.println("Durée d'emprunt : "
                + manager.getConfig().getDureeEmprunt());

        System.out.println("Nombre maximum d'emprunts : "
                + manager.getConfig().getNombreMaxEmprunts());

        // 5. Créer les dépendances du rapport
        FormatRapport format = new FormatCSV();
        SortieRapport sortie = new SortieFichier();

        ServeurSmtp serveur = new ServeurSmtp("smtp.itbs.tn");
        Notificateur notificateur = new NotificateurSMTP(serveur);

        // 6. Injecter les dépendances
        RapportService service = new RapportService(
                format,
                sortie,
                notificateur
        );

        // 7. Générer le rapport
        System.out.println("Génération du rapport...");
        service.genererRapport(docs);
        System.out.println("Rapport généré avec succès !");
    }
}
