package com.gymtracker.backend.domain.template;

import java.util.List;
import java.util.UUID;

public class WorkoutTemplate {
    private UUID id;
    private String name;
    private UUID ownerUserId;
    private List<TemplateExercise> predefinedExercises;

    //Clone template into new session
    //Save session as new template
}
