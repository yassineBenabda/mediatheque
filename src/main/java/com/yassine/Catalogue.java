package com.yassine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Catalogue<T extends Document> implements Iterable<T> {

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

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
