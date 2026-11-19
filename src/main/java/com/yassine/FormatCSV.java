package com.yassine;

import java.util.List;

public class FormatCSV implements FormatRapport {

    @Override
    public String generer(List<Document> docs) {
        StringBuilder contenu = new StringBuilder();

        for (Document d : docs) {
            contenu.append(d.getTitre())
                    .append("\n");
        }

        return contenu.toString();
    }
}
