package com.gymtracker.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("dev")
@Component
public class DebugDbEnv implements CommandLineRunner {

    @Value("${DB_URL}")
    private String dbUrl;

    @Value("${DB_USERNAME}")
    private String dbUsername;

    @Value("${DB_PASSWORD}")
    private String dbPassword;

    @Override
    public void run(String... args) {
        System.out.println("🔍 DEBUG ENV CHECK:");
        System.out.println("🔍 DB_URL = " + dbUrl);
        System.out.println("🔍 DB_USERNAME = " + dbUsername);
        System.out.println("🔍 DB_PASSWORD = " + (dbPassword != null && !dbPassword.isEmpty() ? "[SET]" : "null or empty"));
    }
}