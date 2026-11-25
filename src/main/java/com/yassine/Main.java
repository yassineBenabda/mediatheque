
package com.yassine;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Créer les livres avec Builder
        List<Document> docs = List.of(

                new Livre.Builder("Clean Code", 2008)
                        .auteur("Robert C. Martin")
                        .nbPages(464)
                        .isbn("978-0132350884")
                        .editeur("Prentice Hall")
                        .langue("en")
                        .build(),

                new Livre.Builder("Effective Java", 2018)
                        .auteur("Joshua Bloch")
                        .nbPages(416)
                        .langue("en")
                        .build(),

                new Livre.Builder("Design Patterns", 1994)
                        .auteur("Erich Gamma")
                        .nbPages(395)
                        .langue("en")
                        .build()
        );

        // 2. Créer le catalogue
        Catalogue<Document> catalogue = new Catalogue<>();

        for (Document doc : docs) {
            catalogue.ajouter(doc);
        }

        // 3. Créer la configuration
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
