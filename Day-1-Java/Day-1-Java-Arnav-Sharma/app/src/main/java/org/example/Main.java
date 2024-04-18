package org.example;

import  org.example.Day1.core.Employee;
import  org.example.Day1.core.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();

        repository.addEmployee(new Employee(1, "John", 30, "Engineering"));
        repository.addEmployee(new Employee(2, "Alice", 35, "Marketing"));

        Employee emp = repository.getEmployeeById(1);
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Age: " + emp.getAge());
        System.out.println("Employee Department: " + emp.getDepartment());


        Employee updatedEmployee = new Employee(1, "John Doe", 31, "Engineering");
        repository.updateEmployee(updatedEmployee);

        Employee retrievedEmployee = repository.getEmployeeById(1);
        if (retrievedEmployee != null) {
            logger.info("Employee retrieved by ID: {}", retrievedEmployee.getName());
        } else {
            logger.warn("Employee not found");
        }

    }
}
