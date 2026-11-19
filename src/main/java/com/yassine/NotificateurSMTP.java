package com.yassine;


public class NotificateurSMTP implements Notificateur {

    private final ServeurSmtp serveur;

    public NotificateurSMTP() {
        this.serveur = new ServeurSmtp("smtp.itbs.tn");
    }

    @Override
    public void notifier(String message) {
        serveur.envoyer("direction@itbs.tn", message);
    }
}

