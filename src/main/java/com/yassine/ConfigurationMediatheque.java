
package com.yassine;

public class ConfigurationMediatheque {

    private final int dureeEmprunt;
    private final int nombreMaxEmprunts;

    public ConfigurationMediatheque(
            int dureeEmprunt,
            int nombreMaxEmprunts) {

        this.dureeEmprunt = dureeEmprunt;
        this.nombreMaxEmprunts = nombreMaxEmprunts;
    }

    public int getDureeEmprunt() {
        return dureeEmprunt;
    }

    public int getNombreMaxEmprunts() {
        return nombreMaxEmprunts;
    }
}
