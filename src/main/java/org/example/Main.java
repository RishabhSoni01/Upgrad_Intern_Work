package org.example;

public class Main {


    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] gpas = new double[studentIdList.length];

        for (int i = 0; i < studentIdList.length; i++) {
            int totalPoints = 0;
            int numCourses = studentsGrades[i].length;
            for (int j = 0; j < numCourses; j++) {
                switch (studentsGrades[i][j]) {
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
                        totalPoints += 1;
                        break;
                }
            }
            gpas[i] = (double) totalPoints / numCourses;
        }
        return gpas;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpas = calculateGPA(studentIdList, studentsGrades);
        int count = 0;
        for (double gpa : gpas) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] students = new int[count];
        int j = 0;
        for (int i = 0; i < gpas.length; i++) {
            if (gpas[i] >= lower && gpas[i] <= higher) {
                students[j] = studentIdList[i];
                j++;
            }
        }

        return students;
    }
}


