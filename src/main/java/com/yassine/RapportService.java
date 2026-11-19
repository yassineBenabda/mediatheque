
package com.yassine;

import java.util.List;

public class RapportService {

    public void genererRapport(
            List<Document> docs,
            FormatRapport formatRapport) {

        // 1. Générer le contenu avec le format reçu
        String contenu = formatRapport.generer(docs);

        // 2. Écrire le rapport
        SortieRapport sortie = new SortieFichier();
        sortie.ecrire(contenu);

        // 3. Envoyer la notification
        Notificateur notificateur = new NotificateurSMTP();
        notificateur.notifier("Rapport genere");
    }
}
