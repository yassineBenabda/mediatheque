package com.yassine;

public abstract class Document {
    private String titre;

    public Document(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public abstract String descriptionCourte();
}
