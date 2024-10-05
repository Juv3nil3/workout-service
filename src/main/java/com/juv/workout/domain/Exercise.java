package com.juv.workout.domain;

import com.juv.workout.enums.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exercise")
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Exercise {


    @Id
    @Column(name = "exercise_id", nullable = false,unique = true)
    String exerciseId;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "instructions", columnDefinition = "TEXT")
    String instructions;

    @ElementCollection(targetClass = PrimaryMuscles.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "exercise_primary_muscles", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "primary_muscle")
    List<PrimaryMuscles> primaryMuscles;

    @ElementCollection(targetClass = SecondaryMuscles.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "exercise_secondary_muscles", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "secondary_muscle")
    List<SecondaryMuscles> secondaryMuscles;

    @Enumerated(EnumType.STRING)
    Level level;

    @Enumerated(EnumType.STRING)
    Mechanic mechanic;

    @Enumerated(EnumType.STRING)
    Equipment equipment;

    @Enumerated(EnumType.STRING)
    Category category;

    @Enumerated(EnumType.STRING)
    Force force;

    @ElementCollection
    @CollectionTable(name = "exercise_images", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "image")
    List<String> images;

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<PrimaryMuscles> getPrimaryMuscles() {
        return primaryMuscles;
    }

    public void setPrimaryMuscles(List<PrimaryMuscles> primaryMuscles) {
        this.primaryMuscles = primaryMuscles;
    }

    public List<SecondaryMuscles> getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(List<SecondaryMuscles> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Force getForce() {
        return force;
    }

    public void setForce(Force force) {
        this.force = force;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
