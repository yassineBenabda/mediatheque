package com.yassine;

public abstract class Document implements Comparable<Document> {

    private final String titre;
    private final int annee;

    // Constructeur conservé pour Dvd et Revue
    public Document(String titre) {
        this(titre, 0);
    }

    // Nouveau constructeur avec année
    public Document(String titre, int annee) {
        this.titre = titre;
        this.annee = annee;
    }

    public String getTitre() {
        return titre;
    }

    public int getAnnee() {
        return annee;
    }

    public abstract String descriptionCourte();

    @Override
    public int compareTo(Document autre) {
        return this.titre.compareToIgnoreCase(autre.titre);
    }
}