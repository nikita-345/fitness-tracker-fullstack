package com.example.fitness.repository;
import com.example.fitness.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface WorkoutRepository extends JpaRepository<Workout,Long>{ List<Workout> findByUserIdOrderByWorkoutDateDesc(Long userId); }