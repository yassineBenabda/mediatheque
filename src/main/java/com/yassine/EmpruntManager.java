package com.yassine;

public class EmpruntManager {

    private final Catalogue<Document> catalogue;

    public EmpruntManager(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public void emprunter(String titre)
            throws DocumentIntrouvableException,
            DocumentIndisponibleException {

        // 1. Rechercher le document
        Document document = catalogue.rechercherParTitre(titre)
                .orElseThrow(() ->
                        new DocumentIntrouvableException(
                                "Document introuvable : " + titre
                        )
                );

        // 2. Vérifier si le document est empruntable
        if (!(document instanceof Empruntable)) {
            throw new DocumentIndisponibleException(
                    "Le document '" + titre + "' n'est pas empruntable"
            );
        }

        // 3. Effectuer l'emprunt
        Empruntable empruntable = (Empruntable) document;
        empruntable.emprunter();
    }
}
