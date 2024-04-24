package org.example.Question1;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
        // Task 1: Parameter Validation
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. " +
                    "studentIdList.length: " + studentIdList.length +
                    ", studentsGrades.length: " + studentsGrades.length);
        }

        // Task 2: Check for missing grades and throw MissingGradeException
        for (int i = 0; i < studentsGrades.length; i++) {
            for (char grade : studentsGrades[i]) {
                if (grade == ' ') {
                    throw new MissingGradeException(studentIdList[i]);
                }
            }
        }

        double[] res = new double[studentIdList.length];
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('A', 4);
        mp.put('B', 3);
        mp.put('C', 2);
        for (int i = 0; i < studentIdList.length; i++) {
            int sum = 0;
            int count = 0;
            for (char grade : studentsGrades[i]) {
                sum += mp.get(grade);
                count += 1;
            }
            res[i] = (double) sum / count;
        }
        return res;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        try {
            double[] gpa = calculateGPA(studentIdList, studentsGrades);
            ArrayList<Integer> res = new ArrayList<>();

            for (int i = 0; i < gpa.length; i++) {
                if (gpa[i] >= lower && gpa[i] <= higher) {
                    res.add(studentIdList[i]);
                }
            }

            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }

            return ans;
        } catch (MissingGradeException e) {
            throw new InvalidDataException("Invalid data while calculating GPA", e);
        }
    }
}