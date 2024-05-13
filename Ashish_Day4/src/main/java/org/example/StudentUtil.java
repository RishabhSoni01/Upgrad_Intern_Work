package org.example;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        validateInputs(studentIdList, studentsGrades);

        double[] gpaArray = new double[studentIdList.length];

        for (int i = 0; i < studentIdList.length; i++) {
            int totalPoints = 0;
            int totalCourses = studentsGrades[i].length;

            for (char grade : studentsGrades[i]) {
                switch (grade) {
                    case 'A':
                        totalPoints += 4;
                        break;
                    case 'B':
                        totalPoints += 3;
                        break;
                    case 'C':
                        totalPoints += 2;
                        break;
                    default:
                        // Ignore unknown grades
                        break;
                }
            }

            gpaArray[i] = (double) totalPoints / totalCourses;
        }

        return gpaArray;
    }

    public static double[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        try {
            return calculateGPA(studentIdList, studentsGrades);
        } catch (IllegalArgumentException e) {
            throw new StudentUtilException("Error processing GPA calculation.", e);
        }
    }

    private static void validateInputs(int[] studentIdList, char[][] studentsGrades) {
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("Student ID list length does not match grades list length.");
        }

        for (char[] grades : studentsGrades) {
            for (char grade : grades) {
                if (grade == ' ') {
                    throw new IllegalArgumentException("Missing grade found in grades list.");
                }
            }
        }
    }
}

// Task 3: Custom unchecked exception InvalidDataException for exception chaining
class StudentUtilException extends RuntimeException {
    public StudentUtilException(String message, Throwable cause) {
        super(message, cause);
    }
}