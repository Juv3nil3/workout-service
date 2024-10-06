package com.juv.workout.repository;

import com.juv.workout.domain.Exercise;
import com.juv.workout.enums.exercise.PrimaryMuscles;
import com.juv.workout.enums.exercise.SecondaryMuscles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise,String> {

    @Query("SELECT e FROM Exercise e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Exercise> searchByName(@Param("keyword") String keyword);

    // Method to search exercises by primary muscle group
    @Query("SELECT e FROM Exercise e JOIN e.primaryMuscles pm WHERE pm = :primaryMuscle")
    List<Exercise> searchByPrimaryMuscle(@Param("primaryMuscle") PrimaryMuscles primaryMuscle);

    // Method to search exercises by secondary muscle group
    @Query("SELECT e FROM Exercise e JOIN e.secondaryMuscles sm WHERE sm = :secondaryMuscle")
    List<Exercise> searchBySecondaryMuscle(@Param("secondaryMuscle") SecondaryMuscles secondaryMuscle);

    // Method to search exercises by name and muscle group (optional for combining search)
    @Query("SELECT e FROM Exercise e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
        "AND :primaryMuscle IS NULL OR :primaryMuscle MEMBER OF e.primaryMuscles " +
        "AND :secondaryMuscle IS NULL OR :secondaryMuscle MEMBER OF e.secondaryMuscles")
    List<Exercise> searchByNameAndMuscleGroup(@Param("keyword") String keyword,
                                              @Param("primaryMuscle") PrimaryMuscles primaryMuscle,
                                              @Param("secondaryMuscle") SecondaryMuscles secondaryMuscle);

}
