package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectAssignmentTest {

    @Test
    void createTest() {
        SubjectAssignment assignment = new SubjectAssignment("Kovács Piroska", "irodalom", "7.a", 5);

        assertEquals("Kovács Piroska", assignment.getTeacherName());
        assertEquals("irodalom", assignment.getSubject());
        assertEquals("7.a", assignment.getClassName());
        assertEquals(5, assignment.getNumberOfLessons());
    }
}