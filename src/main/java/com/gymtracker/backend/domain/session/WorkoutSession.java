package com.gymtracker.backend.domain.session;

import com.gymtracker.backend.domain.user.AppUser;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class WorkoutSession {
    @Id
    @GeneratedValue
    private UUID id;

    @Transient
    private WorkoutFeedback feedback;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

//    @OneToMany(mappedBy = "workout_session", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "exercises_id")
//    private List<PerformedExercise> exercises;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

//    public List<PerformedExercise> getExercises() {
//        return exercises;
//    }
//
//    public void setExercises(List<PerformedExercise> exercises) {
//        this.exercises = exercises;
//    }
//
    public WorkoutFeedback getFeedback() {
        return feedback;
    }

    public void setFeedback(WorkoutFeedback feedback) {
        this.feedback = feedback;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }



    //Add exercise to session
    //
    //Add set to exercise
    //
    //Close session
    //
    //Track total volume
    //
    //Get session duration
}
