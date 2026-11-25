
package com.yassine;

public class TestBuilder {

    public static void main(String[] args) {

        Livre livre = new Livre.Builder("Clean Code", 2008)
                .auteur("Robert Martin")
                .nbPages(464)
                .isbn("978-0132350884")
                .editeur("Prentice Hall")
                .langue("en")
                .build();

        System.out.println(livre.descriptionCourte());
        System.out.println("Année : " + livre.getAnnee());
        System.out.println("Pages : " + livre.getNbPages());
        System.out.println("ISBN : " + livre.getIsbn());
        System.out.println("Éditeur : " + livre.getEditeur());
        System.out.println("Langue : " + livre.getLangue());
    }
}
