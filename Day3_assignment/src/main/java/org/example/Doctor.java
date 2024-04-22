package org.example;

public class Doctor extends Staff {
    //doctorId (long), specialization (String)
    private long doctorId;
    private String specialization;

    Doctor(long id,String firstName,String lastName,String gender,String email,long staffId,int yearsOfExperience,String description,double salary,long doctorId,String specialization){
           super(id,firstName,lastName,gender,email,staffId,yearsOfExperience,description,salary);
           this.doctorId=doctorId;
           this.specialization=specialization;
    }

    public  void setDoctorId(long doctorId){
        this.doctorId=doctorId;
    }

    public long getDoctorId(){
        return  this.doctorId;
    }

    public void setSpecialization(String specialization){
        this.specialization=specialization;
    }

    public String getSpecialization(){
        return  this.specialization;
    }

}
