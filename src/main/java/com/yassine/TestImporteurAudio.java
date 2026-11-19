
package com.yassine;

import java.util.List;

public class TestImporteurAudio {

    public static void main(String[] args) {

        List<String> lignes = List.of(
                "livreaudio;Le Petit Prince;Antoine de Saint-Exupéry",
                "livreaudio;Clean Code Audio;Robert Martin"
        );

        Importeur importeur =
                new ImporteurLignesLivresAudio();

        List<Document> documents =
                importeur.importer(lignes);

        for (Document doc : documents) {
            System.out.println(doc.descriptionCourte());
        }
    }
}
