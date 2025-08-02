package com.gymtracker.backend.domain.user;

import com.gymtracker.backend.domain.session.WorkoutSession;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<WorkoutSession> sessions;

//    public List<WorkoutSession> getSessions() {
//        return sessions;
//    }

//    public void setSessions(List<WorkoutSession> sessions) {
//        this.sessions = sessions;
//    }
//
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    //Can start a new session
    //
    //Can access their own history
    //
    //Can apply a template
}
