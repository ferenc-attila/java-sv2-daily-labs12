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

    @Test
    void createWithEmptyTeacherName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                new SubjectAssignment("", "irodalom", "7.a", 5));

        assertEquals("Parameter cannot be null or empty!", iae.getMessage());
    }

    @Test
    void createWithTeacherNameWithoutSpace() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                new SubjectAssignment("KovácsPiri", "irodalom", "7.a", 5));

        assertEquals("KovácsPiri is invalid person name!", iae.getMessage());
    }

    @Test
    void createWithEmptySubject() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                new SubjectAssignment("Kovács Piroska", "", "7.a", 5));

        assertEquals("Parameter cannot be null or empty!", iae.getMessage());
    }

    @Test
    void createWithEmptyClassName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                new SubjectAssignment("Kovács Piroska", "irodalom", "", 5));

        assertEquals("Parameter cannot be null or empty!", iae.getMessage());
    }

    @Test
    void createWithTooShortClassName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                new SubjectAssignment("Kovács Piroska", "irodalom", "8.", 5));

        assertEquals("8. is invalid class name!", iae.getMessage());
    }

    @Test
    void createWithTooLongClassName() {
            IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                    new SubjectAssignment("Kovács Piroska", "irodalom", "12.ab", 5));

            assertEquals("12.ab is invalid class name!", iae.getMessage());
    }

    @Test
    void createWithZeroClassNumber() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                new SubjectAssignment("Kovács Piroska", "irodalom", "0.a", 5));

        assertEquals("12.ab is invalid class name!", iae.getMessage());
    }
}