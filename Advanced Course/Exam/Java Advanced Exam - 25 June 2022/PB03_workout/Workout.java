package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }



    public String getType() {
        return type;
    }


    public List<Exercise> getExercises() {
        return exercises;
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size()<this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise entry : this.exercises) {
            if (entry.getName().equals(name) && entry.getMuscle().equals(muscle)) {
                this.exercises.remove(entry);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        Exercise returnExercise = null;

        for (Exercise entry : this.exercises) {
            if (entry.getName().equals(name) && entry.getMuscle().equals(muscle)) {
                returnExercise = entry;
            }
        }
        return returnExercise;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount(){
        return this.exerciseCount;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(this.type).append("\n");
        this.exercises.forEach(e->sb.append(e).append("\n"));
        return sb.toString().trim();
    }


}
