package com.yassine;

import com.yassine.Document;
import com.yassine.FormatRapport;

import java.util.List;

public class FormatTXT implements FormatRapport {

    @Override
    public String generer(List<Document> docs) {
        StringBuilder contenu = new StringBuilder();

        for (Document d : docs) {
            contenu.append(" - ")
                    .append(d.descriptionCourte())
                    .append("\n");
        }

        return contenu.toString();
    }
}
