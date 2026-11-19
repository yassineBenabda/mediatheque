package com.yassine;

public class LivreAudio extends Livre {

    public LivreAudio(String titre, String auteur) {
        super(titre, auteur);
    }

    @Override
    public String descriptionCourte() {
        return "Livre audio : " + getTitre()
                + " - " + getAuteur();
    }
}
