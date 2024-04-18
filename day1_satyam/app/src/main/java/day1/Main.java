package day1;
import day1.Employee;
import day1.EmployeeRepository;
import day1.log;

public class Main {
    public static void main(String[] args){
      
        Employee employee = new Employee(1, "Ramu kaka", 30, "Engineering");

       
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Age: " + employee.getAge());
        System.out.println("Employee Department: " + employee.getDepartment());


                EmployeeRepository repository = new EmployeeRepository();


                repository.addEmployee(new Employee(101, "Ramu Kaka", 30, "Engineering"));
                repository.addEmployee(new Employee(102, "Shyamu Kaka", 28, "Marketing"));
                repository.addEmployee(new Employee(103, "Mohan kaka", 35, "HR"));
                log.logger.info("Added employees to the repository.");

        // Retrieving employees by different parameters
                int employeeId = 101;
                String employeeName = "Shyamu Kaka";

                Employee byId = repository.getEmployee(employeeId);
                Employee byName = repository.getEmployee(employeeName);

                if (byId != null) {
                    System.out.println("Employee found by ID: " + byId.getName());
                } else {
                    System.out.println("Employee with ID " + employeeId + " not found.");
                }

                if (byName != null) {
                    System.out.println("Employee found by Name: " + byName.getId());
                } else {
                    System.out.println("Employee with Name " + employeeName + " not found.");
                }


                log.logger.info("Program execution completed.");
            }







}

