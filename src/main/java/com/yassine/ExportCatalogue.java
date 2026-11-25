
package com.yassine;

public class ExportCatalogue {

    private final FabriqueExport fabrique;

    public ExportCatalogue(FabriqueExport fabrique) {
        this.fabrique = fabrique;
    }

    public String exporter(Iterable<Document> documents) {

        StringBuilder sb = new StringBuilder();

        sb.append(fabrique.enTete());

        for (Document d : documents) {
            sb.append(fabrique.ligne(d));
        }

        sb.append(fabrique.pied());

        return sb.toString();
    }
}
