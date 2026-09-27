package com.yassine;

public class Revue extends Document {

    private int numero;

    public Revue(String titre, int numero) {
        super(titre);
        this.numero = numero;
    }

    @Override
    public String descriptionCourte() {
        return "Revue : " + getTitre() + " - numéro " + numero;
    }
}
