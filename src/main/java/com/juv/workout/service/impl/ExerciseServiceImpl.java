package com.juv.workout.service.impl;

import com.juv.workout.domain.Exercise;
import com.juv.workout.enums.exercise.PrimaryMuscles;
import com.juv.workout.enums.exercise.SecondaryMuscles;
import com.juv.workout.repository.ExerciseRepository;
import com.juv.workout.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Optional<Exercise> getExerciseById(String exerciseId) {
        return exerciseRepository.findById(exerciseId);
    }

    @Override
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @Override
    public List<Exercise> searchByName(String keyword) {
        return exerciseRepository.searchByName(keyword);
    }

    @Override
    public List<Exercise> searchByPrimaryMuscle(PrimaryMuscles primaryMuscle) {
        return exerciseRepository.searchByPrimaryMuscle(primaryMuscle);
    }

    @Override
    public List<Exercise> searchBySecondaryMuscle(SecondaryMuscles secondaryMuscle) {
        return exerciseRepository.searchBySecondaryMuscle(secondaryMuscle);
    }

    @Override
    public List<Exercise> searchByNameAndMuscleGroup(String keyword, PrimaryMuscles primaryMuscle, SecondaryMuscles secondaryMuscle) {
        return List.of();
    }

}
