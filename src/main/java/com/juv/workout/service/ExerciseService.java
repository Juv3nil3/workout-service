package com.juv.workout.service;

import com.juv.workout.domain.Exercise;
import com.juv.workout.enums.exercise.PrimaryMuscles;
import com.juv.workout.enums.exercise.SecondaryMuscles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {

    Optional<Exercise> getExerciseById(String exerciseId);

    List<Exercise> getAllExercises();

    List<Exercise> searchByName(String keyword);

    List<Exercise> searchByPrimaryMuscle(PrimaryMuscles primaryMuscle);

    List<Exercise> searchBySecondaryMuscle(SecondaryMuscles secondaryMuscle);

    List<Exercise> searchByNameAndMuscleGroup(String keyword, PrimaryMuscles primaryMuscle,
                                              SecondaryMuscles secondaryMuscle);

    //Exercise updateExercise(Exercise exercise);
}
