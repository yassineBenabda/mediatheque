
package com.yassine;

public class TestConfiguration {

    public static void main(String[] args) {

        // Première configuration
        ConfigurationMediatheque config1 =
                new ConfigurationMediatheque(7, 5);

        // Deuxième configuration
        ConfigurationMediatheque config2 =
                new ConfigurationMediatheque(21, 3);

        System.out.println("Configuration 1 :");
        System.out.println("Durée : " + config1.getDureeEmprunt());
        System.out.println("Nombre max : " + config1.getNombreMaxEmprunts());

        System.out.println("\nConfiguration 2 :");
        System.out.println("Durée : " + config2.getDureeEmprunt());
        System.out.println("Nombre max : " + config2.getNombreMaxEmprunts());

        System.out.println("\nMême instance ? " + (config1 == config2));
    }
}
