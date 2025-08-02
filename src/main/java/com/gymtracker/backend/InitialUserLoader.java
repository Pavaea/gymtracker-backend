package com.gymtracker.backend;

import com.gymtracker.backend.domain.user.AppUserRepository;
import com.gymtracker.backend.domain.user.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.gymtracker.backend.domain.user.AppUser;

@Component
public class InitialUserLoader implements CommandLineRunner {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${ADMIN_USERNAME}")
    private String adminUsername;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    @Value("${ADMIN_ROLE}")
    private String adminRole;

    public InitialUserLoader(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (appUserRepository.findByUsername(adminUsername).isEmpty()) {
            AppUser admin = new AppUser();
            admin.setUsername(adminUsername);
            admin.setPasswordHash(passwordEncoder.encode(adminPassword));
            admin.setRole(Role.valueOf(adminRole));
            appUserRepository.save(admin);
            System.out.println("Admin user created");
        } else {
            System.out.println("Admin already exists — skipping");
        }
    }
}
