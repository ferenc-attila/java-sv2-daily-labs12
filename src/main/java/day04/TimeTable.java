package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TimeTable {

    private List<SubjectAssignment> assignments = new ArrayList<>();

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
            throw new IllegalStateException("Unable to read file");
        }
    }

    public int getNumberOfLessonsPerTeacher(String name) {
        int sum = 0;
        for (SubjectAssignment actual : assignments) {
            if (name.equals(actual.getTeacherName())) {
                sum += actual.getNumberOfLessons();
            }
        }
        return sum;
    }
}
