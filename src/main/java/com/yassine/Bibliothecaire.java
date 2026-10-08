package com.yassine;

public class Bibliothecaire {

    private final String nom;
    private final Catalogue<Document> catalogue;

    public Bibliothecaire(String nom, Catalogue<Document> catalogue) {
        this.nom = nom;
        this.catalogue = catalogue;
    }

    public void accueillir() {
        System.out.println("Bonjour, je suis " + nom);
    }

    public void ajouterDocument(Document document) {
        catalogue.ajouter(document);
    }

    public void rechercherDocument(String titre) {
        catalogue.rechercherParTitre(titre)
                .ifPresentOrElse(
                        document -> System.out.println(document.descriptionCourte()),
                        () -> System.out.println("Document introuvable")
                );
    }
}
