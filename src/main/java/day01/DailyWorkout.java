package day01;

import java.time.LocalDate;

public class DailyWorkout {

    private double length;
    private LocalDate date;

    public DailyWorkout(double length, LocalDate date) {
        this.length = length;
        this.date = date;
    }

    public double getLength() {
        return length;
    }

    public LocalDate getDate() {
        return date;
    }
}
