package org.example.app;

import org.example.core.Employee;
import org.example.data.EmployeeRepository;
import org.example.logging.Log;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository(10);

        Employee emp1 = new Employee(1, "Alice", 30, "Engineering");
        Employee emp2 = new Employee(2, "Bob", 25, "Marketing");
        Employee emp3 = new Employee(3, "Charlie", 35, "HR");

        repository.addEmployee(emp1);
        repository.addEmployee(emp2);
        repository.addEmployee(emp3);

        Log.logger.info("Added employees to the repository.");

        Employee retrievedEmp1 = repository.getEmployee(1);
        if (retrievedEmp1 != null) {
            Log.logEmployeeRetrieval(1);
            System.out.println("Retrieved employee by ID: ID = " + retrievedEmp1.getId() + ", Name = " + retrievedEmp1.getName());
        }

        Employee[] employeesByName = repository.getEmployeesByName("Bob");
        if (employeesByName.length > 0) {
            System.out.println("Retrieved employees by name 'Bob':");
            for (Employee e : employeesByName) {
                System.out.println("ID = " + e.getId() + ", Name = " + e.getName());
            }
        } else {
            Log.logger.info("No employees found with name 'Bob'.");
        }

        Employee updatedEmp = new Employee(2, "Bobby", 26, "Sales");
        repository.updateEmployee(2, updatedEmp);
        Log.logEmployeeUpdate(updatedEmp);

        repository.printAllEmployees();

        Log.logger.info("Program execution completed.");
    }
}