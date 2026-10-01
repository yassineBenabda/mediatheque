package com.yassine;

public class Main {
    public static void main(String[] args) {

        Catalogue<Livre> catalogue = new Catalogue<>();

        Livre livre1 = new Livre(
                "Clean Code",
                "Robert C. Martin"
        );

        Livre livre2 = new Livre(
                "Effective Java",
                "Joshua Bloch"
        );

        catalogue.ajouter(livre1);
        catalogue.ajouter(livre2);

        System.out.println("=== Tous les livres ===");
        catalogue.afficherTout();

        System.out.println("\n=== Recherche ===");

        catalogue.rechercherParTitre("Clean Code")
                .ifPresent(livre ->
                        System.out.println(livre.descriptionCourte())
                );

        System.out.println("\n=== Recherche inexistante ===");

        catalogue.rechercherParTitre("Java Design Patterns")
                .ifPresentOrElse(
                        livre -> System.out.println(livre.descriptionCourte()),
                        () -> System.out.println("Livre introuvable")
                );
    }
}