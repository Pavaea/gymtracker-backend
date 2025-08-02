package com.gymtracker.backend.domain.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {
    Optional<Exercise> findByName(String name);
    List<Exercise> findByCategory(String category);
    List<Exercise> findByMuscleGroup(String muscleGroup);
}
