package com.juv.workout.repository;

import com.juv.workout.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,String> {
}
