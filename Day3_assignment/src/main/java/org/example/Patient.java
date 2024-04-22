package org.example;

public class Patient extends User{
    private long patientid;
    boolean insured;

    Patient(long id,String firstName,String lastName,String gender,String email,long patientid,boolean insured){
        super(id,firstName,lastName,gender,email);
        this.patientid=patientid;
        this.insured=insured;
    }

    public   void  setPatientid(long patientid){
        this.patientid=patientid;
    }

    public  long getPatientid(){
        return this.patientid;
    }

    public  void  setInsured(boolean insured){
        this.insured=insured;
    }

    public boolean isInsured(){
        return  this.insured;
    }



}
