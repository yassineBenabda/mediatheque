package com.yassine;

public class NotificateurSMTP implements Notificateur {

    private final ServeurSmtp serveur;

    public NotificateurSMTP(ServeurSmtp serveur) {
        this.serveur = serveur;
    }

    @Override
    public void notifier(String message) {
        serveur.envoyer("direction@itbs.tn", message);
    }
}
