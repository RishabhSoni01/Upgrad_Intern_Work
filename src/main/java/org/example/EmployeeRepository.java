package org.example;

public class EmployeeRepository {
    private Employee[] employees;
    private int size;

    // Constructor
    public EmployeeRepository(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }


    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
            Log.logger.info("Employee added: " + employee.getEmployeeName() + " (ID: " + employee.getEmployeeId() + ")");
        } else {
            Log.logger.info("Repository is full");
        }
    }

    // Method to retrieve an employee by ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getEmployeeId() == id) {
                Log.logger.info("Employee retrieved by ID: " + employee.getEmployeeName() + " (ID: " + employee.getEmployeeId() + ")");
                return employee;
            }
        }

        return null; // Employee not found
    }

    // Method to retrieve an employee by name
    public Employee getEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee != null && employee.getEmployeeName().equals(name)) {
                Log.logger.info("Employee retrieved by name: " + employee.getEmployeeName() + " (ID: " + employee.getEmployeeId() + ")");
                return employee;
            }
        }
        return null; // Employee not found
    }

    // Method to update an employee's information
    public void updateEmployee(int id, String newName, double newSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getEmployeeId() == id) {
                employee.setEmployeeName(newName);
                employee.setEmployeeSalary(newSalary);
                Log.logger.info("Employee information updated: " + employee.getEmployeeName() + " (ID: " + employee.getEmployeeId() + ")");
                return; // Exit the loop after updating the employee
            }
        }
        System.out.println("Employee with ID " + id + " not found. Cannot update.");
    }

    // Method overloading for retrieving an employee by ID
    public Employee getEmployee(int id) {
        return getEmployeeById(id);
    }

    // Method overloading for retrieving an employee by name
    public Employee getEmployee(String name) {
        return getEmployeeByName(name);
    }
}