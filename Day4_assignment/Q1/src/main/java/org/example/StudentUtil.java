package org.example;

import java.util.ArrayList;
import java.util.Arrays;



public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][]
            studentsGrades) throws MissingGradeException {


        int total_students =studentIdList.length;

        double[] results = new double[total_students];

        for(int i=0;i<studentIdList.length;i++){
            double student_gpa;

            int sum=0;

            int total_grades = studentsGrades[i].length;

            for(int j=0;j<total_grades;j++){

                if(studentsGrades[i][j]==' '){
                    throw new MissingGradeException("studentid:" + studentIdList[i]);
                }

                if(studentsGrades[i][j]=='A'){
                    sum+=4;
                }else if(studentsGrades[i][j]=='B'){
                    sum+=3;
                }else sum+=2;

            }



            results[i]= (double)sum/total_grades;

            System.out.println(i+"="+results[i]);

        }
// your code
        return results;
    }


    public static int[] getStudentsByGPA(double lower, double higher, int[]
            studentIdList, char[][] studentsGrades) throws IllegalArgumentException,InvalidDataException {
       /*


		 Perform parameter validation. Return null if passed parameters are not valid invoke calculateGPA
		 Construct the result array and return it. You would need an extra
		 for loop to compute the size of the resulting array


 */
        int total_students = studentIdList.length;
        int total_grades = studentsGrades.length;

        if(total_students!=total_grades){
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        try {
            int cnt=0;
            double[] gpa = calculateGPA(studentIdList,studentsGrades);
            for(int i=0;i<total_students;i++){
                if((lower<=gpa[i])&&(gpa[i]<=higher))cnt++;
            }

            int[] result = new int[cnt];

            int ri=0;

            for(int i=0;i<total_students;i++){
                if((lower<=gpa[i])&&(gpa[i]<=higher))result[ri++]=studentIdList[i];
            }

            return result;
        }catch (MissingGradeException e){

               throw new InvalidDataException("erroe while calculating GPA",e);
        }







    }

    public static void main(String[] args){
        double lower = 3.2;

        double higher = 3.5;

        int[] studentIdList = {1001, 1002};


        char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };


        try {
            int[] result = getStudentsByGPA(lower, higher, studentIdList, studentsGrades);
            System.out.println("students in range are: "+ Arrays.toString(result));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}