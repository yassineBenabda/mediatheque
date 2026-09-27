package com.yassine;

public class Livre extends Document implements Empruntable {

    private String auteur;
    private boolean emprunte;

    public Livre(String titre, String auteur) {
        super(titre);
        this.auteur = auteur;
        this.emprunte = false;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public String descriptionCourte() {
        return "Livre : " + getTitre() + " - " + auteur;
    }

    @Override
    public void emprunter() {
        if (emprunte) {
            throw new IllegalStateException("Le livre est déjà emprunté");
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
