package org.example.app;

import org.example.core.Employee;
import org.example.data.EmployeeRepository;
import org.example.log.EmployeeLogger;

public class Application {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository(10);

        Employee employee1 = new Employee(1, "John", 30, "Sales");
        repository.addEmployee(employee1);
        EmployeeLogger.logEmployeeAddition(employee1);

        Employee employee2 = new Employee(2, "Jane", 28, "Marketing");
        repository.addEmployee(employee2);
        EmployeeLogger.logEmployeeAddition(employee2);


        Employee retrievedEmployee = repository.getEmployeeById(1);
        if (retrievedEmployee != null) {
            EmployeeLogger.logEmployeeRetrieval(retrievedEmployee.getId());
            System.out.println("Retrieved Employee: " + retrievedEmployee.getName());
        } else {
            System.out.println("Employee not found");
        }


        if (retrievedEmployee != null) {
            retrievedEmployee.setAge(31);
            repository.updateEmployee(retrievedEmployee);
            EmployeeLogger.logEmployeeUpdate(retrievedEmployee);
            System.out.println("Employee information updated");
        }
    }
}
