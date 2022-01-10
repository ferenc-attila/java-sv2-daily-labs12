package day01;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SummarizeRunningTest {

    private SummarizeRunning summarizeRunning = new SummarizeRunning();

    @Test
    void summarizeTest() {
        Path path = Path.of("src/test/resources/running.csv");

        assertEquals(25.9, summarizeRunning.summarize(path, 2022, 1), 1);
    }

    @Test
    void getResultTest() {
        int year = 2021;
        int month = 12;
        List<DailyWorkout> workouts = new ArrayList<>(Arrays.asList(new DailyWorkout(7.1, LocalDate.parse("2021-11-28")),
                new DailyWorkout(13.5, LocalDate.parse("2021-12-01")),
                new DailyWorkout(14.5, LocalDate.parse("2021-12-03")),
                new DailyWorkout(13.2, LocalDate.parse("2021-12-17")),
                new DailyWorkout(7.2, LocalDate.parse("2022-01-02")),
                new DailyWorkout(8.9, LocalDate.parse("2022-01-06")),
                new DailyWorkout(9.8, LocalDate.parse("2022-01-08"))));

        assertEquals(41.2, summarizeRunning.getResult(year, month, workouts));
    }

    @Test
    void createWorkoutsTest() {
        String line = "13.2 km;2021-11-17";
        DailyWorkout workout = summarizeRunning.createWorkouts(line);

        assertEquals(13.2, workout.getLength());
        assertEquals(LocalDate.of(2021, 11, 17), workout.getDate());
    }

    @Test
    void createWorkoutsInvalidNumberTest() {
        String line = "13,2 km;2021-11-17";

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> summarizeRunning.createWorkouts(line));
        assertEquals(NumberFormatException.class, iae.getCause().getClass());
        assertEquals("Invalid data in the table!", iae.getMessage());
    }

    @Test
    void createWorkoutsNullValueTest() {
        String line = null;

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> summarizeRunning.createWorkouts(line));
        assertEquals(NullPointerException.class, iae.getCause().getClass());
        assertEquals("Invalid data in the table!", iae.getMessage());
    }

    @Test
    void createWorkoutsInvalidDateTest() {
        String line = "13.2 km;2021.11.17";

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> summarizeRunning.createWorkouts(line));
        assertEquals(DateTimeParseException.class, iae.getCause().getClass());
        assertEquals("Invalid data in the table!", iae.getMessage());
    }

    @Test
    void readFileTest() {
        Path path = Path.of("src/test/resources/running.csv");
        List<DailyWorkout> workouts = summarizeRunning.readFile(path);

        assertEquals(7, workouts.size());
        assertEquals(8.9, workouts.get(5).getLength());
        assertEquals(LocalDate.of(2021, 12, 17), workouts.get(3).getDate());
    }

    @Test
    void readFileTestInvalidPath() {
        Path path = Path.of("src/test/resources/running_.csv");
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> summarizeRunning.readFile(path));

        assertEquals(NoSuchFileException.class, ise.getCause().getClass());
        assertEquals("Cannot read file!", ise.getMessage());
    }
}