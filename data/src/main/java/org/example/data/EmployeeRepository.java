package org.example.data;

import org.example.core.Employee;

public class EmployeeRepository {
    private Employee[] employees;
    private int size;

    public EmployeeRepository(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        employees[size++] = employee;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee != null && employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == employee.getId()) {
                employees[i] = employee;
                break;
            }
        }
    }
}
