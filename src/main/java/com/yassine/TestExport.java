
package com.yassine;

public class TestExport {

    public static void main(String[] args) {

        // 1. Créer un catalogue
        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(
                new Livre.Builder("Clean Code", 2008)
                        .auteur("Robert Martin")
                        .nbPages(464)
                        .build()
        );

        catalogue.ajouter(
                new Livre.Builder("Effective Java", 2018)
                        .auteur("Joshua Bloch")
                        .nbPages(416)
                        .build()
        );

        // 2. Export CSV
        FabriqueExport fabriqueCsv = new FabriqueCsv();

        ExportCatalogue exportCsv =
                new ExportCatalogue(fabriqueCsv);

        System.out.println("===== EXPORT CSV =====");
        System.out.println(exportCsv.exporter(catalogue));

        // 3. Export HTML
        FabriqueExport fabriqueHtml = new FabriqueHtml();

        ExportCatalogue exportHtml =
                new ExportCatalogue(fabriqueHtml);

        System.out.println("===== EXPORT HTML =====");
        System.out.println(exportHtml.exporter(catalogue));
    }
}
