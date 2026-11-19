
package com.yassine;

public class ServeurSmtp {

    private final String serveur;

    public ServeurSmtp(String serveur) {
        this.serveur = serveur;
    }

    public void envoyer(String destinataire, String message) {
        System.out.println("Connexion au serveur : " + serveur);
        System.out.println("Destinataire : " + destinataire);
        System.out.println("Message : " + message);
        System.out.println("Notification envoyée !");
    }
}
