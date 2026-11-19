
package com.yassine;

public class EmpruntManager {

    private final Catalogue<Document> catalogue;
    private final ConfigurationMediatheque config;

    public EmpruntManager(
            Catalogue<Document> catalogue,
            ConfigurationMediatheque config) {

        this.catalogue = catalogue;
        this.config = config;
    }

    public ConfigurationMediatheque getConfig() {
        return config;
    }
}
