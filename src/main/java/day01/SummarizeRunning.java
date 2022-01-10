package day01;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummarizeRunning {

    public double summarize (Path path, int year, int month) {
        List<String> lines = readFile(path);
        List<DailyWorkout> workouts = createWorkouts(lines);
        double result = 0;
        for (DailyWorkout workout : workouts) {
            if (workout.getDate().getYear() == year && workout.getDate().getMonthValue() == month) {
                result+= workout.getLength();
            }
        }
        return result;
    }

    private List<DailyWorkout> createWorkouts(List<String> lines) {
        List<DailyWorkout> workouts = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(" km;");
            workouts.add(new DailyWorkout(Double.parseDouble(values[0]), LocalDate.parse(values[1])));
        }
        return workouts;
    }

    private List<String> readFile(Path path) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
        lines.remove(0);
        return lines;
    }
}
