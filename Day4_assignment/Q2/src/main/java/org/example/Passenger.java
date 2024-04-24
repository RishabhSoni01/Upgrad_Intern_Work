package org.example;

public class Passenger {

    public String firstName;
    public String lastName;
    public int age;
    public String gender;
    public String travelClass;
    public String confirmationNumber;

    Passenger(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber){
         this.age=age;
         this.firstName=firstName;
         this.lastName=lastName;
         this.gender=gender;
         this.travelClass=travelClass;
         this.confirmationNumber=confirmationNumber;
    }
}
