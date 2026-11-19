
package com.yassine;

import java.util.List;

public class TestImporteur {

    public static void main(String[] args) {

        List<String> lignes = List.of(
                "livre;Clean Code;Robert Martin",
                "dvd;Inception;Christopher Nolan",
                "revue;Science Magazine;12"
        );

        Importeur importeur = new ImporteurCsv();

        List<Document> documents = importeur.importer(lignes);

        for (Document doc : documents) {
            System.out.println(doc.descriptionCourte());
        }
    }
}
