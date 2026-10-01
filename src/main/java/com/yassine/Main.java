package com.yassine;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Livre livre = new Livre(
                "Clean Code",
                "Robert C. Martin"
        );

        System.out.println(livre.descriptionCourte());

        // Test emprunt
        livre.emprunter();

        System.out.println("Emprunté : " + livre.estEmprunte());

        // Test double emprunt
        try {
            livre.emprunter();
        } catch (IllegalStateException e) {
            System.out.println("Erreur attendue : " + e.getMessage());
        }

        // Test Catalogue
        Catalogue<Livre> catalogue = new Catalogue<>();

        catalogue.ajouter(livre);
        catalogue.ajouter(
                new Livre("Effective Java", "Joshua Bloch")
        );

        System.out.println("\n=== Catalogue ===");
        catalogue.afficherTout();

        // Test recherche
        System.out.println("\n=== Recherche ===");

        catalogue.rechercherParTitre("Clean Code")
                .ifPresent(
                        l -> System.out.println(l.descriptionCourte())
                );

        // Test recherche inexistante
        System.out.println("\n=== Recherche inexistante ===");

        catalogue.rechercherParTitre("Java Patterns")
                .ifPresentOrElse(
                        l -> System.out.println(l.descriptionCourte()),
                        () -> System.out.println("Livre introuvable")
                );

        // Test max()
        List<Document> documents = new ArrayList<>();

        documents.add(new Livre("Clean Code", "Robert C. Martin"));
        documents.add(new Livre("Effective Java", "Joshua Bloch"));
        documents.add(new Revue("Java Magazine", 10));

        Document max = Utils.max(documents);

        System.out.println("\n=== Max ===");
        System.out.println(max.descriptionCourte());
    }
}