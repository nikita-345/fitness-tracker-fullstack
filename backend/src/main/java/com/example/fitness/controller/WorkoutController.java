package com.example.fitness.controller;
import com.example.fitness.entity.Workout;
import com.example.fitness.repository.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/workouts") @CrossOrigin(origins="http://localhost:5173")
public class WorkoutController {
 private final WorkoutRepository workouts; private final UserRepository users;
 public WorkoutController(WorkoutRepository w,UserRepository u){workouts=w;users=u;}
 @GetMapping public List<Workout> all(Authentication a){var u=users.findByEmail(a.getName()).orElseThrow();return workouts.findByUserIdOrderByWorkoutDateDesc(u.getId());}
 @PostMapping public Workout add(@RequestBody Workout w,Authentication a){w.setId(null);w.setUser(users.findByEmail(a.getName()).orElseThrow());return workouts.save(w);}
 @PutMapping("/{id}") public Workout update(@PathVariable Long id,@RequestBody Workout in,Authentication a){
  var w=workouts.findById(id).orElseThrow(); if(!w.getUser().getEmail().equals(a.getName())) throw new RuntimeException("Forbidden");
  w.setWorkoutType(in.getWorkoutType());w.setDuration(in.getDuration());w.setCaloriesBurned(in.getCaloriesBurned());w.setWorkoutDate(in.getWorkoutDate());w.setNotes(in.getNotes());return workouts.save(w);
 }
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id,Authentication a){var w=workouts.findById(id).orElseThrow();if(!w.getUser().getEmail().equals(a.getName()))throw new RuntimeException("Forbidden");workouts.delete(w);}
}