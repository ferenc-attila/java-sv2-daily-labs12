package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DailyWorkoutTest {

    @Test
    void createTest() {
        DailyWorkout workout = new DailyWorkout(13.5, LocalDate.parse("2021-12-01"));

        assertEquals(13.5, workout.getLength());
        assertEquals(LocalDate.of(2021,12, 1), workout.getDate());
    }

}