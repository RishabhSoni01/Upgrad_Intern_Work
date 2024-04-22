package org.example;

public class Nurse extends Staff{
    private long nurseid;
    Nurse(long id,String firstName,String lastName,String gender,String email,long staffId,int yearsOfExperience,String description,double salary,long nurseid){
        super(id,firstName,lastName,gender,email,staffId,yearsOfExperience,description,salary);
        this.nurseid=nurseid;
    }

    public void setNurseid(long nurseid){
        this.nurseid=nurseid;
    }

    public long getNurseid(){
        return  this.nurseid;
    }
}
