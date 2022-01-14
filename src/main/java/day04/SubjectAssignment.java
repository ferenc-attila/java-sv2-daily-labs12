package day04;

public class SubjectAssignment {

    private String teacherName;
    private String subject;
    private String className;
    private int numberOfLessons;
    private Validations validations = new Validations();

    public SubjectAssignment(String teacherName, String subject, String className, int numberOfLessons) {
        validateParameters(teacherName, subject, className, numberOfLessons);
        this.teacherName = teacherName;
        this.subject = subject;
        this.className = className;
        this.numberOfLessons = numberOfLessons;
    }

    private void validateParameters(String teacherName, String subject, String className, int numberOfLessons) {
        validations.validateName(teacherName);
        validations.validateString(subject);
        validations.validateClassName(className);
        validations.validateNumberOfLessons(numberOfLessons);
        }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassName() {
        return className;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }
}
