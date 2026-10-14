
package com.yassine;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ========================================
        // 1. Test Livre et emprunt
        // ========================================
        System.out.println("=== Test Livre ===");

        Livre livre = new Livre(
                "Clean Code",
                "Robert C. Martin"
        );

        System.out.println(livre.descriptionCourte());

        try {
            livre.emprunter();
            System.out.println("Emprunté : " + livre.estEmprunte());
        } catch (DocumentIndisponibleException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Test double emprunt
        try {
            livre.emprunter();
        } catch (DocumentIndisponibleException e) {
            System.out.println("Erreur attendue : " + e.getMessage());
        }

        // ========================================
        // 2. Test Catalogue
        // ========================================
        System.out.println("\n=== Catalogue ===");

        Catalogue<Livre> catalogue = new Catalogue<>();

        catalogue.ajouter(livre);
        catalogue.ajouter(
                new Livre("Effective Java", "Joshua Bloch")
        );

        catalogue.afficherTout();

        // ========================================
        // 3. Test recherche
        // ========================================
        System.out.println("\n=== Recherche ===");

        catalogue.rechercherParTitre("Clean Code")
                .ifPresent(
                        l -> System.out.println(l.descriptionCourte())
                );

        // Recherche inexistante
        System.out.println("\n=== Recherche inexistante ===");

        catalogue.rechercherParTitre("Java Patterns")
                .ifPresentOrElse(
                        l -> System.out.println(l.descriptionCourte()),
                        () -> System.out.println("Livre introuvable")
                );

        // ========================================
        // 4. Test Utils.max()
        // ========================================
        System.out.println("\n=== Max ===");

        List<Document> documents = new ArrayList<>();

        documents.add(new Livre("Clean Code", "Robert C. Martin"));
        documents.add(new Livre("Effective Java", "Joshua Bloch"));
        documents.add(new Revue("Java Magazine", 10));

        Document max = Utils.max(documents);

        System.out.println(max.descriptionCourte());

        // ========================================
        // 5. Test Bibliothecaire
        // ========================================
        System.out.println("\n=== Bibliothécaire ===");

        Catalogue<Document> catalogueDocuments = new Catalogue<>();

        Bibliothecaire bibliothecaire =
                new Bibliothecaire("Yassine", catalogueDocuments);

        bibliothecaire.accueillir();

        bibliothecaire.ajouterDocument(
                new Livre("Design Patterns", "Erich Gamma")
        );

        bibliothecaire.rechercherDocument("Design Patterns");

        // ========================================
        // 6. Test EmpruntManager
        // ========================================
        System.out.println("\n=== EmpruntManager ===");

        Catalogue<Document> catalogueEmprunts = new Catalogue<>();

        catalogueEmprunts.ajouter(
                new Livre("Le Petit Prince", "Antoine de Saint-Exupéry")
        );

        catalogueEmprunts.ajouter(
                new Dvd("Inception", "Christopher Nolan")
        );

        catalogueEmprunts.ajouter(
                new Revue("Science Magazine", 10)
        );

        EmpruntManager manager =
                new EmpruntManager(catalogueEmprunts);

        // Test 1 : emprunt normal
        try {
            manager.emprunter("Le Petit Prince");
            System.out.println("Emprunt réussi : Le Petit Prince");
        } catch (MediathequeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Test 2 : double emprunt
        try {
            manager.emprunter("Le Petit Prince");
        } catch (MediathequeException e) {
            System.out.println("Erreur attendue : " + e.getMessage());
        }

        // Test 3 : document introuvable
        try {
            manager.emprunter("Java Patterns");
        } catch (MediathequeException e) {
            System.out.println("Erreur attendue : " + e.getMessage());
        }

        // Test 4 : document non empruntable
        try {
            manager.emprunter("Science Magazine");
        } catch (MediathequeException e) {
            System.out.println("Erreur attendue : " + e.getMessage());
        }

        System.out.println("\n=== Fin des tests ===");
    }
}
