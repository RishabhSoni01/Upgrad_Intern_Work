package org.example.Day1;

public class Employee{
    public long id;
    private String name;
    private long age;
    private String department;

    public Employee(long id,String name,long age,String department){
        this.id=id;
        this.name=name;
        this.age=age;
        this.department=department;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public long getAge(){
        return this.age;
    }


    public void setAge(long age){
         this.age=age;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
         this.id=id;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setDepartment(String department){
        this.department=department;
    }

    public void setter(long id,String name,long age,String department){
        this.id=id;
        this.name=name;
        this.age=age;
        this.department=department;
    }


    public void getter(){
        System.out.println("id: "+id+" name: "+name+" age: "+age+" department: "+department);
    }
}