package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class SummarizeRunning {

    public double summarize(Path path, int year, int month) {
        List<DailyWorkout> workouts = readFile(path);
        return getResult(year, month, workouts);
    }

    public double getResult(int year, int month, List<DailyWorkout> workouts) {
        double result = 0;
        for (DailyWorkout workout : workouts) {
            if (workout.getDate().getYear() == year && workout.getDate().getMonthValue() == month) {
                result += workout.getLength();
            }
        }
        return result;
    }

    public DailyWorkout createWorkouts(String line) {
        DailyWorkout workout;
        try {
            String[] values = line.split(" km;");
            workout = new DailyWorkout(Double.parseDouble(values[0]), LocalDate.parse(values[1]));

        } catch (NumberFormatException | NullPointerException | DateTimeParseException exception) {
            throw new IllegalArgumentException("Invalid data in the table!", exception);
        }
        return workout;
    }

    public List<DailyWorkout> readFile(Path path) {
        List<DailyWorkout> workouts = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                workouts.add(createWorkouts(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
        workouts.remove(0);
        return workouts;
    }
}
