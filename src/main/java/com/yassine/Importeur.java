package com.yassine;

import java.util.ArrayList;
import java.util.List;

public abstract class Importeur {

    // Méthode commune à tous les importeurs
    public final List<Document> importer(List<String> lignes) {

        List<Document> documents = new ArrayList<>();

        for (String ligne : lignes) {

            if (!ligne.isBlank()) {
                documents.add(creerDocument(ligne));
            }
        }

        return documents;
    }

    // Factory Method : la sous-classe décide quel document créer
    protected abstract Document creerDocument(String ligne);
}
