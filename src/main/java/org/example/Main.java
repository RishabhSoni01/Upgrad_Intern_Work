package org.example;
import org.example.Employee;
import org.example.EmployeeRepository;
import org.example.Log;

public class Main {
    public static void main(String[] args) {
        // Create an instance of EmployeeRepository
        EmployeeRepository repository = new EmployeeRepository(100); // Assuming capacity of 100 employees

        // Create some Employee objects
        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setEmployeeName("Ashish");
        employee1.setEmployeeSalary(1200000.0);

        Employee employee2 = new Employee();
        employee2.setEmployeeId(2);
        employee2.setEmployeeName("Rishabh");
        employee2.setEmployeeSalary(1200000.0);

        // Add employees to the repository
        repository.addEmployee(employee1);
        repository.addEmployee(employee2);

        Log.logger.info("added");

        // Retrieve employee by ID
        Employee retrievedEmployee = repository.getEmployeeById(1);
        if (retrievedEmployee != null) {
            System.out.println("Retrieved Employee by ID:");
            System.out.println("ID: " + retrievedEmployee.getEmployeeId());
            System.out.println("Name: " + retrievedEmployee.getEmployeeName());
            System.out.println("Salary: " + retrievedEmployee.getFormattedSalary());
        } else {
            System.out.println("Employee not found.");
        }

        // Update employee information
        repository.updateEmployee(2, "Satyam", 1200000.0);

        // Retrieve employee by name
        retrievedEmployee = repository.getEmployeeByName("Satyam");
        if (retrievedEmployee != null) {
            System.out.println("Retrieved Employee by Name:");
            System.out.println("ID: " + retrievedEmployee.getEmployeeId());
            System.out.println("Name: " + retrievedEmployee.getEmployeeName());
            System.out.println("Salary: " + retrievedEmployee.getFormattedSalary());
        } else {
            System.out.println("Employee not found.");
        }
    }
}