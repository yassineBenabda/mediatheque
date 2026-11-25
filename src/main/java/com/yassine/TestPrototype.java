
package com.yassine;

public class TestPrototype {

    public static void main(String[] args) throws DocumentIndisponibleException {

        // 1. Créer le livre original
        Livre original = new Livre.Builder("Clean Code", 2008)
                .auteur("Robert Martin")
                .nbPages(464)
                .isbn("978-0132350884")
                .editeur("Prentice Hall")
                .langue("en")
                .build();

        // 2. Créer une copie
        Livre copie = new Livre(original);

        // 3. Afficher les deux livres
        System.out.println("=== AVANT MODIFICATION ===");
        System.out.println("Original : " + original.descriptionCourte());
        System.out.println("Copie : " + copie.descriptionCourte());

        // 4. Emprunter uniquement la copie
        copie.emprunter();

        // 5. Vérifier que l'original n'a pas changé
        System.out.println("\n=== APRÈS EMPRUNT DE LA COPIE ===");
        System.out.println("Original emprunté ? " + original.estEmprunte());
        System.out.println("Copie empruntée ? " + copie.estEmprunte());

        // 6. Vérifier l'indépendance
        if (!original.estEmprunte() && copie.estEmprunte()) {
            System.out.println("\nTEST RÉUSSI : la copie est indépendante !");
        } else {
            System.out.println("\nTEST ÉCHOUÉ !");
        }
    }
}
