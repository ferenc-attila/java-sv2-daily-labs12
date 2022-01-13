package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TimeTableTest {

    @Test
    void addAssignmentTest() {
        TimeTable timeTable = new TimeTable();
        timeTable.addAssignment(new SubjectAssignment("Kovács Piroska", "nyelvtan", "7.a", 5));
        assertEquals(1, timeTable.getAssignments().size());
        assertEquals("nyelvtan", timeTable.getAssignments().get(0).getSubject());
        assertEquals(5, timeTable.getAssignments().get(0).getNumberOfLessons());
    }

    @Test
    void readAssignmentsFileTest() {
        TimeTable timeTable = new TimeTable();
        timeTable.readAssignmentsFile(Path.of("src/test/resources/beosztas.txt"));
        assertEquals(329, timeTable.getAssignments().size());
        assertEquals("Szarvas Szamanta", timeTable.getAssignments().get(328).getTeacherName());
        assertEquals("biologia", timeTable.getAssignments().get(0).getSubject());
        assertEquals("9.a", timeTable.getAssignments().get(1).getClassName());
        assertEquals(2, timeTable.getAssignments().get(327).getNumberOfLessons());
    }

    @Test
    void getNumberOfLessonsPerTeacherTest() {
        TimeTable timeTable = new TimeTable();
        timeTable.readAssignmentsFile(Path.of("src/test/resources/beosztas.txt"));
        assertEquals(18, timeTable.getNumberOfLessonsPerTeacher("Siketfajd Simon"));
    }
}