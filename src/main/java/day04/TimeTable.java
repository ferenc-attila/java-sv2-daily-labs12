package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TimeTable {

    private List<SubjectAssignment> assignments = new ArrayList<>();
    private Validations validations = new Validations();

    public void addAssignment(SubjectAssignment assignment) {
        assignments.add(assignment);
    }

    public List<SubjectAssignment> getAssignments() {
        return List.copyOf(assignments);
    }

    public void readAssignmentsFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                assignments.add(new SubjectAssignment(line, br.readLine(), br.readLine(), Integer.parseInt(br.readLine())));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to read file!");
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid number of lessons!");
        }
    }

    public int getNumberOfLessonsPerTeacher(String name) {
        int sum = 0;
        validations.validateName(name);
        for (SubjectAssignment actual : assignments) {
            if (name.equals(actual.getTeacherName())) {
                sum += actual.getNumberOfLessons();
            }
        }
        validateResult(sum, name);
        return sum;
    }

    private void validateResult(int sum, String name) {
        if (sum == 0) {
            throw new IllegalArgumentException(name + " is not a name of a teacher!");
        }
    }
}
