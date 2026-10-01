package com.yassine;

public abstract class Document implements Comparable<Document> {

    private String titre;

    public Document(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public abstract String descriptionCourte();

    @Override
    public int compareTo(Document autre) {
        return this.titre.compareToIgnoreCase(autre.titre);
    }
}