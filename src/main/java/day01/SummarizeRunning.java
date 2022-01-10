package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class SummarizeRunning {

    public double summarize(Path path, int year, int month) {
        List<String> lines = readFile(path);
        List<DailyWorkout> workouts = createWorkouts(lines);
        return getResult(year, month, workouts);
    }

    private double getResult(int year, int month, List<DailyWorkout> workouts) {
        double result = 0;
        for (DailyWorkout workout : workouts) {
            if (workout.getDate().getYear() == year && workout.getDate().getMonthValue() == month) {
                result += workout.getLength();
            }
        }
        return result;
    }

    private List<DailyWorkout> createWorkouts(List<String> lines) {
        List<DailyWorkout> workouts = new ArrayList<>();
        try {
            for (String line : lines) {
                String[] values = line.split(" km;");
                workouts.add(new DailyWorkout(Double.parseDouble(values[0]), LocalDate.parse(values[1])));
            }
        } catch (NumberFormatException | NullPointerException | PatternSyntaxException | DateTimeParseException exception) {
            throw new IllegalArgumentException("Invalid data in the table!", exception);
        }
        return workouts;
    }

    private List<String> readFile(Path path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
        return lines;
    }
}
