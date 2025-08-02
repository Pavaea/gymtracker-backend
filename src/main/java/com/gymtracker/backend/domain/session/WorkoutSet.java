package com.gymtracker.backend.domain.session;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class WorkoutSet {
    @Id
    @GeneratedValue
    private UUID id;
    private int reps;
    private double weight;
    private int rir;

    @ManyToOne
    @JoinColumn(name = "performed_exercise_id")
    private PerformedExercise performedExercise;

    public PerformedExercise getPerformedExercise() {
        return performedExercise;
    }

    public void setPerformedExercise(PerformedExercise performedExercise) {
        this.performedExercise = performedExercise;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getRir() {
        return rir;
    }

    public void setRir(int rir) {
        this.rir = rir;
    }
//Calculate volume: reps * weight
    //Could be converted to a simple record

}
