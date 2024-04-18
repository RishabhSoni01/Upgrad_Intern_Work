package org.example.data;

import org.example.core.Employee;
import org.example.logging.Log;

public class EmployeeRepository {
    private Employee[] employees;
    private int index;

    public EmployeeRepository(int size) {
        employees = new Employee[size];
        index = 0;
    }

    public void addEmployee(Employee e) {
        if (index < employees.length) {
            employees[index] = e;
            Log.logEmployeeAddition(e);
            index++;
        } else {
            Log.logger.warn("Cannot add employee; repository is full.");
        }
    }

    public Employee getEmployee(int id) {
        for (Employee e : employees) {
            if (e != null && e.getId() == id) {
                Log.logEmployeeRetrieval(id);
                return e;
            }
        }
        return null;
    }

    public Employee[] getEmployeesByName(String name) {
        Employee[] matchingEmployees = new Employee[index];
        int matchCount = 0;

        for (int i = 0; i < index; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) {
                matchingEmployees[matchCount] = employees[i];
                matchCount++;
            }
        }

        Employee[] result = new Employee[matchCount];
        System.arraycopy(matchingEmployees, 0, result, 0, matchCount);
        return result;
    }

    public void updateEmployee(int id, Employee e) {
        Employee employee = getEmployee(id);
        if (employee != null) {
            employee.setName(e.getName());
            employee.setDepartment(e.getDepartment());
            employee.setAge(e.getAge());
            Log.logEmployeeUpdate(e);
        } else {
            Log.logger.warn("Cannot update employee; ID = {} not found.", id);
        }
    }

    public void printAllEmployees() {
        for (int i = 0; i < index; i++) {
            Employee e = employees[i];
            if (e != null) {
                Log.logger.info("Employee ID: {}, Name: {}, Age: {}, Department: {}", e.getId(), e.getName(), e.getAge(), e.getDepartment());
            }
        }
    }
}