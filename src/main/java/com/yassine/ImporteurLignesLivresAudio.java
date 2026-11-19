
package com.yassine;

public class ImporteurLignesLivresAudio extends Importeur {

    @Override
    protected Document creerDocument(String ligne) {

        String[] c = ligne.split(";");

        if (c.length != 3) {
            throw new IllegalArgumentException(
                    "Format de livre audio invalide : " + ligne);
        }

        if (!c[0].trim().equalsIgnoreCase("livreaudio")) {
            throw new IllegalArgumentException(
                    "Type attendu : livreaudio");
        }

        return new LivreAudio(c[1], c[2]);
    }
}
