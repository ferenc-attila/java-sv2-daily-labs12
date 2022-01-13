package day04;

public class SubjectAssignment {

    private String teacherName;
    private String Subject;
    private String className;
    private int numberOfLessons;

    public SubjectAssignment(String teacherName, String subject, String className, int numberOfLessons) {
        this.teacherName = teacherName;
        Subject = subject;
        this.className = className;
        this.numberOfLessons = numberOfLessons;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubject() {
        return Subject;
    }

    public String getClassName() {
        return className;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }
}
