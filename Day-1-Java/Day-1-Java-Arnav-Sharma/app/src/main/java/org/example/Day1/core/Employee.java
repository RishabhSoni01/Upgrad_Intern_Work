package org.example.Day1.core;

public class Employee {
    private static int id;
    private static String name;
    private static int age;
    private static String department;

    public Employee(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
