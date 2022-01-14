package day04;

public class Validations {

    public void validateString(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("Parameter cannot be null or empty!");
        }
    }

    public void validateName(String name) {
        validateString(name);
        if (name.indexOf(' ') == -1) {
            throw new IllegalArgumentException(name + " is invalid person name!");
        }
    }

    public void validateClassName(String className) {
        validateString(className);
        if (!isValidClassNumber(className)) {
            throw new IllegalArgumentException(className + " is invalid class name!");
        }
    }

    public void validateNumberOfLessons(int number) {
        if (number == 0 || number > 40) {
            throw new IllegalArgumentException(number + " is invalid number of lessons!");
        }
    }

    private boolean isValidClassNumber(String className) {
        char[] chars = className.toCharArray();
        if (className.length() == 3) {
            return Character.isDigit(chars[0]) && (chars[0]) != '0' && chars[1] == '.' && chars[2] > 'a' && chars[2] < 'z';
        } else if (className.length() == 4) {
            String classNumber = className.substring(0,2);
            return Character.isDigit(chars[0]) && Character.isDigit(chars[1]) && (chars[0]) != '0' && chars[2] == '.' && chars[3] > 'a' && chars[3] < 'z'&& Integer.parseInt(classNumber) > 0 && Integer.parseInt(classNumber) < 12;
        }
        return false;
    }
}
