package com.m0ravat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class SpringBackendApplication {

    public static void main(String[] args) throws IOException {
        // Read your credentials JSON from an environment variable
        String json = System.getenv("GOOGLE_CREDENTIALS_JSON");

        if (json != null && !json.isEmpty()) {
            // Create a temporary file for the Google credentials
            Path tempFile = Files.createTempFile("gcp-credentials", ".json");
            try (FileWriter writer = new FileWriter(tempFile.toFile())) {
                writer.write(json);
            }

            // Set the system property so Google SDK can find it
            System.setProperty("GOOGLE_APPLICATION_CREDENTIALS", tempFile.toString());
        } else {
            System.err.println("WARNING: GOOGLE_CREDENTIALS_JSON environment variable is not set!");
        }

        SpringApplication.run(SpringBackendApplication.class, args);
    }

}

