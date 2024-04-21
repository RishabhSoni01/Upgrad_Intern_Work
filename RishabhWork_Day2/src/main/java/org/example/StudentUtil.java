package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double []res= new double[studentIdList.length];
        HashMap<Character,Integer> mp=new HashMap<>();
        mp.put('A',4);
        mp.put('B',3);
        mp.put('C',2);
        for(int i=0;i<studentIdList.length;i++){
            int sum=0;
            int count=0;
            for(char grade:studentsGrades[i]){
                sum+=mp.get(grade);
                count+=1;
            }
            res[i]=(double) sum/count;
        }
        return res;
    }
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if(lower>higher || lower<0 || higher<0){
            return null;
        }

        double[] gpa=calculateGPA(studentIdList,studentsGrades);
        ArrayList<Integer> res=new ArrayList<>();

        for(int i=0;i<gpa.length;i++){
            if(gpa[i]>=lower && gpa[i]<=higher){
                res.add(studentIdList[i]);
            }
        }

        int []ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }

        return ans;
        /*
		 Perform parameter validation. Return null if passed parameters are not valid invoke calculateGPA
		 Construct the result array and return it. You would need an extra
		 for loop to compute the size of the resulting array
        */
    }
}