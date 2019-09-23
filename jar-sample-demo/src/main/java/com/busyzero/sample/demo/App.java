package com.busyzero.sample.demo;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        ProtectionDomain protectionDomain = App.class.getProtectionDomain();
        CodeSource codeSource = protectionDomain.getCodeSource();
        URI location = (codeSource != null ? codeSource.getLocation().toURI() : null);
        String path = (location != null ? location.getSchemeSpecificPart() : null);
        if (path == null) {
            throw new IllegalStateException("Unable to determine code source archive");
        }
        File root = new File(path);
        if (!root.exists()) {
            throw new IllegalStateException(
                    "Unable to determine code source archive from " + root);
        }
    }
}
