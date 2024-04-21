package org.example.studentUtil;

public class studentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        int n = studentIdList.length;
        double[] ans = new double[n];

        for (int i = 0; i < studentsGrades.length; i++) {

            double cgpa = 0;
            for (int j = 0; j < studentsGrades[i].length; j++) {
                if (studentsGrades[i][j] == 'A') {
                    cgpa += 4;
                } else if (studentsGrades[i][j] == 'B') {
                    cgpa += 3;
                } else if (studentsGrades[i][j] == 'C') {
                    cgpa += 2;
                }
            }
            ans[i] = cgpa / studentsGrades[i].length;
        }
        return ans;
    }

    static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentGrades) {

        if (lower < 0 || higher < 0 || (lower > higher)) {
            return null;
        }
        int n = 0;
        double[] calcCgpa = calculateGPA(studentIdList, studentGrades);
        for (int i = 0; i < calcCgpa.length; i++) {
            if (calcCgpa[i] <= higher && calcCgpa[i] >= lower) {
                n++;
            }
        }

        int[] ans = new int[n];
        int index = 0; // Index variable to ensure correct indexing
        for (int i = 0; i < calcCgpa.length; i++) {
            if (calcCgpa[i] <= higher && calcCgpa[i] >= lower) {
                ans[index++] = studentIdList[i];
            }
        }
        return ans;
    }
}
