
package com.yassine;

public class ImporteurCsv extends Importeur {

    @Override
    protected Document creerDocument(String ligne) {

        String[] c = ligne.split(";");

        switch (c[0].trim().toLowerCase()) {

            case "livre":
                if (c.length != 3) {
                    throw new IllegalArgumentException(
                            "Format livre invalide : " + ligne);
                }
                return new Livre(c[1], c[2]);

            case "dvd":
                if (c.length != 3) {
                    throw new IllegalArgumentException(
                            "Format DVD invalide : " + ligne);
                }
                return new Dvd(c[1], c[2]);

            case "revue":
                if (c.length != 3) {
                    throw new IllegalArgumentException(
                            "Format revue invalide : " + ligne);
                }
                return new Revue(c[1], Integer.parseInt(c[2]));

            default:
                throw new IllegalArgumentException(
                        "Type de document inconnu : " + c[0]);
        }
    }
}
