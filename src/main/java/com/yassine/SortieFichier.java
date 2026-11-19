package com.yassine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SortieFichier implements SortieRapport {

    @Override
    public void ecrire(String contenu) {

        try {
            // Définir le chemin du rapport
            Path dossier = Path.of("C:\\rapports");

            // Créer le dossier s'il n'existe pas
            Files.createDirectories(dossier);

            // Définir le fichier
            Path fichier = dossier.resolve("rapport.txt");

            // Écrire le contenu
            Files.writeString(fichier, contenu);

            System.out.println("Rapport enregistré dans : " + fichier);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Erreur lors de l'écriture du rapport", e
            );
        }
    }
}

