package com.yassine;

import java.util.List;

public class RapportService {

    private final FormatRapport formatRapport;
    private final SortieRapport sortie;
    private final Notificateur notificateur;

    // Injection des dépendances par constructeur
    public RapportService(
            FormatRapport formatRapport,
            SortieRapport sortie,
            Notificateur notificateur) {

        this.formatRapport = formatRapport;
        this.sortie = sortie;
        this.notificateur = notificateur;
    }

    public void genererRapport(List<Document> docs) {

        // 1. Générer le contenu
        String contenu = formatRapport.generer(docs);

        // 2. Écrire le rapport
        sortie.ecrire(contenu);

        // 3. Envoyer la notification
        notificateur.notifier("Rapport genere");
    }
}
