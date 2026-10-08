package com.yassine;

public class Dvd extends Document implements Empruntable {

    private String realisateur;
    private boolean emprunte;

    public Dvd(String titre, String realisateur) {
        super(titre);
        this.realisateur = realisateur;
        this.emprunte = false;
    }

    @Override
    public String descriptionCourte() {
        return "DVD : " + getTitre() + " - " + realisateur;
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (emprunte) {
            throw new DocumentIndisponibleException(
                    "Le DVD '" + getTitre() + "' est déjà emprunté"
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
