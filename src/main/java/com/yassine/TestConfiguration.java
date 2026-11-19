package com.yassine;

public class TestConfiguration {
    public static void main(String[] args) {

        ConfigurationMediatheque config1 =
                ConfigurationMediatheque.getInstance();

        ConfigurationMediatheque config2 =
                ConfigurationMediatheque.getInstance();

        System.out.println("Durée : " + config1.getDureeEmprunt());
        System.out.println("Nombre max : " + config1.getNombreMaxEmprunts());

        System.out.println("Même instance ? " + (config1 == config2));
    }
}
