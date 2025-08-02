package com.gymtracker.backend.domain.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface WorkoutSessionRepository extends JpaRepository <WorkoutSession, UUID>{
    List<WorkoutSession> findByAppUserUsername(String username);
}
