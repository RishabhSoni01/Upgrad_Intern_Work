package org.example.Day1.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class EmployeeRepository {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public EmployeeRepository() {
        employees = new Employee[INITIAL_CAPACITY];
        size = 0;
    }

    public void addEmployee(Employee emp) {
        if (size == employees.length) {
            Employee[] newArray = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, newArray, 0, employees.length);
            employees = newArray;
        }
        employees[size++] = emp;
        logger.info("Employee added: {}", emp.getName());
    }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                logger.info("Employee retrieved by ID: {}", id);
                return emp;
            }
        }
        logger.warn("Employee not found with ID: {}", id);
        return null;
    }

    public Employee getEmployeeByName(String name) {
        for (Employee emp : employees) {
            if (emp != null && emp.getName().equals(name)) {
                logger.info("Employee retrieved by name: {}", name);
                return emp;
            }
        }
        logger.warn("Employee not found with name: {}", name);
        return null;
    }

    public Employee[] getEmployeesByDepartment(String department) {
        Employee[] result = new Employee[size];
        int index = 0;
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment().equals(department)) {
                result[index++] = emp;
            }
        }
        return Arrays.copyOf(result, index);
    }

    public void updateEmployee(Employee emp) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == emp.getId()) {
                employees[i] = emp;
                logger.info("Employee updated: {}", emp.getName());
                break;
            }
        }
    }

    public int getSize() {
        return size;
    }
}
