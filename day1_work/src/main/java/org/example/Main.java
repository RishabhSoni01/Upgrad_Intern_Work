package org.example;
import org.example.Day1.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.Day1.Employee;
import ch.qos.logback.classic.LoggerContext;

class Main{
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String args[]){


        EmployeeRepository er = new EmployeeRepository(4);

        Employee E1 = new Employee(1,"shubh1",22,"IT");
        er.add(E1);
        logger.info("Add object E1");


        Employee E2 = new Employee(2,"shubh1",22,"IT");
        er.add(E2);
        Employee E3 = new Employee(3,"shubh1",22,"IT");
        er.add(E3);
        Employee E4 = new Employee(4,"shubh1",22,"IT");
        er.add(E4);
        er.update(3,"shubh2",22,"IT");
        er.retrive();
        er.retrive(2);
        logger.info("All employees retrived");

    }
}