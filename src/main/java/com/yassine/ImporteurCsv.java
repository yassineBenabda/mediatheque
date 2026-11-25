
package com.yassine;

public class ImporteurCsv extends Importeur {

    @Override
    protected Document creerDocument(String ligne) {

        String[] c = ligne.split(";", -1);

        switch (c[0].trim().toLowerCase()) {

            case "livre":
                if (c.length < 5 || c.length > 8) {
                    throw new IllegalArgumentException(
                            "Format livre invalide : " + ligne
                    );
                }

                Livre.Builder builder = new Livre.Builder(
                        c[1].trim(),
                        Integer.parseInt(c[2].trim())
                )
                        .auteur(c[3].trim())
                        .nbPages(Integer.parseInt(c[4].trim()));

                if (c.length > 5 && !c[5].isBlank()) {
                    builder.isbn(c[5].trim());
                }

                if (c.length > 6 && !c[6].isBlank()) {
                    builder.editeur(c[6].trim());
                }

                if (c.length > 7 && !c[7].isBlank()) {
                    builder.langue(c[7].trim());
                }

                return builder.build();

            case "dvd":
                if (c.length != 3) {
                    throw new IllegalArgumentException(
                            "Format DVD invalide : " + ligne
                    );
                }
                return new Dvd(c[1], c[2]);

            case "revue":
                if (c.length != 3) {
                    throw new IllegalArgumentException(
                            "Format revue invalide : " + ligne
                    );
                }
                return new Revue(c[1], Integer.parseInt(c[2]));

            default:
                throw new IllegalArgumentException(
                        "Type de document inconnu : " + c[0]
                );
        }
    }
}
