package com.example.fitness.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Workout {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private User user;
 private String workoutType;
 private Integer duration;
 private Integer caloriesBurned;
 private LocalDate workoutDate;
 private String notes;
}