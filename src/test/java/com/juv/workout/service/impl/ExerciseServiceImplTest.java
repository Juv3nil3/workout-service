package com.juv.workout.service.impl;

import com.juv.workout.domain.Exercise;
import com.juv.workout.enums.exercise.Equipment;
import com.juv.workout.enums.exercise.Level;
import com.juv.workout.enums.exercise.PrimaryMuscles;
import com.juv.workout.repository.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExerciseServiceImplTest {

    @Mock
    ExerciseRepository exerciseRepository;

    @InjectMocks
    ExerciseServiceImpl exerciseService;

    Exercise sampleExercise;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a sample Exercise object to use in tests
        sampleExercise = new Exercise();
        sampleExercise.setExerciseId("Barbell_Squat");
        sampleExercise.setName("Squat");
        sampleExercise.setInstructions("Stand with feet shoulder-width apart. Lower into a squat.");
        sampleExercise.setPrimaryMuscles(Arrays.asList(PrimaryMuscles.QUADRICEPS, PrimaryMuscles.GLUTES));
        sampleExercise.setLevel(Level.INTERMEDIATE);
        sampleExercise.setEquipment(Equipment.BARBELL);
    }

    @Test
    void testGetExerciseById() {
        when(exerciseRepository.findById("Barbell_Squat")).thenReturn(Optional.of(sampleExercise));

        Optional<Exercise> foundExercise = exerciseService.getExerciseById("Barbell_Squat");

        assertTrue(foundExercise.isPresent());
        assertEquals("Squat", foundExercise.get().getName());
        verify(exerciseRepository, times(1)).findById("Barbell_Squat");
    }

    @Test
    void getAllExercises() {
    }
}
