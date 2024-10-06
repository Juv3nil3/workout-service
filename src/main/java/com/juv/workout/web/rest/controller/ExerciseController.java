package com.juv.workout.web.rest.controller;

import com.juv.workout.domain.Exercise;
import com.juv.workout.enums.exercise.PrimaryMuscles;
import com.juv.workout.enums.exercise.SecondaryMuscles;
import com.juv.workout.service.impl.ExerciseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseServiceImpl exerciseService;

    @Autowired
    public ExerciseController(ExerciseServiceImpl exerciseService){
        this.exerciseService = exerciseService;
    }

    // 1. Get all exercises
    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises() {
        List<Exercise> exercises = exerciseService.getAllExercises();
        return ResponseEntity.ok(exercises);
    }

    // 2. Get exercise by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Exercise>> getExerciseById(@PathVariable String id) {
        Optional<Exercise> exercise = exerciseService.getExerciseById(id);
        if (exercise.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exercise);
    }

    // API to search exercises by name
    @GetMapping("/search")
    public ResponseEntity<?> searchExercisesByName(
        @RequestParam("search") String search) {

        List<Exercise> exercises = exerciseService.searchByName(search);

        if (exercises.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No exercises found with the name: " + search);
        }

        return ResponseEntity.ok(exercises);
    }

    // API to search exercises by primary muscle
    @GetMapping("/primary-muscle")
    public ResponseEntity<?> getExercisesByPrimaryMuscle(
        @RequestParam(value = "primaryMuscle") PrimaryMuscles primaryMuscle) {

        List<Exercise> exercises = exerciseService.searchByPrimaryMuscle(primaryMuscle);

        if (exercises.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No exercises found with the name: " + primaryMuscle);
        }

        return ResponseEntity.ok(exercises);
    }

    // API to search exercises by primary muscle
    @GetMapping("/secondary-muscle")
    public ResponseEntity<?> getExercisesBySecondaryMuscles(
        @RequestParam(value = "secondaryMuscle") SecondaryMuscles secondaryMuscles) {

        List<Exercise> exercises = exerciseService.searchBySecondaryMuscle(secondaryMuscles);

        if (exercises.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No exercises found with the name: " + secondaryMuscles);
        }

        return ResponseEntity.ok(exercises);
    }


}
