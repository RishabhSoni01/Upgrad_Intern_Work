package org.example.answer1;

public class Task1 {

    static public void checkException(int[] studentIdList, char[][] studentGrades) {
        if (studentIdList.length != studentGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: "
                    + studentIdList.length + ", studentsGrades.length: " + studentGrades.length);
        }
    }

    public static void main(String[] args) {
        int[] studentIdList = {1001, 1002};
        char[][] studentsGrades = { {'A', 'A', 'A', 'B'} };

        try {
            checkException(studentIdList, studentsGrades);
            System.out.println("Validation successful.");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
