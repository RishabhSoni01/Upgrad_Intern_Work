package org.example.Question1;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        int n = studentIdList.length;
        double[] GPA = new double[n];
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < studentsGrades[i].length; j++) {
                char grade = studentsGrades[i][j];
                if (grade == 'A') {
                    total += 4;
                } else if (grade == 'B') {
                    total += 3;
                } else if (grade == 'C') {
                    total += 2;
                } else if (grade == ' ') {
                    throw new MissingGradeException(studentIdList[i]);
                }
            }
            GPA[i] = (double) total / studentsGrades[i].length;
        }
        return GPA;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        try {
            double[] GPA = calculateGPA(studentIdList, studentsGrades);
            int count = 0;
            for (double gpa : GPA) {
                if (gpa >= lower && gpa <= higher) {
                    count++;
                }
            }
            int[] result = new int[count];
            int index = 0;
            for (int i = 0; i < GPA.length; i++) {
                if (GPA[i] >= lower && GPA[i] <= higher) {
                    result[index++] = studentIdList[i];
                }
            }
            return result;
        } catch (MissingGradeException e) {
            throw new InvalidDataException("Invalid data encountered", e);
        }
    }
}

class MissingGradeException extends Exception {
    private int studentId;

    public MissingGradeException(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
}

class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
