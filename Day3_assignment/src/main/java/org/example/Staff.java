package org.example;

public class Staff extends User {
    //staffId (long), yearsOfExperience (int), description (String), salary (double)
    private long staffId;
    private int yearsOfExperience;
    private String description;
    private double salary;

    Staff(long id,String firstName,String lastName,String gender,String email,long staffId,int yearsOfExperience,String description,double salary){
        super(id,firstName,lastName,gender,email);
        this.staffId=staffId;
        this.yearsOfExperience=yearsOfExperience;
        this.description=description;
        this.salary=salary;
    }


    public  void setStaffId(long staffIdid){
        this.staffId=staffIdid;
    }

    public  long getStaffId(){
        return this.staffId;
    }

    public  void setYearsOfExperience(int yearsOfExperience){
        this.yearsOfExperience=yearsOfExperience;
    }

    public int getYearsOfExperience(){
        return this.yearsOfExperience;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setSalary(double salary){
        this.salary=salary;
    }

    public  double getSalary(){
        return  this.salary;
    }
}
