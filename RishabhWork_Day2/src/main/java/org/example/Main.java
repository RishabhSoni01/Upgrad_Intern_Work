package org.example;

import org.example.StudentUtil;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner=new Scanner(System.in);
        int numberofstudent=scanner.nextInt();
        int []studentIdList = new int[numberofstudent];

        for(int i=0;i<numberofstudent;i++){
            studentIdList[i]=scanner.nextInt();
        }

        int numofcourses=scanner.nextInt();
        char [][] studentsGrades=new char[numberofstudent][numofcourses];
        for(int i=0;i<numberofstudent;i++){
            String gradesLines=scanner.next();
            for(int j=0;j<numofcourses;j++){
                studentsGrades[i][j]=gradesLines.charAt(j);
            }
        }

        double[] gpa= StudentUtil.calculateGPA(studentIdList,studentsGrades);
        System.out.println("GPA: "+ Arrays.toString(gpa));

        double lower=scanner.nextDouble();
        double higher=scanner.nextDouble();
        int []studentByGpa = StudentUtil.getStudentsByGPA(lower,higher,studentIdList,studentsGrades);
        System.out.println("StudentByGPA: "+ Arrays.toString(studentByGpa));
    }
}