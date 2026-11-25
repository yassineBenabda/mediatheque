
package com.yassine;

public class Livre extends Document implements Empruntable {

    private final String auteur;
    private final int nbPages;
    private final String isbn;
    private final String editeur;
    private final String langue;

    // État d'emprunt conservé pour Empruntable
    private boolean emprunte;

    // Constructeur privé : création uniquement avec Builder
    private Livre(Builder b) {
        super(b.titre, b.annee);

        this.auteur = b.auteur;
        this.nbPages = b.nbPages;
        this.isbn = b.isbn;
        this.editeur = b.editeur;
        this.langue = b.langue;
        this.emprunte = false;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getLangue() {
        return langue;
    }

    @Override
    public String descriptionCourte() {
        return "Livre : " + getTitre() + " - " + auteur;
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (emprunte) {
            throw new DocumentIndisponibleException(
                    "Le livre '" + getTitre() + "' est déjà emprunté"
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

    // Builder
    public static class Builder {

        // Champs obligatoires
        private final String titre;
        private final int annee;

        // Champs optionnels
        private String auteur;
        private int nbPages;
        private String isbn;
        private String editeur;
        private String langue;

        public Builder(String titre, int annee) {
            this.titre = titre;
            this.annee = annee;
        }

        public Builder auteur(String auteur) {
            this.auteur = auteur;
            return this;
        }

        public Builder nbPages(int nbPages) {
            this.nbPages = nbPages;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder editeur(String editeur) {
            this.editeur = editeur;
            return this;
        }

        public Builder langue(String langue) {
            this.langue = langue;
            return this;
        }

        public Livre build() {

            if (titre == null || titre.isBlank()) {
                throw new IllegalStateException("Le titre est obligatoire");
            }

            if (annee < 1450) {
                throw new IllegalStateException(
                        "L'année doit être supérieure ou égale à 1450"
                );
            }

            if (nbPages <= 0) {
                throw new IllegalStateException(
                        "Le nombre de pages doit être supérieur à 0"
                );
            }

            return new Livre(this);
        }
    }
}
