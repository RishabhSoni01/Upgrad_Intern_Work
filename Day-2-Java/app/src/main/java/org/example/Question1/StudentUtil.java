package org.example.Question1;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        int n=studentIdList.length;
        double[] GPA=new double[n];
        for (int i=0;i<n;i++){
            int total=0;
            for (int j=0;j<studentsGrades[i].length;j++){
                char grade=studentsGrades[i][j];
                if (grade == 'A'){
                    total+=4;
                }
                else if (grade == 'B') {
                    total += 3;
                }
                else if (grade == 'C') {
                    total += 2;
                }
            }
            GPA[i]=(double)total/studentsGrades[i].length;
        }
        return GPA;
    }
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }
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
    }

}
