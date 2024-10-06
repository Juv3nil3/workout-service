package com.juv.workout.service;

import com.juv.workout.domain.Exercise;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {

    Optional<Exercise> getExerciseById(String exerciseId);

    List<Exercise> getAllExercises();

    //Exercise updateExercise(Exercise exercise);
}
