package com.gymtracker.backend.domain.session;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkoutSessionRepository extends JpaRepository <WorkoutSession, UUID>{
    List<WorkoutSession> findByAppUserUsername(String username);
}
