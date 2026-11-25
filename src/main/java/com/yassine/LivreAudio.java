
package com.yassine;

public class LivreAudio extends Document implements Empruntable {

    private final String auteur;
    private boolean emprunte;

    public LivreAudio(String titre, String auteur) {
        super(titre);
        this.auteur = auteur;
        this.emprunte = false;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public String descriptionCourte() {
        return "Livre audio : " + getTitre() + " - " + auteur;
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (emprunte) {
            throw new DocumentIndisponibleException(
                    "Le livre audio '" + getTitre() + "' est déjà emprunté"
            );
        }
        emprunte = true;
    }

    @Override
    public void retourner() {
        emprunte = false;
    }

    @Override
    public boolean estEmprunte() {
        return emprunte;
    }
}
