package com.yassine;

public class ConfigurationMediatheque {

    private int dureeEmprunt;
    private int nombreMaxEmprunts;

    // Constructeur privé
    private ConfigurationMediatheque() {
        this.dureeEmprunt = 21;
        this.nombreMaxEmprunts = 5;
    }

    // Classe interne Holder
    private static class Holder {
        private static final ConfigurationMediatheque INSTANCE =
                new ConfigurationMediatheque();
    }

    // Point d'accès unique
    public static ConfigurationMediatheque getInstance() {
        return Holder.INSTANCE;
    }

    public int getDureeEmprunt() {
        return dureeEmprunt;
    }

    public void setDureeEmprunt(int dureeEmprunt) {
        this.dureeEmprunt = dureeEmprunt;
    }

    public int getNombreMaxEmprunts() {
        return nombreMaxEmprunts;
    }

    public void setNombreMaxEmprunts(int nombreMaxEmprunts) {
        this.nombreMaxEmprunts = nombreMaxEmprunts;
    }
}
