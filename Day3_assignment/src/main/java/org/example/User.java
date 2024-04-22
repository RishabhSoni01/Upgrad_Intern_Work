package org.example;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;

    User(long id,String firstName,String lastName,String gender,String email){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.email=email;
    }
    // add rest of the variables

    public  void setId(long id){
        this.id=id;
    }

    public  long getId(){
        return this.id;
    }

    public  void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public  String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    public String getGender(){
        return this.gender;
    }



    // add rest of the getters & setters

}
