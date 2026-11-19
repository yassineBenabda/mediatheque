package com.yassine;

import java.util.List;

public class RapportService {

    public void genererRapport(List<Document> docs, String format) {

        // 1. Générer le contenu
        FormatRapport generateur;

        if (format.equals("CSV")) {
            generateur = new FormatCSV();
        } else if (format.equals("TXT")) {
            generateur = new FormatTXT();
        } else {
            throw new IllegalArgumentException("Format inconnu");
        }

        String contenu = generateur.generer(docs);

        // 2. Écrire le rapport
        SortieRapport sortie = new SortieFichier();
        sortie.ecrire(contenu);

        // 3. Envoyer la notification
        Notificateur notificateur = new NotificateurSMTP();
        notificateur.notifier("Rapport genere");
    }
}

