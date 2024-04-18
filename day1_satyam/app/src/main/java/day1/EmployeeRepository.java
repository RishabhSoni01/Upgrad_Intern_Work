package day1;

public class EmployeeRepository {
    private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    // Constructor
    public EmployeeRepository() {
        employees = new Employee[INITIAL_CAPACITY];
        size = 0;
    }


    public void addEmployee(Employee employee) {
        employees[size++] = employee;
    }

    // Method to retrieve an employee by ID
    public Employee getEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null; 
    }

    // Method to retrieve an employee by name
    public Employee getEmployee(String name) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getName().equals(name)) {
                return employees[i];
            }
        }
        return null; 
    }

    // Method to update an employee's information
    public boolean updateEmployee(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == employee.getId()) {
                employees[i] = employee;
                return true; 
            }
        }
        return false;
    }

  
}
