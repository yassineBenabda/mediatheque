package com.yassine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalogue<T extends Document> {

    private final List<T> elements = new ArrayList<>();

    public void ajouter(T element) {
        elements.add(element);
    }

    public Optional<T> rechercherParTitre(String titre) {
        for (T element : elements) {
            if (element.getTitre().equalsIgnoreCase(titre)) {
                return Optional.of(element);
            }
        }

        return Optional.empty();
    }

    public void afficherTout() {
        for (T element : elements) {
            System.out.println(element.descriptionCourte());
        }
    }
}