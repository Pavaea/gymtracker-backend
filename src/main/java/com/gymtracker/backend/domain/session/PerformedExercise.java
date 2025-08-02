package com.gymtracker.backend.domain.session;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class PerformedExercise {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

//    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<WorkoutSet> sets;
//
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "workoutSession_id")
    private WorkoutSession workoutSession;

    private int orderInSession;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<WorkoutSet> getSets() {
//        return sets;
//    }
//
//    public void setSets(List<WorkoutSet> sets) {
//        this.sets = sets;
//    }

    public int getOrderInSession() {
        return orderInSession;
    }

    public void setOrderInSession(int orderInSession) {
        this.orderInSession = orderInSession;
    }
//Add new set
    //Remove last set
    //Calculate total volume for this exercise
}